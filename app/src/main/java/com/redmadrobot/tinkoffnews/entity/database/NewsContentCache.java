package com.redmadrobot.tinkoffnews.entity.database;

import com.redmadrobot.tinkoffnews.entity.server.NewsContent;

import co.uk.rushorm.core.RushObject;

/**
 * Created by s.salnikov on 11/07/17
 */
public class NewsContentCache extends RushObject {
    private String mId;
    private String mContent;

    public NewsContentCache() {
        super();
    }

    public NewsContentCache(final NewsContent newsContent) {
        mContent = newsContent.getContent();
        mId = newsContent.getTitle().getId();
    }

    public static NewsContent map(final NewsContentCache newsContentCache) {
        return new NewsContent(null, newsContentCache.mContent);
    }
}
