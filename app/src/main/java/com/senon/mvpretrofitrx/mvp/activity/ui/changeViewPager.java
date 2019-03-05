package com.senon.mvpretrofitrx.mvp.activity.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.base.BaseActivity;
import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseView;
import com.senon.mvpretrofitrx.mvp.utils.SimpleViewPagerIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class changeViewPager extends BaseActivity {
    @BindView(R.id.view_indicator_live)
    SimpleViewPagerIndicator viewIndicatorLive;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_viewpager;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
