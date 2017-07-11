package com.redmadrobot.tinkoffnews.entity.database;

import com.redmadrobot.tinkoffnews.entity.server.News;
import com.redmadrobot.tinkoffnews.entity.server.Date;

import java.util.ArrayList;
import java.util.List;

import co.uk.rushorm.core.RushObject;

/**
 * Created by s.salnikov on 10/07/17
 */
public class NewsCache extends RushObject {
    private String mId;
    private String mName;
    private String mText;
    private DateCache mDateCache;
    private int mBankInfoTypeId;

    public NewsCache() {
        super();
    }

    public NewsCache(final News news) {
        mId = news.getId();
        mName = news.getName();
        mText = news.getText();
        mDateCache = new DateCache(news.getDate());
        mBankInfoTypeId = news.getBankInfoTypeId();
    }

    public News map() {
        return new News(
                mId,
                mName,
                mText,
                new Date(mDateCache),
                mBankInfoTypeId
        );
    }

    public static List<News> map(List<NewsCache> newsCaches) {
        if (newsCaches == null) return null;

        final List<News> destination = new ArrayList<>();

        for (NewsCache news : newsCaches) {
            destination.add(news.map());
        }

        return destination;
    }
}
