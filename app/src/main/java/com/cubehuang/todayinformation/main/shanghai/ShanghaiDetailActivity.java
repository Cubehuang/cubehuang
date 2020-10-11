package com.cubehuang.todayinformation.main.shanghai;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

import com.cubehuang.todayinformation.R;
import com.cubehuang.todayinformation.base.BaseActivity;
import com.cubehuang.todayinformation.base.Viewinject;
import com.cubehuang.todayinformation.main.shanghai.module.ShanghaiDetailHttpTask;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Viewinject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity {
    public static String mShanghaiDetailActivity = "ShanghaiDetailActivity";
    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;


    @Override
    public void afterBindView() {
        initAnima();
//        initGetNetData();
//        initPostNetData();

    }

    private void initPostNetData() {

        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("key", "bbc57dd5e4f05991aff09eafd2e667e0");
        Request request = new Request.Builder()
                .url("http://v.juhe.cn/joke/content/list.php")
                .post(builder.build())
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {//异步请求
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("initGetNetData", "onFailure="+e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e("initGetNetData", "onResponse="+response.body().toString());
            }
        });
    }

    /*
    * 发送网络请求*/
    private void initGetNetData() {
        Object desc = new  ShanghaiDetailHttpTask().getXiaohuaList("desc","1" , "2");
        if (desc instanceof Response){
            Response response = (Response) desc;
            Log.e("initGetNetData", response.body().toString());
        }
        /*
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .get()
                .build();
        * 我们不要将URL直接写死为“https://www.baidu.com
        * 我们可以使用系统提供的一个HttpUrl类进行封装
        * 用法：
        *  HttpUrl.parse("接口地址").newBuilder()
        * */


/*//        1、构建URL参数
        HttpUrl.Builder builder = HttpUrl.parse("http://v.juhe.cn/joke/content/list.php").newBuilder();
        builder.addQueryParameter("sort","desc");
        builder.addQueryParameter("page","1");
        builder.addQueryParameter("pagesize","2");
        builder.addQueryParameter("time",""+System.currentTimeMillis()/1000);
        builder.addQueryParameter("key","bbc57dd5e4f05991aff09eafd2e667e0");
        Log.e("initGetNetData","builder"+builder.build().toString());
//        2、构建client
        OkHttpClient client = new OkHttpClient();
//        3.构建request
        Request request = new Request.Builder()
                .url(builder.build())
                .get()
                .build();
//        4.构建call
        Call call = client.newCall(request);
//        5发送网络请求
        call.enqueue(new Callback() {//异步请求
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("initGetNetData", "onFailure="+e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e("initGetNetData", "onResponse="+response.body().toString());
            }
        });*/
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
