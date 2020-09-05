package com.example.basantakandel.foodtonutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImageDisplayActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText FoodQuantity;
    TextView FoodName;
    EditText FoodQuantity2;
    TextView FoodName2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);
       // Select= (TextView)findViewById(R.id.select);

        ImageView Bro= (ImageView)findViewById(R.id.bro);
        FoodQuantity= (EditText)findViewById(R.id.broq);
        FoodName=(TextView) findViewById(R.id.bron);
        ImageView Chi= (ImageView)findViewById(R.id.chi);
        FoodQuantity2= (EditText)findViewById(R.id.chiq);
        FoodName2=(TextView) findViewById(R.id.chin);



        myDb = new DatabaseHelper(ImageDisplayActivity.this);

        Chi.setOnClickListener(new View.OnClickListener() {
            List<String> rowOfTable=  new ArrayList<>();
            @Override
            public void onClick(View v) {




                if(myDb.getAllFoodFromDatabase().contains(FoodName2.getText().toString().trim())){


                    rowOfTable=myDb.getSpecificNutritionOnMatching(FoodName2.getText().toString().trim());

                    Intent intent = new Intent(ImageDisplayActivity.this,CalorieDisplayActivity.class);
                    intent.putExtra("N1", (Serializable) rowOfTable);
                    intent.putExtra("NAM",FoodName2.getText().toString().trim());
                    intent.putExtra("MUL",FoodQuantity2.getText().toString());
                    startActivity(intent);




                    Toast.makeText(ImageDisplayActivity.this, " Result Is Here", Toast.LENGTH_LONG).show();










                }else{
                    Toast.makeText(ImageDisplayActivity.this, "Food Not In List : We will update Soon:", Toast.LENGTH_LONG).show();

                }






            }
        });

        Bro.setOnClickListener(new View.OnClickListener() {
            List<String> rowOfTable=  new ArrayList<>();
            @Override
            public void onClick(View v) {




                if(myDb.getAllFoodFromDatabase().contains(FoodName.getText().toString().trim())){


                    rowOfTable=myDb.getSpecificNutritionOnMatching(FoodName.getText().toString().trim());

                    Intent intent = new Intent(ImageDisplayActivity.this,CalorieDisplayActivity.class);
                    intent.putExtra("N1", (Serializable) rowOfTable);
                    intent.putExtra("NAM",FoodName.getText().toString().trim());
                    intent.putExtra("MUL",FoodQuantity.getText().toString());
                    startActivity(intent);




                    Toast.makeText(ImageDisplayActivity.this, " Result Is Here", Toast.LENGTH_LONG).show();










                }else{
                    Toast.makeText(ImageDisplayActivity.this, "Food Not In List : We will update Soon:", Toast.LENGTH_LONG).show();

                }






        }
        });



    }
}
