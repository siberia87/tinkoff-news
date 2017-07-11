package com.redmadrobot.tinkoffnews.ui.newscontent;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.redmadrobot.tinkoffnews.R;
import com.redmadrobot.tinkoffnews.presentations.newscontent.NewsContentPresenter;
import com.redmadrobot.tinkoffnews.presentations.newscontent.NewsContentView;
import com.redmadrobot.tinkoffnews.ui.global.BaseFragment;

/**
 * Created by s.salnikov on 10/07/17
 */
public class NewsContentFragment extends BaseFragment implements NewsContentView {
    @InjectPresenter
    NewsContentPresenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_content;
    }

    private static final String ARGS_PARAM_NEWS_ID = "args_param_news_id";

    public static NewsContentFragment newInstance(final String newsId) {
        final Bundle bundle = new Bundle();
        final NewsContentFragment newsContentFragment = new NewsContentFragment();
        bundle.putString(ARGS_PARAM_NEWS_ID, newsId);
        newsContentFragment.setArguments(bundle);

        return newsContentFragment;
    }

    @Override
    public void onBackPressed() {
        mPresenter.onBackPressed();
    }
}
