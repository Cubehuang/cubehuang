package com.cubehuang.todayinformation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Viewinject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity {


    @BindView(R.id.vv_play)
    FullScreenVideoView vvPlay;
    @BindView(R.id.tv_timer)
    TextView tvTimer;
    TimePresenter timePresenter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initListener();
        initVideo();
        initTimerPresenter();
        //把初始化Timer即相关内容抽出到presenter中
    }

    private void initTimerPresenter() {
        timePresenter = new TimePresenter(this);
        timePresenter.startTime();
    }


    private void initVideo() {
        vvPlay.setVideoURI(
                Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));

    }

    private void initListener() {
        tvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        vvPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        vvPlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timePresenter.onDestropy();
    }

    public void setTvtext(String s) {
        tvTimer.setText(s);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
