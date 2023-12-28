package com.example.bindindadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bindindadapter.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }

    public class TextViewBindingAdapters{
        @BindingAdapter("reverseText")
        public static void setReverseText(TextView view, String toReverse){
            String reversed = new StringBuilder(toReverse).reverse().toString();
            view.setText(reversed);
        }
    }
}