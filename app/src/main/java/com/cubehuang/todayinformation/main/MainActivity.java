package com.cubehuang.todayinformation.main;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.cubehuang.todayinformation.R;
import com.cubehuang.todayinformation.base.BaseActivity;
import com.cubehuang.todayinformation.base.Viewinject;
import com.cubehuang.todayinformation.main.tools.MainConstantTool;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindAnim;
import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnItemClick;

@Viewinject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.Iview {

    @BindView(R.id.fac_main)
    FloatingActionButton facMain;
    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.bottom_tab)
    FrameLayout bottomTab;
    @BindView(R.id.rb_main_guangzhou)
    RadioButton rbMainGuangzhou;
    @BindView(R.id.rb_main_shenzhen)
    RadioButton rbMainShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    private boolean isclickbutton;
    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this) {
    };

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }*/

    @Override
    public void afterBindView() {
        changeAnima(rgMainBottom, rgMainTop);
        mPresenter.initFragement();
    }

    @OnClick({R.id.fac_main})
    public void onClick() {
        isclickbutton = !isclickbutton;
        if (isclickbutton) {
            changeAnima(rgMainTop, rgMainBottom);
            handleTopPosition();
        } else {
            changeAnima(rgMainBottom, rgMainTop);
            handleBottomPosition();
        }
    }

    //shanghai 杭州
    private void handleBottomPosition() {
        if (rbMainHangzhou.isChecked()) {
            mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
        } else {
            mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
        }
        /*if (mPresenter.getTopPosition() != 1) {
            mPresenter.replaceFragment(0);
            //rbMainShanghai.setChecked(true);
        }else {


            //rbMainHangzhou.setChecked(true);
        }*/
    }

    //广州 深圳
    private void handleTopPosition() {
        if (rbMainShenzhen.isChecked()) {
            mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
        } else {
            mPresenter.replaceFragment(MainConstantTool.GUANGZHOU);
        }

        /*if (mPresenter.getBottomPosition() != 3) {

            //rbMainGuangzhou.setChecked(true);
        }else {


            //rbMainShenzhen.setChecked(true);
        }*/
    }

    private void changeAnima(RadioGroup gone, RadioGroup show) {
        //清除动画
        gone.clearAnimation();
        //得到动画
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        //启动动画
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    private void showRadioButton(RadioGroup gone, RadioGroup show) {
        gone.setVisibility(View.GONE);

    }

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();

    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rb_main_shanghai,R.id.rb_main_hangzhou,R.id.rb_main_guangzhou,R.id.rb_main_shenzhen})
    public void onClick1(View view) {
        switch (view.getId()){
            case R.id.rb_main_shanghai:
                if (mPresenter.getmCurrentCheckId() != R.id.rb_main_shanghai){
                    mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
                }
                break;
            case R.id.rb_main_hangzhou:
                if (mPresenter.getmCurrentCheckId() != R.id.rb_main_hangzhou){
                    mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
                }
                break;
            case R.id.rb_main_guangzhou:
                if (mPresenter.getmCurrentCheckId() != R.id.rb_main_guangzhou){
                    mPresenter.replaceFragment(MainConstantTool.GUANGZHOU);
                }
                break;
            case R.id.rb_main_shenzhen:
                if (mPresenter.getmCurrentCheckId() != R.id.rb_main_shenzhen){
                    mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
                }
                break;
        }

    }
}
