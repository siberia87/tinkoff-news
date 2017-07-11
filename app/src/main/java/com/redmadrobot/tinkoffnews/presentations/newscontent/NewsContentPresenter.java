package com.redmadrobot.tinkoffnews.presentations.newscontent;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.redmadrobot.tinkoffnews.App;
import com.redmadrobot.tinkoffnews.model.business.NewsContentInteractor;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by s.salnikov on 10/07/17
 */
@InjectViewState
public class NewsContentPresenter extends MvpPresenter<NewsContentView> {
    @Inject
    Router mRouter;

    @Inject
    NewsContentInteractor mNewsContentInteractor;

    private final String mNewsId;


    public NewsContentPresenter(final String newsId) {
        App.getInstance().getDagger().getAppComponent().inject(this);
        mNewsId = newsId;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        loadNewsContent();
    }

    private void loadNewsContent() {
        mNewsContentInteractor.getNewsContent(mNewsId)
                .doOnSubscribe(onSubscribe -> getViewState().showProgress(false))
                .doOnNext(onNext -> getViewState().showProgress(false))
                .subscribe(
                        newsContent -> getViewState().showNewsContent(newsContent),
                        error -> Log.d("hui", error.getMessage())
                );
    }

    public void onBackPressed() {
        mRouter.exit();
    }
}
