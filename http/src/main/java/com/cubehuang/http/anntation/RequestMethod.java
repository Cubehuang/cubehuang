package com.cubehuang.http.anntation;

import androidx.annotation.IntDef;

import static com.cubehuang.http.anntation.RequestMethod.Get;
import static com.cubehuang.http.anntation.RequestMethod.Post;

@IntDef({Get,Post})
public @interface RequestMethod {
    int Get = 1;
    int Post = 2;
}
