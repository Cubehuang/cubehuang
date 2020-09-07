package com.cubehuang.todayinformation.main;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.cubehuang.todayinformation.R;
import com.cubehuang.todayinformation.main.shanghaiFragment.shanghaiFragment.GuangzhouFragment;
import com.cubehuang.todayinformation.main.shanghaiFragment.shanghaiFragment.HangzhouFragment;
import com.cubehuang.todayinformation.main.shanghaiFragment.shanghaiFragment.ShanghaiFragment;
import com.cubehuang.todayinformation.main.shanghaiFragment.shanghaiFragment.ShengzhenFragment;
import com.cubehuang.todayinformation.mvp.BaseMvpPreseter.BaseMvpPresenter;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.Iview> implements IMainActivityContract.IPresenter {
    private int mCurrentFragment;
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentCheckId;
    private int mBottomPosition;
    private int mTopPosition;

    public MainActivityPresenter(IMainActivityContract.Iview view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.Iview getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    @Override
    public void initFragement() {
        mCurrentFragment = 0;
        replaceFragment(mCurrentFragment);
    }
    //替换复用Fragment
    public void replaceFragment(int mCurrentFragment) {
        for (int i = 0; i <mFragments.length; i++){
            if (mCurrentFragment != i){
                if (mFragments[i] != null){
                    hideFragment(mFragments[i]);
                }
            }
        }

        Fragment fragment = mFragments[mCurrentFragment];
        if (fragment != null){
            addAndshowFragment(fragment);
            setCurChecked(mCurrentFragment);
        }else {
            newCurrentFragment(mCurrentFragment);
            setCurChecked(mCurrentFragment);
        }

    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPosition;
    }

    @Override
    public int getmCurrentCheckId() {
        return mCurrentCheckId;
    }

    //记录当前fragment的角标
    private void setCurChecked(int mCurrentFragment) {
        this.mCurrentFragment = mCurrentFragment;
        switch (mCurrentFragment){
            case 0:
                this.mCurrentCheckId = R.id.rb_main_shanghai;
                mTopPosition = 0;
                break;
            case 1:
                this.mCurrentCheckId = R.id.rb_main_hangzhou;
                mTopPosition = 1;
                break;
            case 2:
                this.mCurrentCheckId = R.id.rb_main_guangzhou;
                mBottomPosition = 2;
                break;
            case 3:
                this.mCurrentCheckId = R.id.rb_main_shenzhen;
                mBottomPosition = 3;
                break;
        }

    }

    //创建当前Fragment
    private void newCurrentFragment(int mCurrentFragment) {
        Fragment fragment = null;
        switch (mCurrentFragment){
            case 0:
                fragment = new ShanghaiFragment();
                break;
            case 1:
                fragment = new HangzhouFragment();
                break;
            case 2:
                fragment = new GuangzhouFragment();
                break;
            case 3:
                fragment = new ShengzhenFragment();
                break;
        }
        mFragments[mCurrentFragment] = fragment;
        if (fragment != null){
            addAndshowFragment(fragment);
        }

    }

    //显示Fragment
    private void addAndshowFragment(Fragment fragment) {
        if (fragment.isAdded()){
            getView().showFragment(fragment);
        }else {
            getView().addFragment(fragment);
        }

    }

    //隐藏Fragment
    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()){
            getView().hideFragment(fragment);
        }

    }

    @Override
    public void onResume() {
        Log.d("hsy","onResume");
        super.onResume();
    }
}
