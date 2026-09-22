package com.example.myapplication;


import android.content.Intent;

import android.os.Bundle;

import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {


    ListView listArticle;


    ArrayList<Article> articleList;


    ArticleAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);



        listArticle =
                findViewById(
                        R.id.listArticle
                );



        articleList =
                new ArrayList<>();



        articleList.add(
                new Article(
                        "Trí tuệ nhân tạo trong cuộc sống",

                        "AI đang được ứng dụng rộng rãi trong học tập và công việc.",

                        R.drawable.ai,

                        0
                )
        );



        articleList.add(
                new Article(
                        "Lập trình Android với Android Studio",

                        "Android Studio là công cụ phát triển ứng dụng Android.",

                        R.drawable.android,

                        0
                )
        );



        articleList.add(
                new Article(
                        "Internet và cuộc sống hiện đại",

                        "Internet giúp con người kết nối thông tin nhanh chóng.",

                        R.drawable.internet,

                        0
                )
        );



        articleList.add(
                new Article(
                        "Ứng dụng công nghệ trong giáo dục",

                        "Công nghệ giúp việc học hiệu quả hơn.",

                        R.drawable.education,

                        0
                )
        );




        adapter =
                new ArticleAdapter(
                        this,
                        articleList
                );



        listArticle.setAdapter(adapter);




        listArticle.setOnItemClickListener(
                (parent, view, position, id) -> {


                    Article article =
                            articleList.get(position);



                    article.setViews(
                            article.getViews()+1
                    );



                    adapter.notifyDataSetChanged();



                    Intent intent =
                            new Intent(
                                    MainActivity.this,
                                    DetailActivity.class
                            );



                    intent.putExtra(
                            "ARTICLE",
                            article
                    );



                    startActivity(intent);


                }
        );


    }



    @Override
    protected void onResume(){

        super.onResume();


        if(adapter != null){

            adapter.notifyDataSetChanged();

        }

    }

}