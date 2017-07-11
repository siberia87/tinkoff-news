package com.redmadrobot.tinkoffnews.presentations.newscontent;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.redmadrobot.tinkoffnews.entity.server.NewsContent;

/**
 * Created by s.salnikov on 10/07/17
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface NewsContentView extends MvpView {
    void showProgress(Boolean show);

    void showNewsContent(NewsContent newsContent);
}
