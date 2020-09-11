package com.cubehuang.todayinformation.main.shanghai;

import android.util.Log;
import android.widget.Toolbar;

import com.cubehuang.todayinformation.R;
import com.cubehuang.todayinformation.base.BaseFragment;
import com.cubehuang.todayinformation.base.Viewinject;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import butterknife.BindView;

@Viewinject(mainlayoutid = R.layout.fragment_shanghai)
public class ShanghaiFragment extends BaseFragment {
    @BindView(R.id.shanghai_appBar)
    AppBarLayout shanghaiAppBar ;
    @BindView(R.id.tv_shanghai_welcome)
    Toolbar tvShanghaiWelcome;
    @BindView(R.id.shanghai_CollapsingToolbarLayout)
    CollapsingToolbarLayout shanghaiCollapsingToolbarLayout;


    @Override
    public void afterBindView() {
        shanghaiAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.e("shanghaiAppBar","verticaloffset = "+ i+"appBarLayout"+appBarLayout.getMeasuredHeight() );
            }
        });
        Log.e("shanghaiAppBar", "tvShanghaiWelcome =" + tvShanghaiWelcome);
        Log.e("shanghaiAppBar", "shanghaiCollapsingToolbarLayout =" + shanghaiCollapsingToolbarLayout);
        Log.e("shanghaiAppBar", "shanghaiAppBar =" + shanghaiAppBar);
    }
}
