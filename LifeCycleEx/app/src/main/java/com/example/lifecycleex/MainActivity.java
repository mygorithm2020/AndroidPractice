package com.example.lifecycleex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    // 액티비티 또는 프래그먼트가 생성 되었을 때
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("onCreate", "Enter");

        findViewById(R.id.btn_move).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SubActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "Enter");
    }



    @Override
    // 중지되어있던 액티비가 다시 재개(재 실행_ 되는 시점에서 이곳 내부 구문을 실행
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "Enter");
    }

    @Override
    // 중지 상태(= 홈버튼을 눌러서 바깥으로 잠깐 빠져나갔을 때, 다른 엑티비티가 활성화 되어 있을 때)일 때 이곳 실행
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "Enter");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "Enter");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "Enter");
    }

    @Override
    // 화면이 파괴되어서 소멸했을 때의 시점 일 때 이곳 내부구문들을 실행
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "Enter");
    }
}