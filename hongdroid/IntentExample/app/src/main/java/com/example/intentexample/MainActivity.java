package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_move_j;
    private EditText editT_main_j;
    private String str;
    ImageView test_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editT_main_j = findViewById(R.id.editT_main);


        btn_move_j = findViewById(R.id.btn_move);
        btn_move_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = editT_main_j.getText().toString();

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str", str);
                startActivity(intent); //실제로 액티비티 이동해주는 구문
            }
        });

        test_image = (ImageView)findViewById(R.id.test_image);
        test_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "홍드로이드 잘생김", Toast.LENGTH_LONG).show();
            }
        });
    }
}