package com.redmadrobot.tinkoffnews.dagger.module;

import com.redmadrobot.tinkoffnews.model.business.NewsContentInteractor;
import com.redmadrobot.tinkoffnews.model.data.ServerApi;
import com.redmadrobot.tinkoffnews.model.repository.NewsContentRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by s.salnikov on 11/07/17
 */
@Module
public class NewsContentModule {
    @Provides
    NewsContentRepository provideNewsContentRepository(ServerApi serverApi) {
        return new NewsContentRepository(serverApi);
    }

    @Provides
    NewsContentInteractor provideNewsContentInteractor(NewsContentRepository newsContentRepository) {
        return new NewsContentInteractor(newsContentRepository);
    }
}
