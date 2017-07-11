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
    private Date mDate;
    @SerializedName("bankInfoTypeId")
    private int mBankInfoTypeId;

    public News(final String id,
                final String name,
                final String text,
                final Date date,
                final int bankInfoTypeId) {
        mId = id;
        mName = name;
        mText = text;
        mDate = date;
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

    public Date getDate() {
        return mDate;
    }

    public int getBankInfoTypeId() {
        return mBankInfoTypeId;
    }
}
