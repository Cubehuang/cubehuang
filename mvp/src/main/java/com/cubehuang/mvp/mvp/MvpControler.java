package com.cubehuang.mvp.mvp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cubehuang.mvp.mvp.presenter.LifeCircleMvpPresenter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MvpControler implements IlifeCircle{
    //存放的是P层的实例
    private Set<IlifeCircle> ilifeCircles = new HashSet<>();

    public static MvpControler newInstance(){
        return new MvpControler();
    }


    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArgument) {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            IlifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArgument == null){
                getArgument = new Bundle();
            }
            next.onCreate(savedInstanceState,intent,getArgument);//调用P层的方法
        }



    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArgument) {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            IlifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArgument == null){
                getArgument = new Bundle();
            }
            next.onActivityCreated(savedInstanceState,intent,getArgument);//调用P层的方法
        }
    }

    @Override
    public void onStart() {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            IlifeCircle next = iterator.next();
            next.onStart();//调用P层的方法
        }

    }

    @Override
    public void onResume() {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            IlifeCircle next = iterator.next();
            next.onResume();//调用P层的方法
        }

    }

    @Override
    public void onPause() {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            IlifeCircle next = iterator.next();
            next.onPause();//调用P层的方法
        }

    }

    @Override
    public void onStop() {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            IlifeCircle next = iterator.next();
            next.onStop();//调用P层的方法
        }

    }

    @Override
    public void onDestropy() {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            IlifeCircle next = iterator.next();
            next.onDestropy();//调用P层的方法
        }

    }

    @Override
    public void destroyView() {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            IlifeCircle next = iterator.next();
            next.destroyView();//调用P层的方法
        }
    }

    @Override
    public void onViewDestroy() {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            IlifeCircle next = iterator.next();
            next.onViewDestroy();//调用P层的方法
        }

    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){
            if (intent == null){
                intent = new Intent();
            }
            IlifeCircle next = iterator.next();
            next.onNewIntent(intent);//调用P层的方法
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){

            IlifeCircle next = iterator.next();
            next.onActivityResult(resultCode,requestCode,data);//调用P层的方法
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Iterator<IlifeCircle> iterator = this.ilifeCircles.iterator();
        while (iterator.hasNext()){

            IlifeCircle next = iterator.next();
            next.onSaveInstanceState(outState);//调用P层的方法
        }
    }

    @Override
    public void attachView(IMVPView imvpView) {

    }

    public  void savePresenter(IlifeCircle ilifeCircle) {
    this.ilifeCircles.add(ilifeCircle);
    }
}
