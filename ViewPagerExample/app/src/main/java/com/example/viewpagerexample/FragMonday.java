package com.example.viewpagerexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragMonday extends Fragment {
    private View view;

    //교체될때 상태 저장용
    public static FragMonday newinstance(){
        FragMonday fragMonday = new FragMonday();
        return fragMonday;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_monday, container, false);

        return view;
    }
}
