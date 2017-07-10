package com.redmadrobot.tinkoffnews.dagger.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
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
