package com.redmadrobot.tinkoffnews.model.repository;

import android.util.Log;

import com.redmadrobot.tinkoffnews.entity.database.NewsCache;
import com.redmadrobot.tinkoffnews.entity.database.NewsContentCache;
import com.redmadrobot.tinkoffnews.entity.server.NewsContent;
import com.redmadrobot.tinkoffnews.entity.server.NewsContentResponse;
import com.redmadrobot.tinkoffnews.model.data.ServerApi;

import java.util.ArrayList;

import co.uk.rushorm.core.RushObject;
import co.uk.rushorm.core.RushSearch;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by s.salnikov on 09/07/17
 */
public class NewsContentRepository {
    private final ServerApi mServerApi;

    public NewsContentRepository(final ServerApi serverApi) {
        mServerApi = serverApi;
    }

    public Observable<NewsContent> getNewsContent(String newsId) {

//        mServerApi.getNewsContent(Integer.parseInt(newsId))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSuccess(newsContent -> {
//                    System.out.print(newsContent.getResultCode());
//                })
//                .doOnError(error -> {
//                    Log.d("huui", error.getMessage());
//                    System.out.print(error.getMessage());
//                })
//                .subscribe();
//
//        return null;

        return Observable
                .defer(() -> {
                    NewsContentCache newsContentCache = new RushSearch().whereEqual("mId", newsId).findSingle(NewsContentCache.class);
                    return Observable.just(newsContentCache != null ? newsContentCache : new NewsContentCache());
                })
                .flatMap(
                        newsContentCaches ->
                                mServerApi.getNewsContent(Integer.parseInt(newsId))
                                        .map(NewsContentResponse::getPayload)
                                        .doOnSuccess(newsContent -> {
                                                    newsContentCaches.delete();
                                                    new NewsContentCache(newsContent).save();
                                                }
                                        )
                                        .toObservable()
                                        .startWith(NewsContentCache.map(newsContentCaches))
                )
                .materialize() //magic of Rx: https://github.com/ReactiveX/RxJava/issues/2887
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .dematerialize();
    }
}
