package com.example.basantakandel.foodtonutrition;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private  EditText Password;
    private Button Login;
    private TextView Register;
    private  TextView Forget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.userName);
        Password=(EditText)findViewById(R.id.password);
        Login= (Button)findViewById(R.id.login);
        Register=(TextView) findViewById(R.id.register);
        Forget= (TextView) findViewById(R.id.forget);

        Forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,ForgetActivity.class);
                startActivity(intent);



            }
        });





        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Session session = new Session(MainActivity.this);
                String name=Name.getText().toString();
                session.setusename(name);


                if(!Name.getText().toString().isEmpty()){
                    if(!Password.getText().toString().isEmpty()){
                        validate( (Name.getText()).toString().trim(), (Password.getText()).toString().trim());


                    }else {
                        Toast.makeText(MainActivity.this,"Password Field Is Empty",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Name Field Is Empty",Toast.LENGTH_LONG).show();

                }



            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(intent);

            }
        });




    }

//    private void validate2(String userName,String userPassword, String email){
//
//        DatabaseHelper db= new DatabaseHelper(this);
//        db.insertIntoSignUpTable(userName,userPassword,email);
//        Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
//
//
//    }



    private  void  validate(String userName,String userPassword){
       // List<String> usernameList= new ArrayList<>();
        String password;
        DatabaseHelper db= new DatabaseHelper(this);
        //usernameList=db.getAllUserNameFromDatabase();

        password =db.getSpecificColumnValueOnMatching(DatabaseHelper.signUpTableName, DatabaseHelper.username, userName.trim());

        if(userPassword.equals(password.trim())) {



            Intent intent= new Intent(MainActivity.this,MenuActivity.class);
            startActivity(intent);


        }else{
            Toast.makeText(MainActivity.this,
                    "Incorrect Password Or Name", Toast.LENGTH_LONG).show();

        }





    }

    private void validate3(String userName, String userPassword){




        RegistrationDBHelper rDbHelper = new RegistrationDBHelper(getBaseContext());
        SQLiteDatabase db = rDbHelper.getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                FeedEntry.COLUMN_NAME_TITLE,
                FeedEntry.COLUMN_NAME_SUBTITLE
        };
        String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArgs = {userName};


// How you want the results sorted in the resulting Cursor
       // String sortOrder =
             //   FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";

        Cursor cursor = db.query(
                FeedEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
         String item=null;
        //List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            //long itemId = cursor.getLong(
                  //  cursor.getColumnIndexOrThrow(FeedEntry._ID));

             item=cursor.getString(cursor.getColumnIndex(FeedEntry.COLUMN_NAME_SUBTITLE));

            Toast.makeText(MainActivity.this,item.toString() , Toast.LENGTH_LONG).show();
        }
        cursor.close();

        //for(Object x: itemIds){


        //}

        try {
           // Toast.makeText(MainActivity.this,itemIds() , Toast.LENGTH_LONG).show();
        }catch (Exception e){

           // Toast.makeText(MainActivity.this,"Here Error" , Toast.LENGTH_LONG).show();
        }




       if(userPassword.equals(item.toString())) {
            Intent intent= new Intent(MainActivity.this,MenuActivity.class);
            startActivity(intent);


        }else{
           Toast.makeText(MainActivity.this,
                   userName+"Or"+userPassword+"Is Incorrect", Toast.LENGTH_LONG).show();

       }
    }
}
