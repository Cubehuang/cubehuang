package com.cubehuang.http.request;

import com.cubehuang.http.IRequest;
import com.cubehuang.http.request.call.ICall;

public abstract class HttpScheduler {
    public abstract ICall newCall(IRequest request);

    public Object execute(ICall call){
        return call.execute();
    }

}
