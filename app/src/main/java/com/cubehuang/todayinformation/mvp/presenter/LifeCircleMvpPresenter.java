package com.cubehuang.todayinformation.mvp.presenter;

import com.cubehuang.todayinformation.mvp.IMVPView;
import com.cubehuang.todayinformation.mvp.IlifeCircle;

import java.lang.ref.WeakReference;

public abstract class LifeCircleMvpPresenter<T extends IMVPView> implements IlifeCircle {

    protected WeakReference<T> weakReference;

    protected LifeCircleMvpPresenter(){
        super();
    }
    protected LifeCircleMvpPresenter(IMVPView imvpView){
        super();
        attachView(imvpView);
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
