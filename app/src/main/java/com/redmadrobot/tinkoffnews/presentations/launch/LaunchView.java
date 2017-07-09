package com.redmadrobot.tinkoffnews.presentations.launch;

/**
 * Created by s.salnikov on 09/07/17
 */

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
public interface LaunchView extends MvpView {
}
