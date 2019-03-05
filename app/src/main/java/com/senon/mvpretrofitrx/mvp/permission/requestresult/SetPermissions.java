package com.senon.mvpretrofitrx.mvp.permission.requestresult;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.senon.mvpretrofitrx.mvp.permission.PermissionUtils;
import com.senon.mvpretrofitrx.mvp.utils.UsualDialogger;


/**
 * 类：SetPermissions
 * 作者： qxc
 * 日期：2018/2/8.
 */

public class SetPermissions {
    /**
     * 打开APP详情页面，引导用户去设置权限
     * @param activity 页面对象
     * @param permissionNames 权限名称（如是多个，使用\n分割）
     */
    private static UsualDialogger dialog2 = null;
    public static void openAppDetails(final Activity activity, String permissionNames) {
        StringBuilder sb = new StringBuilder();
        sb.append(PermissionUtils.PermissionTip1);
        sb.append(permissionNames);
        sb.append(PermissionUtils.PermissionTip2);
        dialog2 = UsualDialogger.Builder(activity)
                .setTitle("警告提示！")
                .setMessage(sb.toString()+"-"+permissionNames)
              .setOnConfirmClickListener(PermissionUtils.PermissionDialogPositiveButton, new UsualDialogger.onConfirmClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent intent = new Intent();
                      intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                      intent.addCategory(Intent.CATEGORY_DEFAULT);
                      intent.setData(Uri.parse("package:" + activity.getPackageName()));
                      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                      intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                      intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                      activity.startActivity(intent);
                  }
              })

                .setOnCancelClickListener(PermissionUtils.PermissionDialogNegativeButton, new UsualDialogger.onCancelClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dialog2 != null) {
                            dialog2.dismiss();
                        }
                    }
                })
                .build()
                .shown();
    }
}
