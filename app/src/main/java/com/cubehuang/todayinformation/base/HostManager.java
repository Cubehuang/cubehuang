package com.cubehuang.todayinformation.base;

import com.cubehuang.http.request.host.IHost;

public interface HostManager {
    IHost jhHost = new IHost() {
        @Override
        public String getHost() {
            return "http://v.juhe.cn";
        }

        @Override
        public String getDefaulPath() {
            return "/joke/content/list.php";
        }
    };
}
