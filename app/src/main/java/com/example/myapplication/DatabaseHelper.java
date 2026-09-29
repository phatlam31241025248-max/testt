package com.example.myapplication;


import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME =
            "StudentDatabase";


    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_NAME =
            "Student";


    private static final String COLUMN_ID =
            "id";


    private static final String COLUMN_NAME =
            "name";


    private static final String COLUMN_EMAIL =
            "email";


    private static final String COLUMN_TELEPHONE =
            "telephone";



    public DatabaseHelper(Context context){

        super(
                context,
                DATABASE_NAME,
                null,
                DATABASE_VERSION
        );

    }




    @Override
    public void onCreate(SQLiteDatabase db){


        String sql =
                "CREATE TABLE "
                        + TABLE_NAME
                        + "("

                        + COLUMN_ID
                        + " TEXT PRIMARY KEY,"

                        + COLUMN_NAME
                        + " TEXT,"

                        + COLUMN_EMAIL
                        + " TEXT,"

                        + COLUMN_TELEPHONE
                        + " TEXT"

                        + ")";


        db.execSQL(sql);


    }





    @Override
    public void onUpgrade(
            SQLiteDatabase db,
            int oldVersion,
            int newVersion){


        db.execSQL(
                "DROP TABLE IF EXISTS "
                        + TABLE_NAME
        );


        onCreate(db);

    }





    // SAVE SQLITE

    public boolean saveStudent(Student student){


        SQLiteDatabase db =
                getWritableDatabase();



        ContentValues values =
                new ContentValues();



        values.put(
                COLUMN_ID,
                student.getId()
        );


        values.put(
                COLUMN_NAME,
                student.getName()
        );


        values.put(
                COLUMN_EMAIL,
                student.getEmail()
        );


        values.put(
                COLUMN_TELEPHONE,
                student.getTelephone()
        );



        long result =
                db.insertWithOnConflict(
                        TABLE_NAME,
                        null,
                        values,
                        SQLiteDatabase.CONFLICT_REPLACE
                );


        db.close();



        return result != -1;


    }





    // LOAD TẤT CẢ STUDENT


    public ArrayList<Student> getAllStudents(){


        ArrayList<Student> list =
                new ArrayList<>();



        SQLiteDatabase db =
                getReadableDatabase();



        Cursor cursor =
                db.rawQuery(
                        "SELECT * FROM "
                                + TABLE_NAME,
                        null
                );



        while(cursor.moveToNext()){



            String id =
                    cursor.getString(0);



            String name =
                    cursor.getString(1);



            String email =
                    cursor.getString(2);



            String telephone =
                    cursor.getString(3);




            Student student =
                    new Student(
                            id,
                            name,
                            email,
                            telephone
                    );



            list.add(student);

        }



        cursor.close();

        db.close();



        return list;

    }


}