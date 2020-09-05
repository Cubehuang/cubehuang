package com.cubehuang.todayinformation.mvp;

public interface ISplashActivityContract {
    interface Iview extends IMVPView{
        void setTvTimer(String timer);

    }
    interface IPresenter extends IlifeCircle{
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
