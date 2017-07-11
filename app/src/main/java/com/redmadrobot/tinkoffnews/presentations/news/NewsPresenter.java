package com.redmadrobot.tinkoffnews.presentations.news;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.redmadrobot.tinkoffnews.App;
import com.redmadrobot.tinkoffnews.Screens;
import com.redmadrobot.tinkoffnews.entity.server.News;
import com.redmadrobot.tinkoffnews.model.business.NewsInteractor;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import ru.terrakok.cicerone.Router;

/**
 * Created by s.salnikov on 09/07/17
 */
@InjectViewState
public class NewsPresenter extends MvpPresenter<NewsView> {
    @Inject
    Router mRouter;
    @Inject
    NewsInteractor mNewsInteractor;

    private final CompositeDisposable mCompositeDisposable;

    public NewsPresenter() {
        App.getInstance().getDagger().getAppComponent().inject(this);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        loadNews();
    }

    public void onSwipePullToRefresh() {
        loadBySwipePullToRefresh();
    }

    private void loadNews() {
        mNewsInteractor.getNews()
                .doOnSubscribe(disposable -> getViewState().showProgress(true))
                .doOnNext(l -> getViewState().showProgress(false))
                .subscribe(
                        newsList -> {
                            getViewState().showNews(newsList);
                        },
                        error -> {
                            Log.d("hui", error.getMessage());
                        });
    }

    private void loadBySwipePullToRefresh() {
        mNewsInteractor.getNews()
                .doOnNext(l -> getViewState().showRefreshing(false))
                .subscribe(
                        newsList -> {
                            getViewState().showNews(newsList);
                        },
                        error -> {
                            Log.d("hui", error.getMessage());
                        });
    }

    public void onNewsItemClicked(final News news) {
        mRouter.navigateTo(Screens.NEWS_CONTENT_SCREEN, news.getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mCompositeDisposable.dispose();
    }
}
