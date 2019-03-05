package com.senon.mvpretrofitrx.mvp.activity.fragment;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.base.BaseActivity;
import com.senon.mvpretrofitrx.mvp.base.BaseFragment;
import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseView;

public class videoFragmen extends BaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.video_fragment;
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
}
