package com.cubehuang.todayinformation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FullScreenVideoView extends VideoView {
    //主要用于直接new出来的对象
    public FullScreenVideoView(Context context){
        super(context);
    }
    //主要用于xml文件中支持自定义属性
    public FullScreenVideoView(Context context, AttributeSet attrs){
        super(context, attrs);
    }
    //也是用于xml文件中，同时支持style样式
    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    //重写onMeasure方法获得原始的宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //widthMeasureSpec包含两个主要的内容1、测量模式2、测量大小
        int width = getDefaultSize(0,widthMeasureSpec);
        int height = getDefaultSize(0,heightMeasureSpec);
        //设置这个View的大小
        setMeasuredDimension(width, height);
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
