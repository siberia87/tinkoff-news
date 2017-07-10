package com.redmadrobot.tinkoffnews.dagger.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by s.salnikov on 08/07/17
 */
@Module
public class AppModule {
    private final Context mContext;
    private final Cicerone<Router> mCicerone;

    public AppModule(final Context context) {
        mContext = context;
        mCicerone = Cicerone.create();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    Router provideRouter() {
        return mCicerone.getRouter();
    }

    @Singleton
    @Provides
    NavigatorHolder provideNavigatorHolder() {
        return mCicerone.getNavigatorHolder();
    }

}
