package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databinding.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    public class TextViewBindingAdapters{
        @BindingAdapter("reverseText")
        public void setReverseText(TextView view, String toReverse){
            String reversed = new StringBuilder(toReverse).reverse().toString();
            view.setText(reversed);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewModel viewModel = new ViewModel();
        binding.setViewModel(viewModel);
        viewModel.title.set("Reverse String");

    }
    public static class ViewModel {
        public ObservableField<String> title = new ObservableField<>();
    }



}