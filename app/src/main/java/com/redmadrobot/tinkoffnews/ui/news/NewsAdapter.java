package com.redmadrobot.tinkoffnews.ui.news;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redmadrobot.tinkoffnews.R;
import com.redmadrobot.tinkoffnews.Utils;
import com.redmadrobot.tinkoffnews.entity.server.News;
import com.redmadrobot.tinkoffnews.ui.global.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by s.salnikov on 10/07/17
 */
class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<News> mDate;
    private final IOnNewsItemClickListener mItemClickListener;

    NewsAdapter(final IOnNewsItemClickListener itemClickListener) {
        mDate = new ArrayList<>();
        mItemClickListener = itemClickListener;
    }

    void setDate(final List<News> date) {
        mDate.clear();
        mDate = date;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {
        bindNewsViewHolder(holder, mDate.get(position));
    }

    private void bindNewsViewHolder(final BaseViewHolder viewHolder, final News news) {
        NewsViewHolder newsViewHolder = (NewsViewHolder) viewHolder;
        newsViewHolder.mTextNews.setText(Utils.fromHtml(news.getText()));
        newsViewHolder.mNewsCardView.setOnClickListener(v -> mItemClickListener.onNewsItemClicked(news));
    }

    @Override
    public int getItemCount() {
        return mDate.size();
    }

    static class NewsViewHolder extends BaseViewHolder {
        @BindView(R.id.textNews)
        TextView mTextNews;

        @BindView(R.id.newsCardView)
        CardView mNewsCardView;

        NewsViewHolder(final View itemView) {
            super(itemView);
        }
    }
}
