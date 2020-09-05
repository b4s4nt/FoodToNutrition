package com.example.basantakandel.foodtonutrition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);


       // String nam= getIntent().getStringExtra("Track");
        ArrayList<Double> list = ( ArrayList<Double>) getIntent().getSerializableExtra("T");


         Double sum = 0.0;


        for(Double x:list){

            sum = sum+ x;

        }


        float x= (float) ((list.get(0)/sum)*100);
        float y= (float) ((list.get(1)/sum)*100);
        float z= (float) ((list.get(2)/sum)*100);
        float w= (float) ((list.get(3)/sum)*100);






        ArrayList<BarEntry> bargroup1 = new ArrayList<>();
        bargroup1.add(new BarEntry(y, 0));
        bargroup1.add(new BarEntry(z, 1));
        bargroup1.add(new BarEntry(w, 2));
        bargroup1.add(new BarEntry(x, 3));

// entries.add(3);
        HorizontalBarChart barChart = (HorizontalBarChart) findViewById(R.id.barchart);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Protein");
        labels.add("Carbohydrate");
        labels.add("Fat");
        labels.add("Calories");

        BarDataSet bardataset = new BarDataSet(bargroup1, "This is Vertical Chart: Look Vertically:");
//        BarDataSet bardataset = new BarDataSet(bargroup, "here");
//        BarDataSet bardataset = new BarDataSet(bargroup1, "here");
//        BarDataSet bardataset = new BarDataSet(bargroup1, "here");




        //BarDataSet bardataset = new BarDataSet(labels, "Cells");
        BarData data = new BarData(labels, bardataset);
        barChart.setData(data);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setDescription("Percentage Of Nutrition Consumptions");


    }
}
