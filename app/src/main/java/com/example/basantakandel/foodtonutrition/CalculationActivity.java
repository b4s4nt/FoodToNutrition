package com.example.basantakandel.foodtonutrition;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculationActivity extends AppCompatActivity {
    ImageButton CalculateNutrition;
    EditText FoodQuantity;
    EditText FoodName;
    DatabaseHelper myDb;
    TextView Select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Session session = new Session(this);
        // session.setusename("Basanta");

        final String name2= session.getusename().toString();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        CalculateNutrition= (ImageButton)findViewById(R.id.calculateNutrition);
        FoodQuantity= (EditText)findViewById(R.id.quantity);
        FoodName=(EditText)findViewById(R.id.foodName);
        Select= (TextView)findViewById(R.id.select);



        myDb = new DatabaseHelper(CalculationActivity.this);

        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculationActivity.this,ImageDisplayActivity.class);
                startActivity(intent);

            }
        });


        CalculateNutrition.setOnClickListener(new View.OnClickListener() {

           // Double multiplier= Double.parseDouble(FoodQuantity.getText().toString());



            List<String> rowOfTable=  new ArrayList<>();
            @Override
            public void onClick(View v) {




                if(myDb.getAllFoodFromDatabase().contains(FoodName.getText().toString().trim())){


                    rowOfTable=myDb.getSpecificNutritionOnMatching(FoodName.getText().toString().trim());

                    Intent intent = new Intent(CalculationActivity.this,CalorieDisplayActivity.class);
                    intent.putExtra("N1", (Serializable) rowOfTable);
                    intent.putExtra("NAM",FoodName.getText().toString().trim());
                    intent.putExtra("MUL",FoodQuantity.getText().toString());
                    startActivity(intent);




                    Toast.makeText(CalculationActivity.this, name2+" Result Is Here", Toast.LENGTH_LONG).show();










                }else{
                    Toast.makeText(CalculationActivity.this, "Food Not In List : We will update Soon:", Toast.LENGTH_LONG).show();

                }



            }



        });

    }
}
