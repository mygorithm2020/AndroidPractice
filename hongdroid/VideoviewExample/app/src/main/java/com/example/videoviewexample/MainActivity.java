package com.example.videoviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;  //재생이나 정지와 같은 미디어 제어버튼
    private String videoURL = "https://www.radiantmediaplayer.com/media/bbb-360p.mp4"; // 현재 보안떄문에막혀있어서 재생이 안댐;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // 앱이 첫 실행할때
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse(videoURL);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);  // 비디오 뷰의 주소를 설정
        videoView.start();
    }
}