package com.senon.mvpretrofitrx.mvp.model;

import android.content.Context;
import android.util.Log;

import com.senon.mvpretrofitrx.mvp.api.Api;
import com.senon.mvpretrofitrx.mvp.base.BaseModel;
import com.senon.mvpretrofitrx.mvp.progress.ObserverResponseListener;

import java.util.HashMap;

import io.reactivex.ObservableTransformer;

/**
 * 作者：senon on 2017/12/27 10:33
 * 邮箱：a1083911695@163.com
 */
public class Fragment_twoM<T> extends BaseModel {

    public void getTodayNews(Context context, HashMap<String,String> map, boolean isDialog, boolean cancelable,
                      ObservableTransformer<T,T> transformer, ObserverResponseListener observerListener){
        subscribe(context, Api.getApiService().getTodayNews(map),
                observerListener,transformer,isDialog,cancelable);
        for (String key : map.keySet()) {
            Log.e("今日头条", "postHttp: key "+key+"      "+map.get(key));
        }
    }
    public void getTodayVideo(Context context, HashMap<String,String> map, boolean isDialog, boolean cancelable,
                             ObservableTransformer<T,T> transformer, ObserverResponseListener observerListener){
        subscribe(context, Api.getApiService().getTodayVideo(map),
                observerListener,transformer,isDialog,cancelable);
        for (String key : map.keySet()) {
            Log.e("今日头条", "视频 key "+key+"      "+map.get(key));
        }
    }
}
