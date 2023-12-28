package com.mygorithmtest.myanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
            view.startAnimation(anim);
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(view -> {
            Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale2);
            view.startAnimation(anim2);
        });
    }
}