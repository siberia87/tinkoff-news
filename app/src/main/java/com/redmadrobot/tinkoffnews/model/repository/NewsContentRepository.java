package com.redmadrobot.tinkoffnews.model.repository;

import com.redmadrobot.tinkoffnews.entity.server.NewsContent;
import com.redmadrobot.tinkoffnews.model.data.ServerApi;

import io.reactivex.Observer;

/**
 * Created by s.salnikov on 09/07/17
 */
public class NewsContentRepository {
    private final ServerApi mServerApi;

    public NewsContentRepository(final ServerApi serverApi) {
        mServerApi = serverApi;
    }

//    public Observer<NewsContent> getNewsContent(String newsId) {
//    }
}
