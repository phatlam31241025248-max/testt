package com.example.myapplication;


import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;



public class StudentListActivity extends AppCompatActivity {


    private TextView tvList;


    private DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_student_list);



        tvList =
                findViewById(R.id.tvList);



        databaseHelper =
                new DatabaseHelper(this);




        ArrayList<Student> list =
                databaseHelper.getAllStudents();




        StringBuilder builder =
                new StringBuilder();




        for(Student student : list){



            builder.append(
                            "ID: "
                    )
                    .append(student.getId())

                    .append("\n");


            builder.append(
                            "Name: "
                    )
                    .append(student.getName())

                    .append("\n");


            builder.append(
                            "Email: "
                    )
                    .append(student.getEmail())

                    .append("\n");


            builder.append(
                            "Telephone: "
                    )
                    .append(student.getTelephone())

                    .append("\n\n");


        }



        tvList.setText(
                builder.toString()
        );


    }


}