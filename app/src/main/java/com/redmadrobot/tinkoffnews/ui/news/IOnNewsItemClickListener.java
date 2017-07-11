package com.redmadrobot.tinkoffnews.ui.news;

import com.redmadrobot.tinkoffnews.entity.server.News;

/**
 * Created by s.salnikov on 11/07/17
 */
public interface IOnNewsItemClickListener {
    void onNewsItemClicked(News news);
}
