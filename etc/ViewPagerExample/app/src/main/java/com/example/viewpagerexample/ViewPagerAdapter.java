package com.example.viewpagerexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull  FragmentManager fm) {
        super(fm);
    }

    @NonNull

    @Override
    // 프래그먼트 교체를 보여주는 처리를 구현한 곳
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FragMonday.newinstance();
            case 1:
                return FragTuesday.newinstance();
            case 2:
                return FragWednesday.newinstance();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    // 상단의 탭 레이아웃 인디케이터 쪽에 텍스트를 선언해주는 곳
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            default:
                return null;
        }
    }
}
