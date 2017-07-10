package com.redmadrobot.tinkoffnews.entity.server;

import com.google.gson.annotations.SerializedName;

/**
 * Created by s.salnikov on 09/07/17
 */
public class News {
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("text")
    private String mText;
    @SerializedName("publicationDate")
    private PublicationDate mPublicationDate;
    @SerializedName("bankInfoTypeId")
    private int mBankInfoTypeId;

    public News(final String id,
                final String name,
                final String text,
                final PublicationDate publicationDate,
                final int bankInfoTypeId) {
        mId = id;
        mName = name;
        mText = text;
        mPublicationDate = publicationDate;
        mBankInfoTypeId = bankInfoTypeId;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getText() {
        return mText;
    }

    public PublicationDate getPublicationDate() {
        return mPublicationDate;
    }

    public int getBankInfoTypeId() {
        return mBankInfoTypeId;
    }
}
