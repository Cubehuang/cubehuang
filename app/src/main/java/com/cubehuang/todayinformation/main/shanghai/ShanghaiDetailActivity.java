package com.cubehuang.todayinformation.main.shanghai;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

import com.cubehuang.todayinformation.R;
import com.cubehuang.todayinformation.base.BaseActivity;
import com.cubehuang.todayinformation.base.Viewinject;

import butterknife.BindView;

@Viewinject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity {
    public static String mShanghaiDetailActivity = "ShanghaiDetailActivity";
    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;


    @Override
    public void afterBindView() {
        initAnima();

    }

    private void initAnima() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
           /* ViewCompat.setTransitionName(ivShanghaiDetail,mShanghaiDetailActivity);清单文件中已经配置字符串*/

            /*
             * 延时加载
             * 可以用在网络加载时候等网络加载完毕*/
//            postponeEnterTransition();
            /*
            * 开启转场动画*/
            startPostponedEnterTransition();

        }
    }

    /*
    * 转场动画，共享元素pair实现，android5.0以上使用*/
    public static void start_5_0(Activity activity, View v){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Pair pair = new Pair(v,mShanghaiDetailActivity);
            Intent intent = new Intent(activity,ShanghaiDetailActivity.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,pair);
            ActivityCompat.startActivity(activity,intent,optionsCompat.toBundle());
        }
    }
}
