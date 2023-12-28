package com.mygorithm.myOrderDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragBlackList extends Fragment {
    private View view;

    //프레그먼트가 교체가 되는거에 있어서 상태 저장
    public static FragBlackList newInstance(){
        FragBlackList FragBlackList = new FragBlackList();
        return FragBlackList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_blacklist, container, false);

        return view;
    }
}
