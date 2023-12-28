package com.mygorithmtest.myfragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ImageSelectionCallback {
    ListFragment listFragment;
    ViewerFragment viewerFragment;

    int[] imagesid = {R.drawable.image01, R.drawable.image02, R.drawable.image03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);
    }


    @Override
    public void onImageSelected(int position) {
        viewerFragment.setImage(imagesid[position]);

    }
}