package com.redmadrobot.tinkoffnews.presentations.newscontent;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.redmadrobot.tinkoffnews.App;
import com.redmadrobot.tinkoffnews.presentations.news.NewsView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by s.salnikov on 10/07/17
 */
@InjectViewState
public class NewsContentPresenter extends MvpPresenter<NewsContentView> {
    @Inject
    Router mRouter;

    public NewsContentPresenter() {
        App.getInstance().getDagger().getAppComponent().inject(this);
    }

    public void onBackPressed() {
        mRouter.exit();
    }
}
