package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView text_sub_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        text_sub_01 = findViewById(R.id.text_sub_01);

        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        text_sub_01.setText(str);
    }
}