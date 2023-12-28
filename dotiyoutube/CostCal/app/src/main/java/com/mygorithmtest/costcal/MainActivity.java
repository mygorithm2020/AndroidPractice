package com.mygorithmtest.costcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int month = 0;
    int result = 60;
    int add;
    double relate = 0.026;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = this.findViewById(R.id.spinner);
        EditText editText = findViewById(R.id.editTextNumber2);
        TextView tv = findViewById(R.id.textView2);
        Button button = findViewById(R.id.button);
        tv.setText(Integer.toString(result));
        ArrayList<String> deposits = new ArrayList<>();
        //List<int> deposits = new List<int>(){};
        for (int j= 1000; j <=6000; j+=500){
            deposits.add(Integer.toString(j));
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, deposits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int depo = Integer.parseInt(deposits.get(i));
                add = (int) Math.ceil(depo * 0.9 * relate /12);
                month = result - add;
                editText.setText(Integer.toString(month));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                month = Integer.parseInt(editText.getText().toString());
                result = month + add;
                if (result>60){
                    result = 60;
                    month = result - add;
                    editText.setText(String.valueOf(month));
                }
                tv.setText(String.valueOf(result));
            }
        });
    }

    public void numberOne(){

    }

    public void numberTwo(){

    }
}