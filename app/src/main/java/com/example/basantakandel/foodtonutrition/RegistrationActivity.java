package com.example.basantakandel.foodtonutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
   // Name=(EditText)findViewById(R.id.userName);
   private Button RegisterUser;
   private  EditText RegName;
    private  EditText RegPassword;
    EditText Email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //RegName=(EditText)findViewById(R.id.regUser);

        RegPassword=(EditText)findViewById(R.id.regPassword);
        RegName=  (EditText)findViewById(R.id.fname);
        Email= (EditText)findViewById(R.id.femail);

        RegisterUser = (Button)findViewById(R.id.regUser);

        RegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                registerUser(RegName.getText(),Email.getText(),RegPassword.getText());
                Intent intent= new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(intent);


//                RegistrationDBHelper rDbHelper = new RegistrationDBHelper(getBaseContext());
//                SQLiteDatabase db = rDbHelper.getWritableDatabase();
//
//// Create a new map of values, where column names are the keys
//                ContentValues values = new ContentValues();
//                values.put(FeedEntry.COLUMN_NAME_TITLE,RegName.getText().toString() );
//                values.put(FeedEntry.COLUMN_NAME_SUBTITLE,RegPassword.getText().toString() );
//
//// Insert the new row, returning the primary key value of the new row
//                long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
//                Toast.makeText(RegistrationActivity.this,
//                       "DBconnected"+ RegName.getText().toString() , Toast.LENGTH_LONG).show();
//
//
//                Intent intent= new Intent(RegistrationActivity.this,MainActivity.class);
//                startActivity(intent);
            }


        });




        }
        private void registerUser(Editable name, Editable email, Editable password) {
        DatabaseHelper db= new DatabaseHelper(this);
        try {
            db.insertIntoSignUpTable(name.toString(),email.toString(),password.toString());
            Toast.makeText(RegistrationActivity.this,"New Account Created",Toast.LENGTH_LONG).show();


        }catch (Exception e){
            System.out.println(e.toString());
            Toast.makeText(RegistrationActivity.this,e.toString(),Toast.LENGTH_LONG).show();


        }




    }
}
