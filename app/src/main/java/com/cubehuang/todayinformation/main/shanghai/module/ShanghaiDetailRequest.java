package com.cubehuang.todayinformation.main.shanghai.module;

import com.cubehuang.http.IRequest;
import com.cubehuang.http.anntation.RequestMethod;
import com.cubehuang.todayinformation.base.JHRequest;

public interface ShanghaiDetailRequest {
    //获取一个Request，从哪里获得呢？
    /*我们可以封装一个类JHRequest*/
    IRequest xiaoHuaRequest = JHRequest.sendHttp("/joke/content/list.php", RequestMethod.Get);
}
