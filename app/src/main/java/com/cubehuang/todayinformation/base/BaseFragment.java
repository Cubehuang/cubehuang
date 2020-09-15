package com.cubehuang.todayinformation.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cubehuang.todayinformation.mvp.presenter.LifeCircleMvpActivity;
import com.cubehuang.todayinformation.mvp.presenter.LifeCircleMvpFragment;
import com.cubehuang.todayinformation.mvp.presenter.LifeCircleMvpPresenter;

import java.util.zip.Inflater;

import butterknife.ButterKnife;

public abstract class BaseFragment extends LifeCircleMvpFragment {

    protected Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Viewinject annotation = this.getClass().getAnnotation(Viewinject.class);
        View mView;
        if (annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if (mainlayoutid > 0){
                Log.e("hsy","打印一下mainlayoutID= "+mainlayoutid);
                Log.e("hsy","打印一下context = "+mContext);
                mView = initFragmentView(inflater,mainlayoutid);
                Log.e("hsy","打印一下View= "+mView);
                bindeView(mView);
                afterBindView();

            }else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater,int mainlayoutid) {
        return LayoutInflater.from(mContext).inflate(mainlayoutid,null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }
    //当fragment加载到Activity中时获得该context
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    //模板方法 设计模式
    public abstract void afterBindView();
//View的依赖注入绑定
    private void bindeView(View mView) {
        ButterKnife.setDebug(true);
        ButterKnife.bind(this,mView);
    }
}
