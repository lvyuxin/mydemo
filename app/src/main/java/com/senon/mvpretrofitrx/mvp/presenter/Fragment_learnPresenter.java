package com.senon.mvpretrofitrx.mvp.presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_filmC;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_learnC;
import com.senon.mvpretrofitrx.mvp.model.Fragment_filmM;
import com.senon.mvpretrofitrx.mvp.model.Fragment_learnM;
import com.senon.mvpretrofitrx.mvp.progress.ObserverResponseListener;
import com.senon.mvpretrofitrx.mvp.utils.ExceptionHandle;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;

import java.util.HashMap;

/**
 * 作者：senon on 2017/12/27 10:34
 * 邮箱：a1083911695@163.com
 */
public class Fragment_learnPresenter extends Fragment_learnC.Presenter {

    private Fragment_learnM model;
    private Context context;

    public Fragment_learnPresenter(Context context) {
        this.model = new Fragment_learnM();
        this.context = context;
    }


    @Override
    public void getLearn(String  map, boolean isDialog, boolean cancelable) {
        model.getLearn(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object date) {
                if (getView() != null) {
                    String jsonString=new Gson().toJson(date);
                    getView().result(jsonString, false);
                    Log.i("首页","bbbbbbbbbbbbbbb  "+jsonString);

                }
            }
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if(getView() != null){
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

    @Override
    public void collect(String map, boolean isDialog, boolean cancelable) {
        model.collect(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object date) {
                if (getView() != null) {
                    String jsonString=new Gson().toJson(date);
                    getView().collect(jsonString, false);
                    Log.i("首页","bbbbbbbbbbbbbbb  "+jsonString);

                }
            }
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if(getView() != null){
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

    @Override
    public void canaelCollect(String map, boolean isDialog, boolean cancelable) {
        model.cancelCollect(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object date) {
                if (getView() != null) {
                    String jsonString=new Gson().toJson(date);
                    getView().cancelCollect(jsonString, false);
                    Log.i("首页","bbbbbbbbbbbbbbb  "+jsonString);

                }
            }
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if(getView() != null){
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

    @Override
    public void canaelCollectList(String map, boolean isDialog, boolean cancelable) {
        model.cancelCollect(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object date) {
                if (getView() != null) {
                    String jsonString=new Gson().toJson(date);
                    getView().collectList(jsonString, false);
                    Log.i("首页","bbbbbbbbbbbbbbb  "+jsonString);

                }
            }
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if(getView() != null){
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }


}
