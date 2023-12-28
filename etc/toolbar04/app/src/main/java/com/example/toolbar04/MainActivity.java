package com.example.toolbar04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("IO16");


        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("Hello Toolbar");
        toolbar.inflateMenu(R.menu.menu_main);

        toolbar.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.android){
                Toast.makeText(this,"Hello Android!", Toast.LENGTH_LONG).show();
                return true;
            }
            return false;
        });




    }
}