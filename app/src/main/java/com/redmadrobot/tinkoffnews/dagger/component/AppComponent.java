package com.redmadrobot.tinkoffnews.dagger.component;

import com.redmadrobot.tinkoffnews.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by s.salnikov on 08/07/17
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
}
