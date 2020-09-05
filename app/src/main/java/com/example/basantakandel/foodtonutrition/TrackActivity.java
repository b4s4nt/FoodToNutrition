package com.example.basantakandel.foodtonutrition;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class TrackActivity extends AppCompatActivity {

    TextView Protein;
    TextView Carbohydrate;
    TextView Calorie;
    TextView Back;
    TextView Fat;
    Button Graph;

    DatabaseHelper db;
    ArrayList<String> listCarb;
    Session session;

    String name1;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {








        ArrayList<String> list1= new ArrayList<>();
        ArrayList<String> list2= new ArrayList<>();
        ArrayList<String> list3= new ArrayList<>();
        ArrayList<String> list4= new ArrayList<>();




        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_track);

     




        Graph= (Button)findViewById(R.id.GraphID);
        Back= (TextView) findViewById(R.id.back);

        Protein=  (TextView)findViewById(R.id.proteinTrack);
        Carbohydrate=  (TextView)findViewById(R.id.carbohydrateTrack);
        Fat=  (TextView)findViewById(R.id.fatTrack);
        Calorie=  (TextView)findViewById(R.id.calorieTrack);

        final ArrayList<Double> sumValue= new ArrayList<>();//calorie,protein,carbohydrate,fat





        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrackActivity.this,MenuActivity.class);
                startActivity(intent);

            }
        });



        Graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TrackActivity.this,GraphActivity.class);

                intent.putExtra("T", (Serializable) sumValue);

               // intent.putExtra("T",sumValue);
                startActivity(intent);

            }
        });
        session = new Session(this);

        name1 = session.getusename().toString();




        list1= getValuesFromTrackTable(4);//DatabaseHelper.Carbohydrate
       // Toast.makeText(TrackActivity.this,list1.get(1).toString(),Toast.LENGTH_LONG).show();

        list2=getValuesFromTrackTable(5);//DatabaseHelper.Fat
        list3=getValuesFromTrackTable(3);//DatabaseHelper.Protein
        list4= getValuesFromTrackTable(2);//DatabaseHelper.Calorie






        String c ="Normal" ;
        String p = "Normal";
        String e  ="Normal";
        String f ="Normal";





            double carbValue= calculateValue(list1);
            double fatValue=calculateValue(list2);
            double  proteinValue=calculateValue(list3);
            double calorieValue=calculateValue(list4);

           sumValue.add(calorieValue);
           sumValue.add(proteinValue);
           sumValue.add(carbValue);
           sumValue.add(fatValue);







        if(carbValue>220 && carbValue<325){
            c="Normal";


        }else if (carbValue<220)


        {
            c="Low";


        }else if(carbValue>325){
            c="High";





        }else{

            System.out.println("Error Here");

        }



        if(proteinValue>=46&& fatValue<=56){
            p="Normal";


        }else if (proteinValue<46)


        {
            p="Low";


        }else if(proteinValue>56){
            p="High";





        }else{
            System.out.println("Error Here");

        }

        if(fatValue>=60&& fatValue<=80){
            f="Normal";


        }else if (fatValue<60)


        {
            f="Low";


        }else if(fatValue>80){
            f="High";





        }else{
            System.out.println("Error Here");

        }



        if(calorieValue>=1800&& calorieValue<=3200){
            e="Normal";


        }else if (calorieValue<1800)


        {
            e="Low";


        }else if(calorieValue>3200){
            e="High";





        }else{
            System.out.println("Error Here");

        }

//






        Protein.setText(p);
        Carbohydrate.setText(c);
        Calorie.setText(e);
        Fat.setText(f);



















    }



    private double calculateValue(ArrayList<String> lst) {



        double sum=0.0;
        for(String x: lst){


            sum= sum=sum + Double.parseDouble(x);
        }

        System.out.println("HEre is sum"+sum);

        return sum;
    }

    private ArrayList<String> getValuesFromTrackTable(int column) {
        db=new DatabaseHelper(TrackActivity.this);


        ArrayList list= new ArrayList();

  try{


      list= db.getSpecificColOnMatching(DatabaseHelper.trackTable,DatabaseHelper.username,name1,column);
  }catch (Exception e){

      Toast.makeText(TrackActivity.this,"No value inserted in table",Toast.LENGTH_LONG).show();

  }




        // System.out.println("HEre HEY DUDE"+list.get(4));
        // System.out.println("HEre HEY DUDE"+list.get(5));





        return  list;




    }
}
