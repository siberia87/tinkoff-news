package com.redmadrobot.tinkoffnews.dagger.module;

import com.redmadrobot.tinkoffnews.model.business.NewsInteractor;
import com.redmadrobot.tinkoffnews.model.data.ServerApi;
import com.redmadrobot.tinkoffnews.model.repository.NewsRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by s.salnikov on 10/07/17
 */
@Module
public class NewsModule {
    @Provides
    NewsRepository provideNewsRepository(ServerApi serverApi) {
        return new NewsRepository(serverApi);
    }

    @Provides
    NewsInteractor provideNewsInteractor(NewsRepository newsRepository) {
        return new NewsInteractor(newsRepository);
    }
}
