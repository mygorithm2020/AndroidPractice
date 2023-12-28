package com.example.googleloginex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ResultActivity extends AppCompatActivity {

    private TextView tv_result;
    private ImageView iv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String nickName = intent.getStringExtra("nickName");
        String phothUrl = intent.getStringExtra("phothUrl");
        String email = intent.getStringExtra("email");

        tv_result = findViewById(R.id.tv_result);
        tv_result.setText(nickName + email); //닉네임 text를

        iv_profile = findViewById(R.id.iv_profile);
        Glide.with(this).load(phothUrl).into(iv_profile);  //프로필 URL을 이미지 뷰에 세팅
    }
}