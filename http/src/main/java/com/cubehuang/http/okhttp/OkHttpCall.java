package com.cubehuang.http.okhttp;

import com.cubehuang.http.IRequest;
import com.cubehuang.http.request.call.ICall;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class OkHttpCall implements ICall {

    private final Call call;

    public OkHttpCall(IRequest request, Call call) {
        this.call = call;
    }

    @Override
    public Object execute() {
        Response excute = null;
        try{
            excute = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excute;
    }
}
