package com.redmadrobot.tinkoffnews.entity.server;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by s.salnikov on 09/07/17
 * Объект который приходит по запросу всех новостей https://api.tinkoff.ru/v1/news
 */
public class NewsResponse {
    @SerializedName("resultCode")
    private String mResultCode;

    @SerializedName("payload")
    List<News> mNewsList;

    @SerializedName("trackingId")
    String mTrackingId;

    public String getResultCode() {
        return mResultCode;
    }

    public List<News> getNewsList() {
        return mNewsList;
    }

    public String getTrackingId() {
        return mTrackingId;
    }
}
