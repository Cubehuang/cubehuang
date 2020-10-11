package com.cubehuang.http;

import java.util.Map;

public class LfHttpTask {
    /*这里的话要完成网络请求，需要什么呢？
    * 1.URL
    * 2.URL中的一些参数（刚刚map进行封装）*/
    protected Object execute(IRequest request, Map<String,Object> params){
        return HttpHelper.execute(request, params);

    }
}
