package com.cubehuang.todayinformation.main;

import androidx.fragment.app.Fragment;

import com.cubehuang.todayinformation.mvp.IMVPView;
import com.cubehuang.todayinformation.mvp.IlifeCircle;
import com.cubehuang.todayinformation.mvp.MvpControler;

public interface IMainActivityContract {


    interface Iview extends IMVPView {


        void showFragment(Fragment fragment);

        void hideFragment(Fragment fragment);

        void addFragment(Fragment fragment);
    }
    interface IPresenter extends IlifeCircle {

        void initFragement();

        void replaceFragment(int mCurrentFragment);

        int getTopPosition();

        int getBottomPosition();

        int getmCurrentCheckId();
    }
    Iview emptyView =  new Iview() {
        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };

    

}
