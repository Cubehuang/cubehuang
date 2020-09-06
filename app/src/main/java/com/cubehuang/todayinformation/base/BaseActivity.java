package com.cubehuang.todayinformation.base;

import android.os.Bundle;

import com.cubehuang.todayinformation.base.Viewinject;
import com.cubehuang.todayinformation.mvp.presenter.LifeCircleMvpActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Viewinject annotation = this.getClass().getAnnotation(Viewinject.class);
        if (annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if (mainlayoutid > 0){
                setContentView(mainlayoutid);
                bindeView();
                afterBindView();

            }else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }

    }
//模板方法 设计模式
    public abstract void afterBindView();
//View的依赖注入绑定
    private void bindeView() {

        ButterKnife.bind(this);
    }
}
