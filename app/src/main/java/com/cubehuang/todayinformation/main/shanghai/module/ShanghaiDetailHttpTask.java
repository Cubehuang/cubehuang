package com.cubehuang.todayinformation.main.shanghai.module;

import com.cubehuang.http.LfHttpTask;

import java.util.HashMap;
import java.util.Map;

// TODO: 2020/9/26
public class ShanghaiDetailHttpTask extends LfHttpTask {
    public Object getXiaohuaList(String sort, String page, String pagesize){
        /*HttpUrl.Builder builder = HttpUrl.parse("http://v.juhe.cn/joke/content/list.php").newBuilder();
        builder.addQueryParameter("sort","desc");
        builder.addQueryParameter("page","1");
        builder.addQueryParameter("pagesize","2");
        builder.addQueryParameter("time",""+System.currentTimeMillis()/1000);
        builder.addQueryParameter("key","bbc57dd5e4f05991aff09eafd2e667e0");*/
        /*这里我们使用一个HashMap进行封装*/
        Map<String,Object> params = new HashMap<>();
        params.put(sort,"desc");
        params.put(page,"1");
        params.put(pagesize,"2");
        params.put("time",""+System.currentTimeMillis()/1000);
        params.put("key","bbc57dd5e4f05991aff09eafd2e667e0");
        //那么如何发送请求呢？如下：(我们让该类继承一个LfHttpTask，该LfHttpTask是写在http module下面的)
        return super.execute(ShanghaiDetailRequest.xiaoHuaRequest,params);
    }
}
