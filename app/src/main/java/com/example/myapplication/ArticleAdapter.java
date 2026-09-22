package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticleAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Article> articleList;

    public ArticleAdapter(Context context, ArrayList<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @Override
    public int getCount() {
        return articleList.size();
    }

    @Override
    public Object getItem(int position) {
        return articleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {

            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_article, parent, false);

            holder = new ViewHolder();

            holder.tvTitle =
                    convertView.findViewById(R.id.tvTitle);

            holder.tvContent =
                    convertView.findViewById(R.id.tvContent);

            holder.tvViews =
                    convertView.findViewById(R.id.tvViews);

            holder.imgCover =
                    convertView.findViewById(R.id.imgCover);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        Article article = articleList.get(position);

        holder.tvTitle.setText(article.getTitle());

        holder.tvContent.setText(article.getContent());

        holder.tvViews.setText(
                "Views: " + article.getViews()
        );

        holder.imgCover.setImageResource(
                article.getImgCover()
        );

        return convertView;
    }

    static class ViewHolder {

        TextView tvTitle;
        TextView tvContent;
        TextView tvViews;
        ImageView imgCover;
    }
}