package com.cubehuang.todayinformation.main.shanghai;

import java.util.ArrayList;

public class ShanghaiDataManager {
    /*
    * 获取纵向数据*/
    private static ArrayList<ShanghaiDataBean> getVerData(int len){
        ArrayList<ShanghaiDataBean> mList = new ArrayList<ShanghaiDataBean>();
        for (int i = 0; i < len; i++){
            ShanghaiDataBean bean = new ShanghaiDataBean();
            bean.setmDec("上海欢迎你").setShowImg(false);
            mList.add(bean);
        }

        return mList;
    }
    /*
    * =获取横向数据*/
    private static ArrayList<ShanghaiDataBean> getHorData(int len){
        ArrayList<ShanghaiDataBean> mList = new ArrayList<ShanghaiDataBean>();
        for (int i = 0; i < len; i++){
            ShanghaiDataBean bean = new ShanghaiDataBean();
            bean.setmDec("上海是魔都").setShowImg(true);
            mList.add(bean);
        }

        return mList;
    }

    public static  ArrayList<ShanghaiDataBean> getData(int Vlen, int Hlen){
        ArrayList<ShanghaiDataBean> data = new ArrayList<>();
        data.addAll(getVerData(Vlen));
        data.add(new ShanghaiDataBean().setData(getHorData(Hlen)).setmItemType(ShanghaiDataBean.IShanghaiItemType.HORIZANTAL));
        data.addAll(getVerData(Vlen));
        data.add(new ShanghaiDataBean().setData(getHorData(Hlen)).setmItemType(ShanghaiDataBean.IShanghaiItemType.HORIZANTAL));
        return data;
    }
}
