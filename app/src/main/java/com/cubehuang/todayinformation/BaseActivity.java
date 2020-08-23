package com.cubehuang.todayinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Viewinject annotation = this.getClass().getAnnotation(Viewinject.class);
        if (annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if (mainlayoutid > 0){
                setContentView(mainlayoutid);
                ButterKnife.bind(this);
            }else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }

    }
}
