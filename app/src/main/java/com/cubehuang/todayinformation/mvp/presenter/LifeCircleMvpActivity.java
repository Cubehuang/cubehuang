package com.cubehuang.todayinformation.mvp.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cubehuang.todayinformation.mvp.IMVPView;
import com.cubehuang.todayinformation.mvp.MvpControler;

public class LifeCircleMvpActivity extends AppCompatActivity implements IMVPView {
    private MvpControler Mvpcontroler;//静态代理与动态代理的区别？ 主要的区别是代理类是否提前创建存在的

    @Override
    public MvpControler getMvpControler() {
        if (this.Mvpcontroler == null){
            this.Mvpcontroler = new MvpControler();
        }
        return this.Mvpcontroler;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if (intent == null){
            intent = new Intent();
        }
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onCreate(savedInstanceState,intent,null);
            mvpControler.onActivityCreated(savedInstanceState,intent,null);

        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onNewIntent(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onDestropy();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onSaveInstanceState(outState);
        }
    }
}
