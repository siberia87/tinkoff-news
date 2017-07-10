package com.redmadrobot.tinkoffnews;

import android.app.Application;

import com.redmadrobot.tinkoffnews.dagger.Dagger;

/**
 * Created by s.salnikov on 08/07/17
 */
public class App extends Application {
    private static App sInstance;
    private Dagger mDagger;

    public App() {
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
        initRushOrm();
    }

    private void initDagger() {
        mDagger = new Dagger(this);
    }

    private void initRushOrm() {
//        List<Class<? extends Rush>> classes = new ArrayList<>();

//        RushCore.initialize(new AndroidInitializeConfig(this, classes));
    }

    public Dagger getDagger() {
        return mDagger;
    }

    public static App getInstance() {
        return sInstance;
    }
}
