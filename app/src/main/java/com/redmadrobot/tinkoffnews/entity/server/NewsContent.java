package com.redmadrobot.tinkoffnews.entity.server;

import com.google.gson.annotations.SerializedName;

/**
 * Created by s.salnikov on 10/07/17
 */
public class NewsContent {
    @SerializedName("title")
    private News mTitle;
    @SerializedName("creationDate")
    private PublicationDate mCreationDate;
    @SerializedName("lastModificationDate")
    private PublicationDate mLastModificationDate;
    @SerializedName("content")
    private String mContent;
    @SerializedName("bankInfoTypeId")
    private int mBankInfoTypeId;
    @SerializedName("typeId")
    private String mTypeId;
}
