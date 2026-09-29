package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    private EditText edtId;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtTelephone;


    private Button btnSaveSQLite;
    private Button btnLoadSQLite;

    private Button btnSaveShared;
    private Button btnLoadShared;



    private DatabaseHelper databaseHelper;

    private SharedPreferenceHelper sharedPreferenceHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        // ÁNH XẠ VIEW

        edtId =
                findViewById(R.id.edtId);


        edtName =
                findViewById(R.id.edtName);


        edtEmail =
                findViewById(R.id.edtEmail);


        edtTelephone =
                findViewById(R.id.edtTelephone);



        btnSaveSQLite =
                findViewById(R.id.btnSaveSQLite);


        btnLoadSQLite =
                findViewById(R.id.btnLoadSQLite);



        btnSaveShared =
                findViewById(R.id.btnSaveShared);


        btnLoadShared =
                findViewById(R.id.btnLoadShared);




        // KHỞI TẠO

        databaseHelper =
                new DatabaseHelper(this);



        sharedPreferenceHelper =
                new SharedPreferenceHelper(this);





        // =========================
        // SAVE SQLITE
        // =========================

        btnSaveSQLite.setOnClickListener(v -> {


            Student student =
                    getStudentFromInput();



            boolean result =
                    databaseHelper.saveStudent(student);



            if(result){


                Toast.makeText(
                        this,
                        "Save SQLite thành công",
                        Toast.LENGTH_SHORT
                ).show();


            }


        });






        // =========================
        // LOAD SQLITE
        // =========================

        btnLoadSQLite.setOnClickListener(v -> {


            Intent intent =
                    new Intent(
                            MainActivity.this,
                            StudentListActivity.class
                    );


            startActivity(intent);


        });







        // =========================
        // SAVE SHARED
        // =========================


        btnSaveShared.setOnClickListener(v -> {



            Student student =
                    getStudentFromInput();



            sharedPreferenceHelper.saveStudent(student);



            Toast.makeText(
                    this,
                    "Save Shared thành công",
                    Toast.LENGTH_SHORT
            ).show();



        });








        // =========================
        // LOAD SHARED
        // =========================


        btnLoadShared.setOnClickListener(v -> {



            Intent intent =
                    new Intent(
                            MainActivity.this,
                            SharedStudentActivity.class
                    );


            startActivity(intent);



        });


    }







    // LẤY DỮ LIỆU TỪ FORM

    private Student getStudentFromInput(){



        String id =
                edtId.getText()
                        .toString()
                        .trim();



        String name =
                edtName.getText()
                        .toString()
                        .trim();



        String email =
                edtEmail.getText()
                        .toString()
                        .trim();



        String telephone =
                edtTelephone.getText()
                        .toString()
                        .trim();




        return new Student(
                id,
                name,
                email,
                telephone
        );


    }



}