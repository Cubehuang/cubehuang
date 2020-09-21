package com.cubehuang.todayinformation.main.shanghai;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cubehuang.todayinformation.R;

import java.util.ArrayList;


public class ShanghaiAdapter extends RecyclerView.Adapter {
    private final boolean isHor;
    private final RecyclerView.RecycledViewPool recycledViewPool;
    public ArrayList<ShanghaiDataBean> mData;
    public Activity mContext;
    /*
    * 通过构造方法获取外部数据
    * */
    public ShanghaiAdapter(Activity mContext, ArrayList<ShanghaiDataBean> mData, boolean isHor){
        this.mContext = mContext;
        this.mData = mData;
        this.isHor = isHor;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }
    /*
     * 设计自己想要的UI界面*/
    public class ShanghaiViewholder extends RecyclerView.ViewHolder{
        public TextView mTv;
        public ImageView mIv;

        public ShanghaiViewholder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv_shanghai_welcome1);
            mIv = itemView.findViewById(R.id.iv_shanghai_rv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShanghaiDetailActivity.start_5_0(mContext,mIv);
                }
            });
        }
    }
    /*
    * 水平的UI*/
    public class ShanghaiViewholderRv extends RecyclerView.ViewHolder{

        public RecyclerView mRecyclerView;

        public ShanghaiViewholderRv(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.rv_shanghai_v);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false);

            /*优化点
            * 1.*/
            /*当RecyclerView和这个Manager解除绑定时候,设置为true这些View将会被回收给其他RecyclerView使用*/
           // layoutManager.setRecycleChildrenOnDetach(true);
            mRecyclerView.setLayoutManager(layoutManager);
            /*
            * 我们有两个相同的横向滑块，是一模一样的，所以可以进行复用*/
            mRecyclerView.setRecycledViewPool(recycledViewPool);

        }
    }
    /*
    *
    * 创建View进行缓存*/
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ShanghaiDataBean.IShanghaiItemType.VERTICAL){
            if (isHor){
                Log.d("onCreateViewHolder","我被创建");
            }
            View inflate = LayoutInflater .from(parent.getContext()).inflate(R.layout.item_shanghai_fragment,parent,false);//这里要把Lin布局放到parent中
            ShanghaiViewholder shanghaiViewholder = new ShanghaiViewholder(inflate);
            return shanghaiViewholder;
        }else if (viewType == ShanghaiDataBean.IShanghaiItemType.HORIZANTAL){
            View inflate = LayoutInflater .from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_rv,null);
            ShanghaiViewholderRv shanghaiViewholderRv = new ShanghaiViewholderRv(inflate);
            return shanghaiViewholderRv;

        }
        return null;

    }
    /*
    * 进行数据绑定*/
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ShanghaiDataBean s = mData.get(position);

        if (holder instanceof ShanghaiViewholder){
          ((ShanghaiViewholder) holder).mTv.setText(s.getmDec());
            ((ShanghaiViewholder) holder).mIv.setVisibility(s.isShowImg()?View.VISIBLE:View.GONE);
            ((ShanghaiViewholder) holder).itemView.setTag(position);
        }else if (holder instanceof ShanghaiViewholderRv){

            ((ShanghaiViewholderRv) holder).mRecyclerView.setAdapter(new ShanghaiAdapter(mContext,s.getData(),true));//这里可以用自己从新做一个adapter
            Log.d("onBindViewHolder","我被绑定");
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    /*
    * 做复杂条目要重写这个方法*/
    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getmItemType();//这里的返回值用于onCreateViewHolder(,,类型参数)
    }
}
