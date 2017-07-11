package com.redmadrobot.tinkoffnews.entity.server;

import android.support.v7.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

/**
 * Created by s.salnikov on 10/07/17
 * Эта модель соотвествует значению поля payload в ответе по запросу контента новости. Она содержит не все поля вложенного объекта, но только необходимые content для отображения контента новости и title для использования его id для кеширования
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
