package com.mygorithmtest.mymultitouch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.LinearLayout;

// part02 chapter 12 08
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.container);

        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.beach);

        ImageDisplayView view = new ImageDisplayView(this);

    }
}