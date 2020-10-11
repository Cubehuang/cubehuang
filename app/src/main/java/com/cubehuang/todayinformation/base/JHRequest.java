package com.cubehuang.todayinformation.base;

import com.cubehuang.http.IRequest;
import com.cubehuang.http.anntation.RequestMethod;
import com.cubehuang.http.request.LfRequest;

public class JHRequest extends LfRequest {

    //那么这里我们要做什么呢？
    /*1.就是根据具体的path和请求方式组装一个Request
    * 2.请求方式通过注解获得
    *   2.1在http module下面建一个注解*/
    public static IRequest sendHttp(String path, @RequestMethod int requestMethod){
        JHRequest request = new JHRequest();
        //那么我们要如何封装这个Request呢？
        /*HttpUrl.Builder builder = HttpUrl.parse("http://v.juhe.cn/joke/content/list.php").newBuilder();
        * 1."http://v.juhe.cn/joke/content/list.php"
        * 2.“host/path”
        * 那么：*/
        request.host = HostManager.jhHost;
        request.path = path;
        request.requestMethod = requestMethod;
        return request;

    }
}
