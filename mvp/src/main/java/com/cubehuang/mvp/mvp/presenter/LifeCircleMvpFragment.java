package com.cubehuang.mvp.mvp.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cubehuang.mvp.mvp.IMVPView;
import com.cubehuang.mvp.mvp.MvpControler;

public class LifeCircleMvpFragment extends Fragment implements IMVPView {
    private MvpControler Mvpcontroler;//静态代理与动态代理的区别？ 主要的区别是代理类是否提前创建存在的

    @Override
    public MvpControler getMvpControler() {
        if (this.Mvpcontroler == null){
            this.Mvpcontroler = new MvpControler();
        }
        return this.Mvpcontroler;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle == null){
            bundle = new Bundle();
        }
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onCreate(savedInstanceState,null,bundle);
            mvpControler.onActivityCreated(savedInstanceState,null,bundle);

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle == null){
            bundle = new Bundle();
        }
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onActivityCreated(savedInstanceState,null, bundle);

        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onViewDestroy();

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpControler mvpControler= this.getMvpControler();
        if (mvpControler != null){
            mvpControler.onDestropy();
        }
    }


}
