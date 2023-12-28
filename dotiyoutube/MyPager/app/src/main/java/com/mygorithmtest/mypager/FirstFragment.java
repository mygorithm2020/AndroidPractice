package com.mygorithmtest.mypager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_first, container, false);

        Button button = viewGroup.findViewById(R.id.button);
        TextView tv = viewGroup.findViewById(R.id.text01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "맞는거냐?", Toast.LENGTH_SHORT).show();
                tv.append("\n" + button.getText().toString());
            }
        });

        return viewGroup;
    }
}