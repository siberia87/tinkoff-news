package com.redmadrobot.tinkoffnews.entity.server;

import com.google.gson.annotations.SerializedName;

/**
 * Created by s.salnikov on 10/07/17
 */
public class NewsContent {
    @SerializedName("title")
    private News mTitle;
    @SerializedName("content")
    private String mContent;

    public NewsContent(final News title, final String content) {
        mTitle = title;
        mContent = content;
    }
    public News getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }
}
