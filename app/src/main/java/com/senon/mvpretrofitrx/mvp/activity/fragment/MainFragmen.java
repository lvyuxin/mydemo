package com.senon.mvpretrofitrx.mvp.activity.fragment;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.john.waveview.WaveView;
import com.senon.mvpretrofitrx.BuildConfig;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.activity.LoginActivity;
import com.senon.mvpretrofitrx.mvp.activity.ui.AboutActivity;
import com.senon.mvpretrofitrx.mvp.base.BaseFragment;
import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseView;
import com.senon.mvpretrofitrx.mvp.utils.AppDate;
import com.senon.mvpretrofitrx.mvp.utils.GlideCircleTransform;
import com.senon.mvpretrofitrx.mvp.utils.SpUtil;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainFragmen extends BaseFragment {
    @BindView(R.id.wave_view)
    WaveView waveView;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    Unbinder unbinder;
    @BindView(R.id.ll_friend_zone)
    LinearLayout llFriendZone;
    @BindView(R.id.ll_daynight_toggle)
    LinearLayout llDaynightToggle;
    @BindView(R.id.ll_daynight_about)
    LinearLayout llDaynightAbout;
    @BindView(R.id.bt_quite)
    Button btQuite;
    @BindView(R.id.user)
    TextView user;
    String name = SpUtil.getString(getActivity(), AppDate.userName, "");

    @Override
    public int getLayoutId() {
        return R.layout.frag_main;
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
        String head = SpUtil.getString(getActivity(), AppDate.head, "");
        if (!TextUtils.isEmpty(name)) {
            user.setText(name);
        } else {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }
        if (!TextUtils.isEmpty(head)) {
            Glide.with(mContext)
                    .load(Uri.parse(head))
                    .placeholder(R.drawable.me_3)
                    .bitmapTransform(new GlideCircleTransform(mContext))
                    .crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imgLogo);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //拍照权限
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};
    private int takePhoto = 1;

    @OnClick(R.id.img_logo)
    public void onViewClicked() {
        requestPermission(permissions, takePhoto);

    }

    private List<Uri> mPaths;
    String tag = "我的";

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
//            mPaths = Matisse.obtainPathResult(data);//string
            mPaths = Matisse.obtainResult(data);//uri
            Log.i(tag, "  vvvv  " + mPaths.get(0));
            SpUtil.putString(getActivity(), AppDate.head, mPaths.get(0).toString());
            Glide.with(mContext)
                    .load(mPaths.get(0))
                    .centerCrop()
                    .placeholder(R.drawable.me_3)
                    .bitmapTransform(new GlideCircleTransform(mContext))
                    .crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imgLogo);


        }
    }

    @Override
    public void permissionSuccess(int requestCode) {
        super.permissionSuccess(requestCode);
        Matisse.from(this)
                .choose(MimeType.ofImage())
                .countable(false)
                .capture(true)//启用相机
                .captureStrategy(new CaptureStrategy(true,
                        BuildConfig.APPLICATION_ID + ".provider"))//自定义FileProvider
                .maxSelectable(1)
                .theme(R.style.Matisse_Zhihu)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(10);
    }

    @Override
    public void permissionFail(int requestCode) {
        super.permissionFail(requestCode);
        ToastUtil.showShortToast("获取权限失败");
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @OnClick({R.id.ll_friend_zone, R.id.ll_daynight_toggle, R.id.ll_daynight_about, R.id.bt_quite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_friend_zone:
                break;
            case R.id.ll_daynight_toggle:
                break;
            case R.id.ll_daynight_about:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
            case R.id.bt_quite:
                startActivity(new Intent(getActivity(), LoginActivity.class));

                break;
        }
    }
}
