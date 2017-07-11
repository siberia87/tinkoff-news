package com.redmadrobot.tinkoffnews.model.data;

import com.redmadrobot.tinkoffnews.entity.server.NewsContentResponse;
import com.redmadrobot.tinkoffnews.entity.server.NewsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by s.salnikov on 09/07/17
 */
public interface ServerApi {
    @GET("news")
    Single<NewsResponse> getNews();

    @GET("news_content")
    Single<NewsContentResponse> getNewsContent(@Query("id") int newsId);
}
