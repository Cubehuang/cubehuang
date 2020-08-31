package com.cubehuang.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cubehuang.todayinformation.mvp.IMVPView;

public interface IlifeCircle {
    void onCreate(Bundle savedInstanceState, Intent intent,Bundle getArgument);
    
    void onActivityCreated(Bundle savedInstanceState, Intent intent,Bundle getArgument);
    
    void onStart();
    
    void onResume();
    
    void onPause();
    
    void onStop();

    void onDestropy();
    
    void destroyView();
    
    void onViewDestroy();
    
    void onNewIntent();
    
    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    void onSaveInstanceState(@NonNull Bundle outState);
    
    void attachView(IMVPView imvpView);
}
