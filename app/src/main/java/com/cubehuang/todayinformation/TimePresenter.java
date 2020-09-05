package com.cubehuang.todayinformation;

import android.util.Log;

import com.cubehuang.todayinformation.mvp.BaseMvpPreseter.BaseMvpPresenter;
import com.cubehuang.todayinformation.mvp.ISplashActivityContract;

/**
 * The type Time presenter.
 */
public class TimePresenter extends BaseMvpPresenter<ISplashActivityContract.Iview> implements ISplashActivityContract.IPresenter {

    private CustomCountDownTimer timer;

    public TimePresenter(ISplashActivityContract.Iview iview){
        //将view层的实例传给父类
        super(iview);

    }
    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + " 秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer( "跳过");
            }
        });
        timer.start();
    }

    public void Cancel() {
        timer.cancel();
    }

    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;
    }


    @Override
    public void onDestropy() {
        super.onDestropy();
        Cancel();
        Log.e("hsy","onDestory");
    }
}
