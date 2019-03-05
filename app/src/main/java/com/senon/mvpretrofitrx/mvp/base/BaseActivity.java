package com.senon.mvpretrofitrx.mvp.base;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.permission.PermissionUtils;
import com.senon.mvpretrofitrx.mvp.permission.request.IRequestPermissions;
import com.senon.mvpretrofitrx.mvp.permission.request.RequestPermissions;
import com.senon.mvpretrofitrx.mvp.permission.requestresult.IRequestPermissionsResult;
import com.senon.mvpretrofitrx.mvp.permission.requestresult.RequestPermissionsResultSetApp;
import com.senon.mvpretrofitrx.mvp.utils.AppDate;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 作者：senon on 2017/12/27 10:09
 * 邮箱：a1083911695@163.com
 * 父类->基类->动态指定类型->泛型设计（通过泛型指定动态类型->由子类指定，父类只需要规定范围即可）
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends RxAppCompatActivity {

    //引用V层和P层
    private P presenter;
    private V view;

    //由子类指定具体类型
    public abstract int getLayoutId();

    public abstract P createPresenter();

    public abstract V createView();

    public P getPresenter() {
        return presenter;
    }

    public abstract void init();

    public TextView tv_title;
    public TextView tv_right;
    public ImageView im_left;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        ButterKnife.bind(this);
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (view == null) {
            view = createView();
        }
        if (presenter != null && view != null) {
            presenter.attachView(view);
        }
        init();
        initBar();
    }

    public android.support.v7.app.ActionBar actionBar;

    public void initBar() {//去标题头
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    public void setTitle(String title, String rightTitle) {
        tv_title = (TextView) findViewById(R.id.tv_basetitle);
        tv_title.setText(title);

        tv_right = (TextView) findViewById(R.id.tv_baseright);
        tv_right.setText(rightTitle);
        tv_right.setTextColor(Color.GRAY);

        im_left = (ImageView) findViewById(R.id.iv_baseleft);
        im_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    IRequestPermissions requestPermissions = RequestPermissions.getInstance();//动态权限请求
    IRequestPermissionsResult requestPermissionsResult = RequestPermissionsResultSetApp.getInstance();//动态权限请求结果处理

    //请求权限
    public boolean requestPermissionss(String[] permissionsLocation) {
        //开始请求权限
        return requestPermissions.requestPermissions(
                this,
                permissionsLocation,
                PermissionUtils.ResultCode1);
    }

    //用户授权操作结果（可能授权了，也可能未授权）
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //用户给APP授权的结果
        //判断grantResults是否已全部授权，如果是，执行相应操作，如果否，提醒开启权限
        Log.i("权限 ","requestCode  "+requestCode);
        if (requestPermissionsResult.doRequestPermissionsResult(this, permissions, grantResults)) {
            //请求的权限全部授权成功，此处可以做自己想做的事了
            //输出授权结果
            Toast.makeText(this, "授权成功，请重新点击刚才的操作！", Toast.LENGTH_LONG).show();
        } else {
            //输出授权结果
            Toast.makeText(this,"请给APP授权，否则功能无法正常使用！",Toast.LENGTH_LONG).show();

        }
    }

}
