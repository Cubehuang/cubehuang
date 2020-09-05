package com.cubehuang.todayinformation.mvp.BaseMcpActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;

import com.cubehuang.todayinformation.Viewinject;
import com.cubehuang.todayinformation.mvp.presenter.LifeCircleMvpActivity;

import java.lang.annotation.Annotation;

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

    private void bindeView() {

        ButterKnife.bind(this);
    }
}
