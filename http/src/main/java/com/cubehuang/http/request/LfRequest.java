package com.cubehuang.http.request;

import com.cubehuang.http.IRequest;
import com.cubehuang.http.anntation.RequestMethod;
import com.cubehuang.http.request.host.IHost;

import java.util.Map;

public class LfRequest implements IRequest {
    protected IHost host;//host还要封装一层所以还要定义一个IHost接口进行封装

    protected String path;

    protected Map<String, Object> params;
    //使用@RequestMethod做一下修饰限定
    @RequestMethod
    protected int requestMethod;

    @Override
    public void setParams(Map<String, Object> params) {
     this.params = params;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public int getRequestMethod() {
        return requestMethod;
    }

    @Override
    public IHost getHost() {
        return host;
    }

    @Override
    public String getPath() {
        return path;
    }
}
