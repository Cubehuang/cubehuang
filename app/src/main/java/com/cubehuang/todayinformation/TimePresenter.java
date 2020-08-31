package com.cubehuang.todayinformation;

import com.cubehuang.todayinformation.mvp.BaseMvpPreseter.BaseMvpPresenter;
import com.cubehuang.todayinformation.mvp.IMVPView;
import com.cubehuang.todayinformation.mvp.presenter.LifeCircleMvpPresenter;

public class TimePresenter extends BaseMvpPresenter {
    private final SplashActivity mActivity;
    private CustomCountDownTimer timer;

    public TimePresenter(SplashActivity activity){
        this.mActivity = activity;
    }

    public void startTime() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mActivity.setTvtext(time + " 秒");
            }

            @Override
            public void onFinish() {
                mActivity.setTvtext( "跳过");
            }
        });
        timer.start();
    }

    public void Cancel() {
        timer.cancel();
    }

    @Override
    protected IMVPView getEmptyView() {
        return null;
    }

    @Override
    public void onDestropy() {
        super.onDestropy();
        Cancel();
    }
}
