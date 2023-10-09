package com.example.fragmentbundleex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment01 extends Fragment {

    private View view;
    private TextView tv_frag1;
    private Button btn_move;
    private String result;

    @Nullable
    
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);

        tv_frag1 = view.findViewById(R.id.tv_frag1);
        btn_move = view.findViewById(R.id.btn_move);

        if (getArguments() != null) {
            result = getArguments().getString("fromFrag2");
            tv_frag1.setText(result);
        }

        btn_move.setOnClickListener(new View.OnClickListener() { // 프래그먼트 2로 이동
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); // 보따리 혹은 꾸러미
                bundle.putString("fromFrag1", "홍드로이드 프래그먼트 1");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment02 fragment02 = new Fragment02();
                fragment02.setArguments(bundle);
                transaction.replace(R.id.frame_layout, fragment02);
                transaction.commit(); //저장
                
            }
        });

        return view;
    }
}
