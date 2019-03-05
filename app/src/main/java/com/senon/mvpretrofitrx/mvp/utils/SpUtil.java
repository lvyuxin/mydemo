package com.senon.mvpretrofitrx.mvp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class SpUtil {
    private static SharedPreferences sp;
    private SharedPreferences.Editor editor;
    /**
     * 获取包信息
     *
     * @param context
     * @return
     */
    public static PackageInfo getPackageInfo(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            return pm.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {

        }
        return new PackageInfo();
    }


    public static void putBoolean(Context ctx,String key,boolean value){
        if(sp==null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }

        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context ctx,String key,boolean defValue){
        if(sp==null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    public static void putLong(Context ctx,String key,long value){
        if(sp==null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        sp.edit().putLong(key, value).commit();
    }
    public static long getLong(Context ctx,String key,long defValue){
        if(sp==null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        return sp.getLong(key, defValue);
    }
    public static void putString(Context ctx,String key,String value){
        if(sp==null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context ctx,String key,String defValue){
        if(sp==null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    public static int getInt(Context ctx,String key,int defValue) {
        if(sp==null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }

    public static void putInt(Context ctx,String key,int value) {
        if(sp==null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).commit();
    }




    /**
     * @param ctx	上下文环境
     * @param key	移除节点名称
     * 根据key 去移除xml中,此key指向的节点
     */
    public static void remove(Context ctx, String key) {
        if(sp==null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        sp.edit().remove(key).commit();
    }
}
