package com.cubehuang.todayinformation.mvp.BaseMvpPreseter;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cubehuang.todayinformation.mvp.IMVPView;
import com.cubehuang.todayinformation.mvp.presenter.LifeCircleMvpPresenter;
/*
* 抽象重介质
* */

public abstract class BaseMvpPresenter <T extends IMVPView>extends LifeCircleMvpPresenter<T> {


    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArgument) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onNewIntent() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }
}
