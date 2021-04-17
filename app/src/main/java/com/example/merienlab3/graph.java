package com.example.merienlab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static java.lang.Math.abs;
import static java.lang.Math.atan;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class graph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScalable(true);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        double x = Transit.x;
        int count = Transit.count;
        double Step = Transit.Step;

        double Res = 0.0;
        int y = 0;

        int e = 5;
        int a = 4;
        int c = 8;

        do {

            Res = (Math.sqrt((pow(5, x)) - pow(Math.cos(pow(x, 2) * pow(4, 5)), 4)) + pow(atan(4 - pow(x, 5)), 4)) / pow(abs(4 + (x * pow(8, 4))), -5);

            y = (int)Math.round(Res);
            series.appendData(new DataPoint(x, y), true, 50);

            x = x + Step;
        } while (x<=count);

        graph.addSeries(series);
    }
    public void TextonClick(View v) {
        Intent textgo = new Intent(".Text");
        startActivity(textgo);
    }
}