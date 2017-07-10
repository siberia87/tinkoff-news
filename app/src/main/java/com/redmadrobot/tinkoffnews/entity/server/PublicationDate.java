package com.redmadrobot.tinkoffnews.entity.server;

import com.google.gson.annotations.SerializedName;
import com.redmadrobot.tinkoffnews.entity.database.PublicationDateCache;

/**
 * Created by s.salnikov on 09/07/17
 */
public class PublicationDate {
    @SerializedName("mMilliseconds")
    private Long mMilliseconds;

    public PublicationDate(final PublicationDateCache publicationDateCache) {
        mMilliseconds = publicationDateCache.getMilliseconds();
    }

    public Long getMilliseconds() {
        return mMilliseconds;
    }
}
