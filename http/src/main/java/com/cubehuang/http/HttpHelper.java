package com.cubehuang.http;

import com.cubehuang.http.request.HttpScheduler;
import com.cubehuang.http.request.call.ICall;
import com.cubehuang.http.okhttp.OkHttpScheduler;

import java.util.Map;


public class HttpHelper {
    private volatile static HttpScheduler httpScheduler;

    public static HttpScheduler getHttpScheduler(){
        if (httpScheduler == null){
            synchronized (HttpHelper.class){
                if (httpScheduler == null){
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }

    //Todo:2020/10/8
    protected static Object execute(IRequest request, Map<String,Object> params){
        //这里需要做的就是将参数params封装进request（host，path）中
        request.setParams(params);
        //根据request创建一个call
        ICall call = getHttpScheduler().newCall(request);
        Object object = getHttpScheduler().execute(call);

        return object;

    }
}
