package com.cubehuang.todayinformation;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable{
    private int time;
    private int countDown;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private  Boolean isRun;

    //1.实现倒计时，传入倒计时的时间，时时调用主界面的text
    //2.每一秒时间减一
    //3.倒计时结束w为0时完成,恢复为"跳过"
    public CustomCountDownTimer(int time, ICountDownHandler countDownHandler){
        handler = new Handler();
        this.time = time;
        countDown = time;
        this.countDownHandler = countDownHandler;
    }
    //观察者回调接口 IOC
    public interface ICountDownHandler{
         void onTicker(int time);

         void onFinish();

    }
    //实现具体功能
    @Override
    public void run() {
        if (isRun){
            if (countDownHandler != null){
                countDownHandler.onTicker(countDown);
            }
            if (countDown == 0){
                if (countDownHandler != null){
                    countDownHandler.onFinish();
                }
                cancel();

            }else {//每隔一秒 -1
                countDown = time--;
                handler.postDelayed(this,1000);
            }
        }

    }
    //开启方法计时
    public void start(){
        isRun = true;
        handler.post(this);
    }
    //结束计时
    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }
}
