package com.redmadrobot.tinkoffnews.dagger.component;

import com.redmadrobot.tinkoffnews.dagger.module.AppModule;
import com.redmadrobot.tinkoffnews.dagger.module.NetworkModule;
import com.redmadrobot.tinkoffnews.dagger.module.NewsModule;
import com.redmadrobot.tinkoffnews.presentations.launch.LaunchPresenter;
import com.redmadrobot.tinkoffnews.presentations.news.NewsPresenter;
import com.redmadrobot.tinkoffnews.presentations.newscontent.NewsContentPresenter;
import com.redmadrobot.tinkoffnews.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import ru.terrakok.cicerone.Router;

/**
 * Created by s.salnikov on 08/07/17
 */
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        NewsModule.class
})
@Singleton
public interface AppComponent {
    void inject(LaunchPresenter presenter);
    void inject(MainActivity activity);
    void inject(NewsPresenter presenter);
    void inject(NewsContentPresenter presenter);
}
