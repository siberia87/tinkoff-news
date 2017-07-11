package com.redmadrobot.tinkoffnews.entity.server;

import com.google.gson.annotations.SerializedName;
import com.redmadrobot.tinkoffnews.entity.database.DateCache;

/**
 * Created by s.salnikov on 09/07/17
 */
public class Date {
    @SerializedName("milliseconds")
    private Long mMilliseconds;

    public Date(final DateCache dateCache) {
        mMilliseconds = dateCache.getMilliseconds();
    }

    public Long getMilliseconds() {
        return mMilliseconds;
    }
}
