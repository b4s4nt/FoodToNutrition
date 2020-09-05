package com.example.basantakandel.foodtonutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button nutrBtn;
    Button trackBtn;
    Button carbohydrateBtn;
    Button proteinBtn;
    Button fatBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //MainActivity main= new MainActivity();
        Session session = new Session(this);
        // session.setusename("Basanta");

          final String name1= session.getusename().toString();
            System.out.println(name1);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Login= (Button)findViewById(R.id.login);

        Toast.makeText(MenuActivity.this,
                "Welcome!  "+name1 +" To FoodToNutrition App", Toast.LENGTH_LONG).show();




        nutrBtn= (Button) findViewById(R.id.nutrition);
        trackBtn = (Button) findViewById(R.id.track);
        carbohydrateBtn= (Button) findViewById(R.id.carbohydrate);
       // proteinBtn = (Button) findViewById(R.id.carbohydrate);
        proteinBtn=(Button) findViewById(R.id.protein);
        fatBtn=(Button)findViewById(R.id.fat);

        nutrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MenuActivity.this,name1+"Now Calculate Nutrition:",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(MenuActivity.this,CalculationActivity.class);
                startActivity(intent);
            }
        });
        trackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MenuActivity.this,TrackActivity.class);
                startActivity(intent);
            }
        });
        carbohydrateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MenuActivity.this,CarbohydrateActivity.class);
                startActivity(intent);
            }
        });
        proteinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MenuActivity.this,ProteinActivity.class);
                startActivity(intent);
            }
        });
        fatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MenuActivity.this,FatActivity.class);
                startActivity(intent);
            }
        });


    }
}
