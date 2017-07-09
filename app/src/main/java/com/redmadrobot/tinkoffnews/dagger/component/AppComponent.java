package com.redmadrobot.tinkoffnews.dagger.component;

import com.redmadrobot.tinkoffnews.dagger.module.AppModule;
import com.redmadrobot.tinkoffnews.presentations.launch.LaunchPresenter;
import com.redmadrobot.tinkoffnews.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by s.salnikov on 08/07/17
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(LaunchPresenter presenter);

    void inject(MainActivity activity);
}
