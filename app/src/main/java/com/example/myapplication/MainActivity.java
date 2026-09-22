package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listArticle;

    private ArrayList<Article> articleList;

    private ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listArticle =
                findViewById(R.id.listArticle);

        // Tạo danh sách bài viết
        articleList = new ArrayList<>();


        // =========================
        // BÀI VIẾT 1
        // =========================

        articleList.add(
                new Article(
                        "Trí tuệ nhân tạo trong cuộc sống",

                        "Trí tuệ nhân tạo đang ngày càng được ứng dụng rộng rãi "
                                + "trong học tập, công việc và đời sống. "
                                + "AI giúp con người xử lý thông tin nhanh hơn "
                                + "và hỗ trợ giải quyết nhiều vấn đề phức tạp.",

                        R.drawable.ai,

                        0
                )
        );


        // =========================
        // BÀI VIẾT 2
        // =========================

        articleList.add(
                new Article(
                        "Lập trình Android với Android Studio",

                        "Android Studio là môi trường phát triển chính thức "
                                + "dành cho Android. Công cụ này hỗ trợ lập trình viên "
                                + "thiết kế giao diện, viết mã Java hoặc Kotlin, "
                                + "chạy thử ứng dụng và kiểm tra lỗi.",

                        R.drawable.android,

                        0
                )
        );


        // =========================
        // BÀI VIẾT 3
        // =========================

        articleList.add(
                new Article(
                        "Internet và cuộc sống hiện đại",

                        "Internet đã trở thành một phần quan trọng trong cuộc sống. "
                                + "Thông qua Internet, con người có thể học tập, "
                                + "làm việc, giao tiếp và tiếp cận thông tin "
                                + "từ nhiều nơi trên thế giới.",

                        R.drawable.internet,

                        0
                )
        );


        // =========================
        // BÀI VIẾT 4
        // =========================

        articleList.add(
                new Article(
                        "Ứng dụng công nghệ trong giáo dục",

                        "Công nghệ giúp việc học trở nên linh hoạt và thuận tiện hơn. "
                                + "Sinh viên có thể học trực tuyến, sử dụng tài liệu "
                                + "điện tử và các phần mềm hỗ trợ học tập.",

                        R.drawable.education,

                        0
                )
        );


        // Tạo Adapter
        adapter = new ArticleAdapter(
                this,
                articleList
        );


        // Gắn Adapter vào ListView
        listArticle.setAdapter(adapter);


        // Xử lý khi người dùng click bài viết
        listArticle.setOnItemClickListener(
                (parent, view, position, id) -> {

                    // Lấy bài viết được click
                    Article article =
                            articleList.get(position);


                    // Tăng lượt xem lên 1
                    article.setViews(
                            article.getViews() + 1
                    );


                    // Cập nhật giao diện danh sách
                    adapter.notifyDataSetChanged();


                    // Tạo Intent mở DetailActivity
                    Intent intent =
                            new Intent(
                                    MainActivity.this,
                                    DetailActivity.class
                            );


                    // Gửi Article sang màn hình chi tiết
                    intent.putExtra(
                            "ARTICLE",
                            article
                    );


                    // Mở màn hình chi tiết
                    startActivity(intent);
                }
        );
    }


    @Override
    protected void onResume() {

        super.onResume();

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}