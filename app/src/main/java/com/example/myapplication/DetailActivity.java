package com.example.myapplication;


import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;



public class DetailActivity extends AppCompatActivity {


    TextView tvDetailTitle;

    TextView tvDetailContent;

    TextView tvDetailViews;


    ImageView imgDetailCover;



    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_detail);




        tvDetailTitle =
                findViewById(R.id.tvDetailTitle);



        tvDetailContent =
                findViewById(R.id.tvDetailContent);



        tvDetailViews =
                findViewById(R.id.tvDetailViews);



        imgDetailCover =
                findViewById(R.id.imgDetailCover);




        Article article =
                (Article)getIntent()
                        .getSerializableExtra(
                                "ARTICLE"
                        );




        if(article != null){


            tvDetailTitle.setText(
                    article.getTitle()
            );


            tvDetailContent.setText(
                    article.getContent()
            );


            tvDetailViews.setText(
                    "Views: "
                            + article.getViews()
            );


            imgDetailCover.setImageResource(
                    article.getImgCover()
            );


        }


    }

}