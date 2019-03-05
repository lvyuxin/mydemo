package com.senon.mvpretrofitrx.mvp.presenter;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senon.mvpretrofitrx.mvp.base.BaseResponse;
import com.senon.mvpretrofitrx.mvp.base.Response;
import com.senon.mvpretrofitrx.mvp.bean.smalBean;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_NewsC;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_filmC;
import com.senon.mvpretrofitrx.mvp.entity.Login;
import com.senon.mvpretrofitrx.mvp.entity.filemDate;
import com.senon.mvpretrofitrx.mvp.entity.itemDate;
import com.senon.mvpretrofitrx.mvp.model.Fragment_filmM;
import com.senon.mvpretrofitrx.mvp.model.Fragment_newsM;
import com.senon.mvpretrofitrx.mvp.progress.ObserverResponseListener;
import com.senon.mvpretrofitrx.mvp.utils.ExceptionHandle;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * 作者：senon on 2017/12/27 10:34
 * 邮箱：a1083911695@163.com
 */
public class FragmentFilmPresenter extends Fragment_filmC.Presenter {

    private Fragment_filmM model;
    private Context context;

    public FragmentFilmPresenter(Context context) {
        this.model = new Fragment_filmM();
        this.context = context;
    }


    @Override
    public void getfilmNews(HashMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getFilm(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object date) {

                if (getView() != null) {
                    String jsonString=new Gson().toJson(date);
                    getView().result(jsonString, false);
                    Log.i("首页","bbbbbbbbbbbbbbb  "+jsonString);
//                    Log.i("微头条","bsize  "+response.getReason());
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
