package com.senon.mvpretrofitrx.mvp.presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_learnC;
import com.senon.mvpretrofitrx.mvp.contract.LoginC;
import com.senon.mvpretrofitrx.mvp.model.Fragment_learnM;
import com.senon.mvpretrofitrx.mvp.model.LoginM;
import com.senon.mvpretrofitrx.mvp.progress.ObserverResponseListener;
import com.senon.mvpretrofitrx.mvp.utils.ExceptionHandle;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;

import java.util.HashMap;

/**
 * 作者：senon on 2017/12/27 10:34
 * 邮箱：a1083911695@163.com
 */
public class LoginPresenter extends LoginC.Presenter {

    private LoginM model;
    private Context context;

    public LoginPresenter(Context context) {
        this.model = new LoginM();
        this.context = context;
    }


    @Override
    public void login(String username,String  pas, boolean isDialog, boolean cancelable) {
        model.getLogin(context,username,pas, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object date) {
                if (getView() != null) {
                    String jsonString=new Gson().toJson(date);
                    getView().loginresult(jsonString);
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
    public void regsin(HashMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getRegsin(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object date) {
                if (getView() != null) {
                    String jsonString=new Gson().toJson(date);
                    getView().regsingresult(jsonString);
                    Log.i("首页","注册  "+jsonString);

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
