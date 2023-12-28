package com.example.checkboxex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox chk_red, chk_blue, chk_green;
    private TextView tv_result;
    private Button btn_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk_red = findViewById(R.id.chk_red);
        chk_blue = findViewById(R.id.chk_blue);
        chk_green = findViewById(R.id.chk_green);
        tv_result = findViewById(R.id.tv_result);
        btn_result = findViewById(R.id.btn_result);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_result = "";
                if (chk_red.isChecked()) {
                    str_result += chk_red.getText().toString() + " ";
                }
                if (chk_blue.isChecked()) {
                    str_result += chk_blue.getText().toString()+ " ";
                }
                if (chk_green.isChecked()) {
                    str_result += chk_green.getText().toString()+ " ";
                }
                if (str_result ==""){
                    tv_result.setText("선택된 내용이 없습니다.");
                } else{
                    tv_result.setText(str_result);
                }

            }
        });
    }
}