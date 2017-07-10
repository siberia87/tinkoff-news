package com.redmadrobot.tinkoffnews.model.repository;

import com.redmadrobot.tinkoffnews.entity.database.NewsCache;
import com.redmadrobot.tinkoffnews.entity.server.News;
import com.redmadrobot.tinkoffnews.model.data.ServerApi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import co.uk.rushorm.core.RushObject;
import co.uk.rushorm.core.RushSearch;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by s.salnikov on 09/07/17
 */
public class NewsRepository {
    private final ServerApi mServerApi;

    public NewsRepository(final ServerApi serverApi) {
        mServerApi = serverApi;
    }

    public Observable<List<News>> getNews() {
        return Observable
                .defer(() -> Observable.just(new RushSearch().find(NewsCache.class)))
                .flatMap(
                        newsFromCache ->
                                mServerApi.getNews()
                                        .map(response -> {
                                            Collections.sort(response.getNewsList(), new PublicationDateComparator());
                                            return response.getNewsList();
                                        })
                                        .doOnSuccess(newsList -> {
                                            newsFromCache.forEach(RushObject::delete);
                                            for (News news : newsList) {
                                                new NewsCache(news).save();
                                            }
                                        })
                                        .toObservable()
                                        .startWith(NewsCache.map(newsFromCache))
                )
                .filter(list -> !list.isEmpty())
                .materialize() //magic of Rx: https://github.com/ReactiveX/RxJava/issues/2887
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .dematerialize();
    }

    private static class PublicationDateComparator implements Comparator<News> {
        @Override
        public int compare(final News o1, final News o2) {
            return compare(
                    o1.getPublicationDate().getMilliseconds(),
                    o2.getPublicationDate().getMilliseconds()
            );
        }

        private static int compare(final long lhs, final long rhs) {
            return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
        }
    }
}
