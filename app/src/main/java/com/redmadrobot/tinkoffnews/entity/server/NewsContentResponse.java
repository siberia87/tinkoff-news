package com.redmadrobot.tinkoffnews.entity.server;

import com.google.gson.annotations.SerializedName;

/**
 * Created by s.salnikov on 10/07/17
 * Эта модель соотвествует ответу на запрос https://api.tinkoff.ru/v1/news_content?id={ payload[i].id}
 */
public class NewsContentResponse {
    @SerializedName("resultCode")
    private String mResultCode;
    @SerializedName("payload")
    private NewsContent mPayload;
    @SerializedName("trackingId")
    private String mTrackingId;

    public String getResultCode() {
        return mResultCode;
    }

    public NewsContent getPayload() {
        return mPayload;
    }

    public String getTrackingId() {
        return mTrackingId;
    }
}
