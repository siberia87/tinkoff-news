package com.redmadrobot.tinkoffnews.presentations.launch;

import com.arellomobile.mvp.MvpPresenter;
import com.redmadrobot.tinkoffnews.App;
import com.redmadrobot.tinkoffnews.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by s.salnikov on 09/07/17
 */
public class LaunchPresenter extends MvpPresenter<LaunchView> {
    @Inject
    Router mRouter;

    public LaunchPresenter() {
        super();
        App.getInstance().getDagger().getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        mRouter.newRootScreen(Screens.NEWS_SCREEN);
    }
}
