package com.redmadrobot.tinkoffnews.dagger.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.BaseRouter;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;

/**
 * Created by s.salnikov on 08/07/17
 */
@Module
public class AppModule {

    private final Context mContext;
    private final Cicerone mCicerone = Cicerone.create();

    public AppModule(final Context context) {
        mContext = context;
    }

    @Singleton
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    BaseRouter provideRouter() {
        return mCicerone.getRouter();
    }

    @Singleton
    @Provides
    NavigatorHolder provideNavigatorHolder() {
        return mCicerone.getNavigatorHolder();
    }

}
