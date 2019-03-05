package com.senon.mvpretrofitrx.mvp.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.utils.AppDate;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：senon on 2017/12/27 15:59
 * 邮箱：a1083911695@163.com
 * 父类->基类->动态指定类型->泛型设计（通过泛型指定动态类型->由子类指定，父类只需要规定范围即可）
 */
public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends RxFragment {
Activity  mActivity;
    //引用V层和P层
    private P presenter;
    private V view;
    public Context mContext;
    private Unbinder unbinder;

    public P getPresenter() {
        return presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        mContext = getActivity();
        mActivity=getActivity();
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (this.view == null) {
            this.view = createView();
        }
        if (presenter != null && view != null) {
            presenter.attachView(this.view);
        }

        init();
        return view;
    }

    //由子类指定具体类型
    public abstract int getLayoutId();
    public abstract P createPresenter();
    public abstract V createView();
    public abstract void init();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    private static int REQUEST_CODE = 0x00099;

    public void permissionSuccess(int requestCode) {
        Log.d("permission", "获取权限成功=" + requestCode);

    }

    public void permissionFail(int requestCode) {
        Log.d("permission", "获取权限失败=" + requestCode);

    }

    /**
     * 第一步
     * 检查权限集合
     *
     * @param permissions
     * @return
     */
    private boolean checkPermission(String[] permissions) {
        if (AppDate.SDK_VERSION < Build.VERSION_CODES.M) {
            return true;
        }
        for (String permission : permissions) {
            if (permissionSet(permission)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查是否缺少权限
     *
     * @param permission
     * @return
     */
    private boolean permissionSet(String permission) {
        return ContextCompat.checkSelfPermission(mActivity, permission) != PackageManager.PERMISSION_GRANTED;
    }


    /**
     * 第二步:获取权限集合中需要申请的列表
     */
    private List<String> getDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(mActivity, permission) !=
                    PackageManager.PERMISSION_GRANTED ||
                    shouldShowRequestPermissionRationale(permission)) {
                needRequestPermissionList.add(permission);
            }
        }
        return needRequestPermissionList;
    }

    /**
     * 请求权限
     *
     * @param premissions 请求的权限
     * @param requestCode 请求权限的请求码
     */
    public void requestPermission(String[] premissions, int requestCode) {
        this.REQUEST_CODE = requestCode;
        if (checkPermission(premissions)) {
            permissionSuccess(REQUEST_CODE);//请求成功
        } else {
            List<String> needPermission = getDeniedPermissions(premissions);
            requestPermissions(needPermission.toArray(new String[needPermission.size()]), REQUEST_CODE);
        }

    }

    /**
     * 用户权限chuli
     * 如果全部获取, 则直接过.
     * 如果权限缺失, 则提示Dialog.
     * 第四部处理权限请求回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (hasAllPressionsGrented(grantResults)) {
                permissionSuccess(REQUEST_CODE);
            } else {
                permissionFail(REQUEST_CODE);
            }
            for (int i = 0; i < permissions.length; i++) {
                boolean isTip = shouldShowRequestPermissionRationale(permissions[i]);
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    if (!isTip) {//表明用户没有彻底禁止弹出权限请求
                        showMissPerssionDialog();
                    }
                    return;
                }
            }
        }
    }


    /**
     * 是否含有全部权限,确认所有的权限是否都已授权
     *
     * @param grentedResults
     * @return
     */
    private boolean hasAllPressionsGrented(int[] grentedResults) {
        for (int grentedResult : grentedResults) {
            if (grentedResult != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 显示缺失权限对话框提示
     */
    private void showMissPerssionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.permission_prompt));
        builder.setMessage(getString(R.string.permission_help));
        builder.setNegativeButton(getString(R.string.permission_quit), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                dialog.cancel();

            }
        });
        builder.setPositiveButton(getString(R.string.permission_commit), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startMobSetting();
            }
        });
        builder.show();
    }


    /**
     * 启动应用设置
     */
    private void startMobSetting() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
        startActivity(intent);
    }
}