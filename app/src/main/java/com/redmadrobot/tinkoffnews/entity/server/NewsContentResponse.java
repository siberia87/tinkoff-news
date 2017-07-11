package com.redmadrobot.tinkoffnews.entity.server;

import com.google.gson.annotations.SerializedName;

/**
 * Created by s.salnikov on 10/07/17
 */
public class NewsContentResponse {
    @SerializedName("resultCode")
    private String mResultCode;
    @SerializedName("payload")
    private NewsContent mPayload;
    @SerializedName("trackingId")
    private int mTrackingId;
}
