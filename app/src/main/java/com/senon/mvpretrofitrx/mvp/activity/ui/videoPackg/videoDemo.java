package com.senon.mvpretrofitrx.mvp.activity.ui.videoPackg;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.base.BaseActivity;
import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseView;
import com.senon.mvpretrofitrx.mvp.utils.StatusbarUtils;

public class videoDemo extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_videodemo;
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
        StatusbarUtils.enableTranslucentStatusbar(this);
        StatusbarUtils.setStatusBarLightMode(this, StatusbarUtils.StatusBarLightMode(this));
    }
}
