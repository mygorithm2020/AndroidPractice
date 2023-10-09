package com.example.study_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_id01_j;
    TextView textv01_j;
    Button btn_test01_j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_id01_j = findViewById(R.id.et_id01);
        btn_test01_j = findViewById(R.id.btn_test01);
        textv01_j = findViewById(R.id.textv01);

        btn_test01_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textv01_j.setText(et_id01_j.getText());

            }
        });
    }
}