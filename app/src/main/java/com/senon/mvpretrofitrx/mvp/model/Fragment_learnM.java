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
public class Fragment_learnM<T> extends BaseModel {

    public void getLearn(Context context, String  map, boolean isDialog, boolean cancelable,
                        ObservableTransformer<T,T> transformer, ObserverResponseListener observerListener){
        subscribe(context, Api.getApiService().getLearnDate(map),
                observerListener,transformer,isDialog,cancelable);

    }
    public void getLearnList(Context context, String  map, boolean isDialog, boolean cancelable,
                         ObservableTransformer<T,T> transformer, ObserverResponseListener observerListener){
        subscribe(context, Api.getApiService().CollectList(map),
                observerListener,transformer,isDialog,cancelable);

    }
    public void collect(Context context, String  map, boolean isDialog, boolean cancelable,
                         ObservableTransformer<T,T> transformer, ObserverResponseListener observerListener){
        subscribe(context, Api.getApiService().Collect(map),
                observerListener,transformer,isDialog,cancelable);
        Log.e("首页", "微信: key "+ map);
    }
    public void cancelCollect(Context context, String  map, boolean isDialog,
                              boolean cancelable,
                         ObservableTransformer<T,T> transformer,
                              ObserverResponseListener observerListener){
        subscribe(context, Api.getApiService().cancelCollect(map),
                observerListener,transformer,isDialog,cancelable);
        Log.e("首页", "微信:2222 key "+ map);
    }
}
