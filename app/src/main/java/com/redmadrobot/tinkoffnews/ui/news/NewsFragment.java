package com.redmadrobot.tinkoffnews.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private NewsAdapter mNewsAdapter;

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRecyclerView();
        initSwipeRefreshLayout();
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            mPresenter.onSwipePullToRefresh();
        });
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    private void initRecyclerView() {
        mNewsAdapter = new NewsAdapter(news -> {
            mPresenter.onNewsItemClicked(news);
        });
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
    public void showRefreshing(final boolean state) {
        mSwipeRefreshLayout.setRefreshing(state);
    }

    @Override
    public void showError(final String message) {

    }

    @Override
    public void showProgress(final Boolean show) {
        showProgressDialog(show);
    }
}
