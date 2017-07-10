package com.redmadrobot.tinkoffnews.entity.database;

import com.redmadrobot.tinkoffnews.entity.server.News;
import com.redmadrobot.tinkoffnews.entity.server.PublicationDate;

import co.uk.rushorm.core.RushObject;

/**
 * Created by s.salnikov on 10/07/17
 */
public class NewsCache extends RushObject {
    private final long mId;
    private final String mName;
    private final String mText;
    private final PublicationDateCache mPublicationDateCache;
    private final int mBankInfoTypeId;

    public NewsCache(final News news) {
        mId = news.getId();
        mName = news.getName();
        mText = news.getText();
        mPublicationDateCache = new PublicationDateCache(news.getPublicationDate());
        mBankInfoTypeId = news.getBankInfoTypeId();
    }

    public News map() {
        return new News(mId, mName, mText, new PublicationDate(mPublicationDateCache), mBankInfoTypeId);
    }
}
