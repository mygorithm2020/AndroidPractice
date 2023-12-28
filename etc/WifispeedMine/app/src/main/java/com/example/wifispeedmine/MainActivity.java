package com.example.wifispeedmine;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wifispeedmine.databinding.ActivityMainBinding;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding vBinding;
    Timer timer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        vBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = vBinding.getRoot();
        setContentView(view);

        vBinding.btnNetwork.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                    Toast.makeText(MainActivity.this, "상태 확인 종료", Toast.LENGTH_SHORT).show();
                    vBinding.tvNetworkState.setText("마지막 상태 확인 시간");
                }else{
                    timer = new Timer();
                    //Toast.makeText(MainActivity.this, String.valueOf(timer), Toast.LENGTH_SHORT).show();
                    TimerTask timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            LocalTime now = LocalTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
                            String formatedNow = now.format(formatter);

                            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                            WifiInfo wifiInfo = wifiManager.getConnectionInfo();

                            if(wifiInfo.getSupplicantState() == SupplicantState.COMPLETED){
                                vBinding.tvNetworkState.setText("네트워크가 연결 되었습니다.");

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        vBinding.tvNetworkTest.setText(formatedNow);

                                        int ip_add = wifiInfo.getIpAddress();
                                        final String formattedIpAddress = String.format("%d.%d.%d.%d",
                                                (ip_add & 0xff),
                                                (ip_add >> 8 & 0xff),
                                                (ip_add >> 16 & 0xff),
                                                (ip_add >> 24 & 0xff));

                                        vBinding.tvNetworkIp.setText(formattedIpAddress);



                                        int level = wifiManager.calculateSignalLevel(wifiInfo.getRssi(), 5);
                                        String level_str = "신호";
                                        switch (level){
                                            case 0:
                                                level_str = "신호 매우 나쁨";
                                                break;
                                            case 1:
                                                level_str = "신호 나쁨";
                                                vBinding.ivWifiStr.setImageResource(R.drawable.wifi1);
                                                break;
                                            case 2:
                                                level_str = "신호 중간";
                                                vBinding.ivWifiStr.setImageResource(R.drawable.wifi2);
                                                break;
                                            case 3:
                                                level_str = "신호 좋음";
                                                vBinding.ivWifiStr.setImageResource(R.drawable.wifi3);
                                                break;
                                            case 4:
                                                level_str = "신호 매우 좋음";
                                                vBinding.ivWifiStr.setImageResource(R.drawable.wifi4);
                                                break;
                                        }

                                        vBinding.tvNetworkStrength.setText(level_str);

                                        //테스트용
                                        vBinding.tvNetworkTest2.setText(String.valueOf(wifiInfo.getNetworkId()));

                                        //테스트용
                                        vBinding.tvNetworkTest3.setText(String.valueOf(wifiInfo.getNetworkId()));

                                    }
                                });

                                //테스트용


                            }else{
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        vBinding.tvNetworkState.setText("네트워크 확인 불가");
                                        Toast.makeText(MainActivity.this, "와이파이 연결을 확인해주세요", Toast.LENGTH_SHORT).show();

                                    }
                                });

                            }

                        }
                    };
                    timer.schedule(timerTask, 0, 3000);





                    //vBinding.tvNetworkState.setText(String.valueOf(wifiInfo.getDetailedStateOf()));

                }




            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();




    }
}