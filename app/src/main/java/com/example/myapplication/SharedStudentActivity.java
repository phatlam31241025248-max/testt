package com.example.myapplication;


import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;



public class SharedStudentActivity extends AppCompatActivity {


    private TextView tvStudent;


    private SharedPreferenceHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(
                R.layout.activity_shared_student
        );



        tvStudent =
                findViewById(
                        R.id.tvStudent
                );



        helper =
                new SharedPreferenceHelper(this);




        Student student =
                helper.loadStudent();




        if(student != null){



            tvStudent.setText(

                    "ID: "
                            + student.getId()

                            + "\n\nName: "
                            + student.getName()

                            + "\n\nEmail: "
                            + student.getEmail()

                            + "\n\nTelephone: "
                            + student.getTelephone()

            );

        }



    }


}