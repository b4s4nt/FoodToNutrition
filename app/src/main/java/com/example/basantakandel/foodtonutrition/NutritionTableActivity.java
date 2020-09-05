//package com.example.basantakandel.foodtonutrition;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class NutritionTableActivity extends AppCompatActivity {
//
//    Button  SaveNutrient;
//    EditText FoodName;
//    EditText Nutrients;
//    EditText FoodUnit;
//    EditText NutritentsQty;
//    DatabaseHelper myDb;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_nutrition_table);
//
//        FoodName= findViewById(R.id.foodName);
//        Nutrients= findViewById(R.id.nutrients);
//        FoodUnit= findViewById(R.id.foodUnit);
//        NutritentsQty= findViewById(R.id.nutirentsQty);
//        SaveNutrient= findViewById(R.id.saveNutrient);
//        myDb = new DatabaseHelper(this);
//        SaveNutrient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////               String x= FoodName.getText().toString();
////               String y=Nutrients.getText().toString();
////               String z=FoodUnit.getText().toString();
////               String w= NutritentsQty.getText().toString();
//
//                Toast.makeText(NutritionTableActivity.this,FoodName.getText(),Toast.LENGTH_LONG).show();
//                Toast.makeText(NutritionTableActivity.this,Nutrients.getText(),Toast.LENGTH_LONG).show();
//
//
//
//
//                //myDb.saveNutrition(FoodName.getText().toString(),Nutrients.getText().toString(),FoodUnit.getText().toString(),NutritentsQty.getText().toString(),SaveNutrient.getText().toString());
//                  try {
//                     // myDb.saveNutrition(FoodName.getText(),Nutrients.getText(),FoodUnit.getText(),NutritentsQty.getText());
//                      Toast.makeText(NutritionTableActivity.this,"Data Written in Nut",Toast.LENGTH_LONG).show();
//
//                  }catch (Exception e){
//                      Toast.makeText(NutritionTableActivity.this,e.toString(),Toast.LENGTH_LONG).show();
//
//
//                  }
//
//
//
//            }
//        });
//
//
//
//
//
//
//    }
//}
