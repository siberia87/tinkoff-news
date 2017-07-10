package com.redmadrobot.tinkoffnews.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.redmadrobot.tinkoffnews.R;
import com.redmadrobot.tinkoffnews.presentations.news.NewsPresenter;
import com.redmadrobot.tinkoffnews.presentations.news.NewsView;
import com.redmadrobot.tinkoffnews.ui.global.BaseFragment;

/**
 * Created by s.salnikov on 09/07/17
 */
public class NewsFragment extends BaseFragment implements NewsView {
    @InjectPresenter
    NewsPresenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void showProgress(final Boolean show) {
    }
}
