package com.example.merienlab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        TextView res = (TextView) findViewById(R.id.ResultText);
        res.setMovementMethod(new ScrollingMovementMethod());

        try {
            FileInputStream fileInput = openFileInput("Lab3.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder strBuffer =  new StringBuilder();
            String ResLines;
            while ((ResLines = buffer.readLine()) != null) {
                strBuffer.append(ResLines).append("\n");
            }
            res.setText(strBuffer.toString());
            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GraphonClick(View v) {
        Intent graphgo = new Intent(".graph");
        startActivity(graphgo);
    }
}