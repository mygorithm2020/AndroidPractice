package com.mygorithmtest.mysliding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    Animation translateLeftAnim, translateRightAnim;

    LinearLayout page;
    Button button;

    boolean isPageOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = findViewById(R.id.page);

        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        SlidingAnimationListener animationListener = new SlidingAnimationListener();
        translateLeftAnim.setAnimationListener(animationListener);
        translateRightAnim.setAnimationListener(animationListener);

        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            if (isPageOpen) {
                page.startAnimation(translateRightAnim);
            }else {
                page.setVisibility(View.VISIBLE);
                page.startAnimation(translateLeftAnim);
            }

        });
    }

    class SlidingAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (isPageOpen) {
                page.setVisibility(View.INVISIBLE);
                button.setText("열기");
                isPageOpen = false;
            }else{
                isPageOpen = true;
                button.setText("닫기");
            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}