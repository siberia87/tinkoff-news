package com.redmadrobot.tinkoffnews.model.business;

import com.redmadrobot.tinkoffnews.entity.server.NewsContent;
import com.redmadrobot.tinkoffnews.model.repository.NewsContentRepository;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by s.salnikov on 09/07/17
 */
public class NewsContentInteractor {
    private final NewsContentRepository mNewsContentRepository;

    public NewsContentInteractor(final NewsContentRepository newsContentRepository) {
        mNewsContentRepository = newsContentRepository;
    }

    public Observable<NewsContent> getNewsContent(String newsId) {
        return mNewsContentRepository.getNewsContent(newsId);
    }
}
