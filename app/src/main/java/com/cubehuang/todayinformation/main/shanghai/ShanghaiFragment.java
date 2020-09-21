package com.cubehuang.todayinformation.main.shanghai;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cubehuang.todayinformation.R;
import com.cubehuang.todayinformation.base.BaseFragment;
import com.cubehuang.todayinformation.base.Viewinject;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

import butterknife.BindView;

@Viewinject(mainlayoutid = R.layout.fragment_shanghai)
public class ShanghaiFragment extends BaseFragment {


    @BindView(R.id.shanghai_CollapsingToolbarLayout)
    CollapsingToolbarLayout shanghaiCollapsingToolbarLayout;
    @BindView(R.id.shanghai_appBar)
    AppBarLayout shanghaiAppBar;
    @BindView(R.id.tv_shanghai_welcome)
    TextView tvShanghaiWelcome;
    @BindView(R.id.rc_shanghai_recyclerView)
    RecyclerView rcShanghaiRecyclerView;


    @Override
    public void afterBindView() {
        initRecyclerView();//初始化
        initListener();

    }

    private void initRecyclerView() {
        rcShanghaiRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));//这个Layoutmanager可以自定义自己想要的效果
        rcShanghaiRecyclerView.setAdapter(new ShanghaiAdapter(getActivity(),ShanghaiDataManager.getData(5,7), false));
    }

    private void initListener() {
        shanghaiAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.e("shanghaiAppBar", "verticaloffset = " + i + "appBarLayout" + appBarLayout.getMeasuredHeight());
                if (-i < appBarLayout.getMeasuredHeight() / 2) {
                    tvShanghaiWelcome.setVisibility(View.INVISIBLE);
                } else {
                    tvShanghaiWelcome.setVisibility(View.VISIBLE);
                }
            }
        });
        Log.e("shanghaiAppBar", "tvShanghaiWelcome =" + tvShanghaiWelcome);
        Log.e("shanghaiAppBar", "shanghaiCollapsingToolbarLayout =" + shanghaiCollapsingToolbarLayout);
        Log.e("shanghaiAppBar", "shanghaiAppBar =" + shanghaiAppBar);
    }
}
