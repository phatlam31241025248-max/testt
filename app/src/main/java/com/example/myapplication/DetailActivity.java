package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetailTitle;
    private TextView tvDetailContent;
    private TextView tvDetailViews;

    private ImageView imgDetailCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);


        // Ánh xạ View
        tvDetailTitle =
                findViewById(R.id.tvDetailTitle);

        tvDetailContent =
                findViewById(R.id.tvDetailContent);

        tvDetailViews =
                findViewById(R.id.tvDetailViews);

        imgDetailCover =
                findViewById(R.id.imgDetailCover);


        // Nhận dữ liệu từ MainActivity
        Serializable data =
                getIntent().getSerializableExtra("ARTICLE");


        if (data instanceof Article) {

            Article article = (Article) data;


            tvDetailTitle.setText(
                    article.getTitle()
            );


            tvDetailContent.setText(
                    article.getContent()
            );


            tvDetailViews.setText(
                    "Views: " + article.getViews()
            );


            imgDetailCover.setImageResource(
                    article.getImgCover()
            );
        }
    }
}