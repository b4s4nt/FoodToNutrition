package com.example.basantakandel.foodtonutrition;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CalorieDisplayActivity extends AppCompatActivity {






    Session session;
    TextView Protein;
    TextView Carbohydrate;
    TextView Fat;
    TextView Calorie ;
    TextView FoodName;
    Button Save;
    TextView back;
    ArrayList<String> listOfCalcNutritionValue;
    ImageView NewDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

         session = new Session(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_display);
         ArrayList<String> list = ( ArrayList<String>) getIntent().getSerializableExtra("N1");
        List<Double> vn=  new ArrayList<>();// save the total nutrient value

        String nam= getIntent().getStringExtra("NAM");
        String multiplier=getIntent().getStringExtra("MUL");
        


        double x= Double.parseDouble(multiplier) * Double.parseDouble(list.get(0).toString());//calorie
        double y= Double.parseDouble(multiplier) * Double.parseDouble(list.get(1).toString());//protein
        double z= Double.parseDouble(multiplier) * Double.parseDouble(list.get(2).toString());//carbohydrat
        double w= Double.parseDouble(multiplier) * Double.parseDouble(list.get(3).toString());//fat


          viewByIDField();





        Calorie.setText(Double.toString(x));
        Protein.setText(Double.toString(y));
        Carbohydrate.setText(Double.toString(z));
        Fat.setText(Double.toString(w));
        FoodName.setText(nam);
        final DatabaseHelper db = new DatabaseHelper(this);




        back.setOnClickListener(new View.OnClickListener() {
            
            
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CalorieDisplayActivity.this,MenuActivity.class);
                startActivity(intent);

            }
        });



        NewDay.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                db.dropTable(DatabaseHelper.trackTable);

                Toast.makeText(CalorieDisplayActivity.this, " Old Record Deleted", Toast.LENGTH_LONG).show();
                Toast.makeText(CalorieDisplayActivity.this, " Save Result for Tracking new Day", Toast.LENGTH_LONG).show();



//                Intent intent= new Intent(CalorieDisplayActivity.this,MenuActivity.class);
//                startActivity(intent);

            }
        });



        Save.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {


                  final String name= session.getusename().toString();
                  listOfCalcNutritionValue= new ArrayList<>();
                  listOfCalcNutritionValue.add(name);
                  listOfCalcNutritionValue.add(FoodName.getText().toString());
                  listOfCalcNutritionValue.add(Calorie.getText().toString());
                  listOfCalcNutritionValue.add(Protein.getText().toString());
                  listOfCalcNutritionValue.add(Carbohydrate.getText().toString());
                  listOfCalcNutritionValue.add(Fat.getText().toString());




                  try{
                      if (db.insertIntoTrackTable(listOfCalcNutritionValue)){
                          Toast.makeText(CalorieDisplayActivity.this," Calculated Data Saved",Toast.LENGTH_LONG).show();

                      }else{
                          Toast.makeText(CalorieDisplayActivity.this,"  We Could Not Insert Data",Toast.LENGTH_LONG).show();

                      }

                  }catch (Exception e){

                      Toast.makeText(CalorieDisplayActivity.this,e.toString(),Toast.LENGTH_LONG).show();


                  }




//

                  
                  
                  
                  
                  






              }
          });









    }

    private void viewByIDField() {

         Protein=  (TextView)findViewById(R.id.proteinId);
         Carbohydrate=  (TextView)findViewById(R.id.carbohydrateID);
         Fat=  (TextView)findViewById(R.id.fatId);
         Calorie=  (TextView)findViewById(R.id.calorieId);
         FoodName=(TextView)findViewById(R.id.foodId);
         Save= (Button)findViewById(R.id.GraphID);
         back= (TextView) findViewById(R.id.backFromCalcResult);
         NewDay=(ImageView)findViewById(R.id.newDay);




    }
}
