package com.redmadrobot.tinkoffnews.entity.database;

import com.redmadrobot.tinkoffnews.entity.server.PublicationDate;

import co.uk.rushorm.core.RushObject;

/**
 * Created by s.salnikov on 10/07/17
 */
public class PublicationDateCache extends RushObject {
    private final Long mMilliseconds;

    public PublicationDateCache(final PublicationDate publicationDate) {
        mMilliseconds = publicationDate.getMilliseconds();
    }

    public Long getMilliseconds() {
        return mMilliseconds;
    }
}
