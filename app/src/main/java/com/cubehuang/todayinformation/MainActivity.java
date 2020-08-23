package com.cubehuang.todayinformation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@Viewinject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {

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
    private boolean isclickbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeAnima(rgMainBottom,rgMainTop);

    }

    @OnClick(R.id.fac_main)
    public void onClick() {
        isclickbutton = !isclickbutton;
        if (isclickbutton) {
            changeAnima(rgMainTop, rgMainBottom);
        } else {
            changeAnima(rgMainBottom,rgMainTop);
        }
    }

    private void changeAnima(RadioGroup gone, RadioGroup show) {
        //清除动画
        gone.clearAnimation();
        //得到动画
        Animation animationGone = AnimationUtils.loadAnimation(this,R.anim.main_tab_translate_hide);
        //启动动画
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this,R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    private void showRadioButton(RadioButton gone, RadioButton show) {
        gone.setVisibility(View.GONE);

    }
}
