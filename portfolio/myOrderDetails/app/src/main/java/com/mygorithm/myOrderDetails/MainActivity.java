package com.mygorithm.myOrderDetails;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;

    private long backBtnTime = 0;

    public OrderDetailDao orderDetailDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Hello Toolbar");
        toolbar.inflateMenu(R.menu.menu_main);

        toolbar.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.search){
                Toast.makeText(this,"selected search!", Toast.LENGTH_LONG).show();
                return true;
            }else if (item.getItemId()==R.id.setting){
                Toast.makeText(this,"selected setting", Toast.LENGTH_LONG).show();
                return true;
            }
            return false;
        });

        // 뷰페이저 세팅
        ViewPager viewPager = findViewById(R.id.viewPager);
        fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //1. 뷰페이저  실행(ViewPagerAdapter)
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

//        OrderDetailDatabase database = Room.databaseBuilder(getApplicationContext(), OrderDetailDatabase.class, "my_db")
//                .fallbackToDestructiveMigration()   //스키마 버전 변경 가능
//                .allowMainThreadQueries()       //  Main Thread에서 DB에 IO 가능하게함
//                .build();
//
//        orderDetailDao = database.orderDetailDao();





    }



    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;

        if(0 <=gapTime && 2000>=gapTime) {
            super.onBackPressed();
        }
        else{
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }
}