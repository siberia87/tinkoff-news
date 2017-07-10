package com.redmadrobot.tinkoffnews.presentations.news;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.redmadrobot.tinkoffnews.entity.server.News;

import java.util.List;

/**
 * Created by s.salnikov on 09/07/17
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface NewsView extends MvpView {
    void showProgress(Boolean show);

    void showNews(List<News> newsList);
}
