package com.cubehuang.http.okhttp;

import com.cubehuang.http.IRequest;
import com.cubehuang.http.anntation.RequestMethod;
import com.cubehuang.http.request.HttpScheduler;
import com.cubehuang.http.request.call.ICall;

import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public  class OkHttpScheduler extends HttpScheduler {
    private OkHttpClient client;

    @Override
    public ICall newCall(IRequest request) {
        Map<String, Object> params = request.getParams();
        int requestMethod = request.getRequestMethod();
        Request.Builder requestBuilder = new Request.Builder();
        if (requestMethod == RequestMethod.Get) {

            //拼接Get请求的url host + path
            StringBuilder urlStrBuilder = new StringBuilder(request.getHost().getHost());
            urlStrBuilder.append(request.getPath());
            HttpUrl.Builder urlBuilder = HttpUrl.parse(urlStrBuilder.toString()).newBuilder();



            if (params != null && params.size() > 0){
                Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, Object> next = iterator.next();

                    //TODO 将value转为String,涉及对象转为string
                    urlBuilder.addQueryParameter(next.getKey(), String.valueOf(next.getValue()));
                }
            }
            requestBuilder.get().url(urlBuilder.build());
        }else if (requestMethod == RequestMethod.Post){
            //TODO 和上面差不多，稍后完善
        }
        Request okHttpRequest = requestBuilder.build();
        Call call = getClient().newCall(okHttpRequest);
        OkHttpCall okHttpCall = new OkHttpCall(request, call);
        return okHttpCall;
    }

    private OkHttpClient getClient() {
        if (client == null){
            client = new OkHttpClient();
        }
        return client;
    }
}
