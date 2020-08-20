package com.cubehuang.todayinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import java.io.File;

public class SplashActivity extends AppCompatActivity {
FullScreenVideoView splashVideo;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashVideo = findViewById(R.id.vv_play);
        splashVideo.setVideoURI(
                Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        splashVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        splashVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }
}
