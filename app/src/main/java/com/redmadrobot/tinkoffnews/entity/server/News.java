package com.redmadrobot.tinkoffnews.entity.server;

import com.google.gson.annotations.SerializedName;

/**
 * Created by s.salnikov on 09/07/17
 */
public class News {
    @SerializedName("mId")
    private Long mId;
    @SerializedName("mName")
    private String mName;
    @SerializedName("mText")
    private String mText;
    @SerializedName("mPublicationDate")
    private PublicationDate mPublicationDate;
    @SerializedName("mBankInfoTypeId")
    private int mBankInfoTypeId;

    public News(final Long id,
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

    public Long getId() {
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
