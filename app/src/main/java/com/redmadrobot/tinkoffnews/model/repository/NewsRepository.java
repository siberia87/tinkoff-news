package com.redmadrobot.tinkoffnews.model.repository;

import com.redmadrobot.tinkoffnews.entity.database.NewsCache;
import com.redmadrobot.tinkoffnews.model.data.ServerApi;

import co.uk.rushorm.core.RushSearch;
import io.reactivex.Observable;

/**
 * Created by s.salnikov on 09/07/17
 */
public class NewsRepository {
    private final ServerApi mServerApi;

    public NewsRepository(final ServerApi serverApi) {
        mServerApi = serverApi;
    }

}
