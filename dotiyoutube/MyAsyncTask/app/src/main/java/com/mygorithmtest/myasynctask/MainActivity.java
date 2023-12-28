package com.mygorithmtest.myasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    ProgressBar progressBar2;

    TextView textView;

    int value;
    int value2;
    int value3 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar3);
        Button button_ex = findViewById(R.id.button3);
        BackgroundTask task = new BackgroundTask();
        button_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (task.isCancelled() == true) {
                    Toast.makeText(getApplicationContext(), "멈춘 상태는 맞나?", Toast.LENGTH_SHORT).show();

                }else {
                    task.execute();
                }



            }
        });
        Button button_can = findViewById(R.id.button4);
        button_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.cancel(true);


                button_ex.setText("재실행");
            }
        });

        progressBar2 = findViewById(R.id.progressBar4);

        value2 = 0;

        Timer timer2 = new Timer();
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                if (value2<100) {
                    value2++;
                    progressBar2.setProgress(value2);
                }

            }
        };

        Button button_sync_ex = findViewById(R.id.button5);
        Button button_sync_down = findViewById(R.id.button6);
        button_sync_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer2.schedule(timerTask2, 100, 200);

            }
        });
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (value3<100) {
                    value3++;
                    textView.setText(Integer.toString(value3));
                }

            }
        };


        textView = findViewById(R.id.textView2);
        button_sync_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.schedule(timerTask, 100, 100);

                value3 = 0;

            }
        });
    }
    
    class BackgroundTask extends AsyncTask<Integer, Integer, Integer> {
        
//        t스레드 실행 전
        @Override
        protected void onPreExecute() {
            value = 0;
            progressBar.setProgress(0);
        }

//        스레드 실행 후
        @Override
        protected void onPostExecute(Integer integer) {
            progressBar.setProgress(0);
        }
// 스레드를 실행하며 중간중간 업데이트 원할 떄
        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0].intValue());
        }

//        스레드 실행상태
        @Override
        protected Integer doInBackground(Integer... integers) {
            while (isCancelled() == false) {
                value++;
                if (value>=100) {
                    break;
                }
                publishProgress(value);
                try {
                    Thread.sleep(300);
                } catch (Exception e) {

                }
            }
            return value;
        }
    }
}