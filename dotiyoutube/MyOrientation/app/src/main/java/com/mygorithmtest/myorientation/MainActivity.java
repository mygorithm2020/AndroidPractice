package com.mygorithmtest.myorientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast("onCreate 호출됨");
        textView2 = findViewById(R.id.textView2);

        editText = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button);
        if (button != null){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (editText != null) {
                        name = editText.getText().toString();
                        showToast("사용자 입력값을 name 변수에 할당함");
                    }
                }
            });
        }

        if (savedInstanceState !=null) {
            if(textView2 !=null) {
                name = savedInstanceState.getString("name");
                textView2.setText(name);

                showToast("값을 복원했습니다." + name);
            }
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull  Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name);
    }

    @Override
    protected void onDestroy() {
        showToast("onDestroy 호출됨");
        super.onDestroy();
    }

    private void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}