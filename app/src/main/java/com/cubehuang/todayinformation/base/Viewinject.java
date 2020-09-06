package com.cubehuang.todayinformation.base;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
* Created by huangshiyu 2020/8/23
* */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Viewinject {
    int mainlayoutid() default -1;
}
