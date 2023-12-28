package com.mygorithmtest.mypager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager pager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        pager2 = findViewById(R.id.pager);
//        3개의 페이지를 만들거라
        pager2.setOffscreenPageLimit(3);

        MypagerAdapter adapter = new MypagerAdapter(getSupportFragmentManager());
        FirstFragment fragment1 = new FirstFragment();
        adapter.addItem(fragment1);

        SecFragment fragment2 = new SecFragment();
        adapter.addItem(fragment2);

        ThridFragment fragment3 = new ThridFragment();
        adapter.addItem(fragment3);

        pager2.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager2.setCurrentItem(1);
            }
        });
    }

    class MypagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<>();

        public MypagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item) {
            items.add(item);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
}