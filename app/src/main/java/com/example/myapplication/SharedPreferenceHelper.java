package com.example.myapplication;


import android.content.Context;
import android.content.SharedPreferences;



public class SharedPreferenceHelper {


    private SharedPreferences preferences;



    public SharedPreferenceHelper(Context context){


        preferences =
                context.getSharedPreferences(
                        "StudentData",
                        Context.MODE_PRIVATE
                );


    }




    // SAVE STUDENT GẦN NHẤT

    public void saveStudent(Student student){


        SharedPreferences.Editor editor =
                preferences.edit();



        editor.putString(
                "id",
                student.getId()
        );


        editor.putString(
                "name",
                student.getName()
        );


        editor.putString(
                "email",
                student.getEmail()
        );


        editor.putString(
                "telephone",
                student.getTelephone()
        );



        editor.apply();


    }





    // LOAD STUDENT GẦN NHẤT


    public Student loadStudent(){



        String id =
                preferences.getString(
                        "id",
                        ""
                );



        if(id.equals("")){

            return null;

        }




        return new Student(

                id,

                preferences.getString(
                        "name",
                        ""
                ),

                preferences.getString(
                        "email",
                        ""
                ),

                preferences.getString(
                        "telephone",
                        ""
                )

        );


    }

}