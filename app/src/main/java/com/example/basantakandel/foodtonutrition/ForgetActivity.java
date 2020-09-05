package com.example.basantakandel.foodtonutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetActivity extends AppCompatActivity {

    Button GetPassword;
    EditText email;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);


        GetPassword= (Button) findViewById(R.id.getPass);
          username=(EditText)findViewById(R.id.fname);
                email= (EditText)findViewById(R.id.femail);


        GetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                forgetPassword(username.getText().toString(),email.getText().toString());



            }
        });


    }
    private void forgetPassword(String username,String email){


        String efD;

        DatabaseHelper db= new DatabaseHelper(this);
        efD =db.getSpecificColumnValueOnMatching2(DatabaseHelper.signUpTableName, DatabaseHelper.username, username.trim());

        if((efD.trim()).equals(email.trim())) {

            String  password =db.getSpecificColumnValueOnMatching(DatabaseHelper.signUpTableName, DatabaseHelper.username, username.trim());

            Toast.makeText(ForgetActivity.this,"Your Password is "+password,Toast.LENGTH_LONG).show();

            Intent intent= new Intent(ForgetActivity.this,MenuActivity.class);
            startActivity(intent);


        }else{
            Toast.makeText(ForgetActivity.this,
                    efD+"Can not Reset Your password: Register Again", Toast.LENGTH_LONG).show();

        }





    }
}
