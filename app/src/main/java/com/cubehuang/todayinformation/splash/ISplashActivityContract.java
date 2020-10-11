package com.cubehuang.todayinformation.splash;

import com.cubehuang.mvp.mvp.IMVPView;
import com.cubehuang.mvp.mvp.IlifeCircle;
import com.cubehuang.mvp.mvp.MvpControler;

public interface ISplashActivityContract {
    interface Iview extends IMVPView {
        void setTvTimer(String timer);

    }
    interface IPresenter extends IlifeCircle {
        void initTimer();
    }

    Iview emptyView = new Iview() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };

}
