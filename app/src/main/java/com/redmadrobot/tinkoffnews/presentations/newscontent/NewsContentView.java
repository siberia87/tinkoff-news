package com.redmadrobot.tinkoffnews.presentations.newscontent;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by s.salnikov on 10/07/17
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface NewsContentView extends MvpView {

}
