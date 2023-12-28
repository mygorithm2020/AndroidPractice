package com.mygorithmtest.mythread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    MainHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroudThread backgroudThread = new BackgroudThread();
//                 실제로는 run이 실해됨
                backgroudThread.start();


            }
        });

        handler = new MainHandler();
    }

    class BackgroudThread extends Thread {
        int value = 0;
        public void run(){
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                }catch (Exception e) {

                }
                value +=1;
                Log.d("MyThread", "value : "+ value );
                // 밑에 실행하면 에러남 메인 스레드가 아닌데 뷰를 건드려서..
                //textView.append("값 : " + value);

                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("value", value);
                message.setData(bundle);

                handler.sendMessage(message);
            }
        }
    }

    class MainHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");

            textView.setText("값 : " +value);
        }
    }
}