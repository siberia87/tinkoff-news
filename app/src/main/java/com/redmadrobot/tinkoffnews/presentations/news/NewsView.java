package com.redmadrobot.tinkoffnews.presentations.news;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by s.salnikov on 09/07/17
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface NewsView extends MvpView {
    void showProgress(Boolean show);
}
