package com.mygorithm.myOrderDetails;

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
    
    //프레그먼트 교체를 보여주는 처리를 구현한 곳
    //2. FragOrderDetail  실행(FragOrderDetail)
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragOrderDetail.newInstance();
            case 1:
                return FragBlackList.newInstance();
            default:
                return null;

        }
    }

    @Override
    // 총 탭레이아웃의 아이템 수
    public int getCount() {
        return 2;
    }

    //상단의 탭 레이아웃 인디케이터 쪽에 텍스트를 선언해주는 곳
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "주문 내역 리스트";
            case 1:
                return "블랙리스트";
            default:
                return null;

        }
    }
}
