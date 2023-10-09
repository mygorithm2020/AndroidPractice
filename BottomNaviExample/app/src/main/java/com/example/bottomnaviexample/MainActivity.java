package com.example.bottomnaviexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frrag1 frrag1;
    private Frrag2 frrag2;
    private Frrag3 frrag3;
    private Frrag4 frrag4;
    private Frrag5 frrag5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_low:
                        setFrag(0);
                        break;
                    case R.id.action_bluetooth:
                        setFrag(1);
                        break;
                    case R.id.action_call:
                        setFrag(2);
                        break;
                    case R.id.action_dash:
                        setFrag(3);
                        break;
                    case R.id.action_miscell:
                        setFrag(4);
                        break;
                }

                return true;
            }
        });
        frrag1 = new Frrag1();
        frrag2 = new Frrag2();
        frrag3 = new Frrag3();
        frrag4 = new Frrag4();
        frrag5 = new Frrag5();
        setFrag(0);

    }

    //프래그먼ㅌ트 교체가 일어나는 실행문
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frrag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frrag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frrag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, frrag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame, frrag5);
                ft.commit();
                break;
        }
    }
}