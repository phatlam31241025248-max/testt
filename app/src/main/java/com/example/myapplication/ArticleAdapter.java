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


    private Context context;

    private ArrayList<Article> articleList;



    public ArticleAdapter(Context context,
                          ArrayList<Article> articleList){

        this.context = context;

        this.articleList = articleList;

    }



    @Override
    public int getCount(){

        return articleList.size();

    }



    @Override
    public Object getItem(int position){

        return articleList.get(position);

    }



    @Override
    public long getItemId(int position){

        return position;

    }



    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent){


        if(convertView == null){

            convertView =
                    LayoutInflater.from(context)
                            .inflate(
                                    R.layout.item_article,
                                    parent,
                                    false
                            );

        }



        TextView tvTitle =
                convertView.findViewById(
                        R.id.tvTitle
                );


        TextView tvContent =
                convertView.findViewById(
                        R.id.tvContent
                );


        TextView tvViews =
                convertView.findViewById(
                        R.id.tvViews
                );


        ImageView imgCover =
                convertView.findViewById(
                        R.id.imgCover
                );



        Article article =
                articleList.get(position);



        tvTitle.setText(
                article.getTitle()
        );


        tvContent.setText(
                article.getContent()
        );


        tvViews.setText(
                "Views: "
                        + article.getViews()
        );


        imgCover.setImageResource(
                article.getImgCover()
        );



        return convertView;

    }


}