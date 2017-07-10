package com.redmadrobot.tinkoffnews.dagger;

import android.content.Context;

import com.redmadrobot.tinkoffnews.dagger.component.AppComponent;
import com.redmadrobot.tinkoffnews.dagger.component.DaggerAppComponent;
import com.redmadrobot.tinkoffnews.dagger.module.AppModule;

/**
 * Created by s.salnikov on 08/07/17
 */
public class Dagger {
    private final AppComponent mAppComponent;

    public Dagger(final Context context) {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(context))
                .build();

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
