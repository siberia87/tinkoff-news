package com.redmadrobot.tinkoffnews.ui.newscontent;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.redmadrobot.tinkoffnews.R;
import com.redmadrobot.tinkoffnews.Utils;
import com.redmadrobot.tinkoffnews.entity.server.NewsContent;
import com.redmadrobot.tinkoffnews.presentations.newscontent.NewsContentPresenter;
import com.redmadrobot.tinkoffnews.presentations.newscontent.NewsContentView;
import com.redmadrobot.tinkoffnews.ui.global.BaseFragment;

import butterknife.BindView;

/**
 * Created by s.salnikov on 10/07/17
 */
public class NewsContentFragment extends BaseFragment implements NewsContentView {
    @InjectPresenter
    NewsContentPresenter mPresenter;

    @ProvidePresenter
    NewsContentPresenter providePresenter() {
        return new NewsContentPresenter(getArguments().getString(ARGS_PARAM_NEWS_ID));
    }

    @BindView(R.id.newsContent)
    TextView mContentNewsTextView;

    @BindView(R.id.newsContentCartView)
    CardView mNewsContentCardView;

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

    @Override
    public void showProgress(final Boolean show) {
        showProgressDialog(show);
    }

    @Override
    public void showNewsContent(final NewsContent newsContent) {
        mContentNewsTextView.setText(Utils.fromHtml(newsContent.getContent()));

//        if (newsContent.getContent() != null) {
//            mContentNewsTextView.setText(Utils.fromHtml(newsContent.getContent()));
//        } else {
//            mNewsContentCardView.setVisibility(View.GONE);
//        }
    }
}
