package com.redmadrobot.tinkoffnews.ui.news;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redmadrobot.tinkoffnews.R;
import com.redmadrobot.tinkoffnews.entity.server.News;
import com.redmadrobot.tinkoffnews.ui.global.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by s.salnikov on 10/07/17
 */
public class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<News> mDate;

    public NewsAdapter() {
        mDate = new ArrayList<>();
    }

    public void setDate(final List<News> date) {
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
        newsViewHolder.mTextNews.setText(Html.fromHtml(news.getText()));
    }

    @Override
    public int getItemCount() {
        return mDate.size();
    }

    static class NewsViewHolder extends BaseViewHolder {
        @BindView(R.id.textNews)
        TextView mTextNews;

        public NewsViewHolder(final View itemView) {
            super(itemView);
        }
    }
}
