package com.cubehuang.todayinformation;

public class TimePresenter {
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

    public void timeCancel() {
        timer.cancel();
    }
}
