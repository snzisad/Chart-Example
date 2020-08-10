package com.mrzisad.chartexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;

import com.mrzisad.chartexample.adapter.PieChartAdapter;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {
    PieChart pieChart;
    ArrayList data;
    PieChartAdapter adapter;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        initComponents();

        setDatainPieChart();
    }


    private void initComponents(){
        pieChart = findViewById(R.id.piechart);
        recyclerview = findViewById(R.id.recyclerview);

        data = new ArrayList();
        adapter = new PieChartAdapter(this, data);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setDatainPieChart(){
        int[] count = new int[]{4, 1, 2, 2};

        PieModel pieModel = new PieModel(
                "R",
                count[0], getResources().getColor(R.color.colorPrimary));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(pieModel);
        data.add(pieModel);

        pieModel =  new PieModel(
                "Python",
                count[1],
                ContextCompat.getColor(this, R.color.colorAccent));

        pieChart.addPieSlice(pieModel);
        data.add(pieModel);


        pieModel = new PieModel(
                "C++",
                count[2],
                Color.parseColor("#EF5350"));

        pieChart.addPieSlice(pieModel);
        data.add(pieModel);

        pieModel = new PieModel(
                "Java",
                count[3],
                Color.parseColor("#29B6F6"));


        pieChart.addPieSlice(pieModel);
        data.add(pieModel);

        adapter.notifyDataSetChanged();
        // To animate the pie chart
        pieChart.startAnimation();
    }

}