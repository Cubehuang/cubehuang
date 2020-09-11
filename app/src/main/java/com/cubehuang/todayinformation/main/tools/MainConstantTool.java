package com.cubehuang.todayinformation.main.tools;

import androidx.annotation.IntDef;

import static com.cubehuang.todayinformation.main.tools.MainConstantTool.GUANGZHOU;
import static com.cubehuang.todayinformation.main.tools.MainConstantTool.HANGZHOU;
import static com.cubehuang.todayinformation.main.tools.MainConstantTool.SHANGHAI;
import static com.cubehuang.todayinformation.main.tools.MainConstantTool.SHENZHEN;

@IntDef({SHANGHAI,HANGZHOU,GUANGZHOU,SHENZHEN})
public @interface MainConstantTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int GUANGZHOU = 2;
    int SHENZHEN= 3;

}
