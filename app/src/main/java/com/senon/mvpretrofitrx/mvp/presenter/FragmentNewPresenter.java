package com.senon.mvpretrofitrx.mvp.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.senon.mvpretrofitrx.mvp.base.BaseResponse;

import com.senon.mvpretrofitrx.mvp.bean.smalBean;
import com.senon.mvpretrofitrx.mvp.bean.wx;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_NewsC;

import com.senon.mvpretrofitrx.mvp.model.Fragment_newsM;

import com.senon.mvpretrofitrx.mvp.progress.ObserverResponseListener;
import com.senon.mvpretrofitrx.mvp.utils.ExceptionHandle;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;

import java.util.HashMap;
import java.util.List;

/**
 * 作者：senon on 2017/12/27 10:34
 * 邮箱：a1083911695@163.com
 */
public class FragmentNewPresenter extends Fragment_NewsC.Presenter {

    private Fragment_newsM model;
    private Context context;

    public FragmentNewPresenter(Context context) {
        this.model = new Fragment_newsM();
        this.context = context;
    }


    @Override
    public void getSmalNews(HashMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getSmalNews(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object response) {
                Log.i("微头条","mmmmmwx7777  "+response.toString());
                if (getView() != null) {

                    getView().result((BaseResponse<List<smalBean>>) response, false);
                     getView().setMsg(((BaseResponse<List<smalBean>>) response).getMsg());
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
