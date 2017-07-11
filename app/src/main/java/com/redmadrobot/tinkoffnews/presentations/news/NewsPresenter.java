package com.redmadrobot.tinkoffnews.presentations.news;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.redmadrobot.tinkoffnews.App;
import com.redmadrobot.tinkoffnews.Screens;
import com.redmadrobot.tinkoffnews.entity.server.News;
import com.redmadrobot.tinkoffnews.model.business.NewsInteractor;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by s.salnikov on 09/07/17
 */
@InjectViewState
public class NewsPresenter extends MvpPresenter<NewsView> {
    private static final String DEBUG_TAG = "news_presenter";
    @Inject
    Router mRouter;
    @Inject
    NewsInteractor mNewsInteractor;

    public NewsPresenter() {
        App.getInstance().getDagger().getAppComponent().inject(this);
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
                .doOnSubscribe(onSubscribe -> getViewState().showProgress(true))
                .doOnNext(onNext -> getViewState().showProgress(false))
                .subscribe(
                        newsList -> getViewState().showNews(newsList),
                        error -> Log.d(DEBUG_TAG, error.getMessage())
                );
    }

    private void loadBySwipePullToRefresh() {
        mNewsInteractor.getNews()
                .doOnNext(onNext -> getViewState().showRefreshing(false))
                .subscribe(
                        newsList -> getViewState().showNews(newsList),
                        error -> Log.d("hui", error.getMessage())
                );
    }

    public void onNewsItemClicked(final News news) {
        mRouter.navigateTo(Screens.NEWS_CONTENT_SCREEN, news.getId());
    }
}
