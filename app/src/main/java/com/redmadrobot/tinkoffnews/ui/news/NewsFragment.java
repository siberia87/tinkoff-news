package com.redmadrobot.tinkoffnews.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.redmadrobot.tinkoffnews.R;
import com.redmadrobot.tinkoffnews.entity.server.News;
import com.redmadrobot.tinkoffnews.presentations.news.NewsPresenter;
import com.redmadrobot.tinkoffnews.presentations.news.NewsView;
import com.redmadrobot.tinkoffnews.ui.global.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * Created by s.salnikov on 09/07/17
 */
public class NewsFragment extends BaseFragment implements NewsView {
    @InjectPresenter
    NewsPresenter mPresenter;

    @BindView(R.id.newsRecyclerView)
    RecyclerView mNewsRecyclerView;

    private NewsAdapter mNewsAdapter;

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mNewsAdapter = new NewsAdapter();
        mNewsRecyclerView.setHasFixedSize(true);
        mNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsRecyclerView.setAdapter(mNewsAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void showNews(final List<News> newsList) {
        mNewsAdapter.setDate(newsList);
    }

    @Override
    public void showProgress(final Boolean show) {
        showProgressDialog(show);
    }
}
