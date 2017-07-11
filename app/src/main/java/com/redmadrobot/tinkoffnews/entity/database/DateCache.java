package com.redmadrobot.tinkoffnews.entity.database;

import com.redmadrobot.tinkoffnews.entity.server.Date;

import co.uk.rushorm.core.RushObject;

/**
 * Created by s.salnikov on 10/07/17
 */
public class DateCache extends RushObject {
    private Long mMilliseconds;

    public DateCache() {
        super();
    }

    public DateCache(final Date date) {
        mMilliseconds = date.getMilliseconds();
    }

    public Long getMilliseconds() {
        return mMilliseconds;
    }
}
