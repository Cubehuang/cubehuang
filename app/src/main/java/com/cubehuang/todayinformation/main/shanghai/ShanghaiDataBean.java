package com.cubehuang.todayinformation.main.shanghai;

import java.util.ArrayList;

public class ShanghaiDataBean {
    private int mItemType = IShanghaiItemType.VERTICAL;//默认是横向的
    private String mDec;
    private boolean isShowImg;
    ArrayList<ShanghaiDataBean> data;

    public int getmItemType() {
        return mItemType;
    }

    public ShanghaiDataBean setmItemType(int mItemType) {
        this.mItemType = mItemType;
        return this;
    }

    public boolean isShowImg() {
        return isShowImg;
    }

    public ShanghaiDataBean setShowImg(boolean showImg) {
        isShowImg = showImg;
        return this;
    }



    public String getmDec() {
        return mDec;
    }

    public ShanghaiDataBean setmDec(String mDec) {
        this.mDec = mDec;
        return this;
    }


    public ArrayList<ShanghaiDataBean> getData() {
        return data;
    }

    public ShanghaiDataBean setData(ArrayList<ShanghaiDataBean> data) {
        this.data = data;
        return this;
    }
    /*
    创建一个接口构建类型
     */

    public interface IShanghaiItemType{
         int VERTICAL = 0;
         int HORIZANTAL = 1;
    }


}
