package com.cubehuang.todayinformation.mvp.presenter;

import com.cubehuang.todayinformation.mvp.IMVPView;
import com.cubehuang.todayinformation.mvp.IlifeCircle;
import com.cubehuang.todayinformation.mvp.MvpControler;

import java.lang.ref.WeakReference;

public abstract class LifeCircleMvpPresenter<T extends IMVPView> implements IlifeCircle {

    protected WeakReference<T> weakReference;

    protected LifeCircleMvpPresenter(){
        super();
    }
    protected LifeCircleMvpPresenter(IMVPView imvpView){
        super();
        attachView(imvpView);
        //通过这个IMVPView接口的方法获得IMVPView中的controler的实例
        MvpControler mvpControler = imvpView.getMvpControler();
        //controler获得p层的实例，之后control而通过这个p层的实例调用p层各个生命周期的方法
        mvpControler.savePresenter(this);
    }

    @Override
    public void attachView(IMVPView imvpView) {
        //做弱引用
        if (weakReference == null){
            weakReference = new WeakReference(imvpView);
        }else {
            T view = (T) weakReference.get();
            if (view != imvpView){
                weakReference = new WeakReference(imvpView);
            }
        }
    }

    @Override
    public void onDestropy() {
        weakReference = null;
    }

    protected T getView(){
        T view = weakReference != null ?  weakReference.get():null;
        if (view == null){
            return getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();
}
