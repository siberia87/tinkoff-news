package com.redmadrobot.tinkoffnews.model.business;

import com.redmadrobot.tinkoffnews.entity.server.News;
import com.redmadrobot.tinkoffnews.entity.server.NewsResponse;
import com.redmadrobot.tinkoffnews.model.repository.NewsRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by s.salnikov on 09/07/17
 */
public class NewsInteractor {
    private final NewsRepository mNewsRepository;

    public NewsInteractor(final NewsRepository newsRepository) {
        mNewsRepository = newsRepository;
    }

    public Observable<List<News>> getNews() {
        return mNewsRepository.getNews();
    }
}
