package com.senon.mvpretrofitrx.mvp.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.senon.mvpretrofitrx.mvp.base.BaseResponse;
import com.senon.mvpretrofitrx.mvp.bean.TodayNews;
import com.senon.mvpretrofitrx.mvp.bean.itemNews;
import com.senon.mvpretrofitrx.mvp.bean.videoItem;
import com.senon.mvpretrofitrx.mvp.bean.wx;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_NewsC;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_TwoC;
import com.senon.mvpretrofitrx.mvp.entity.Login;
import com.senon.mvpretrofitrx.mvp.model.Fragment_newsM;
import com.senon.mvpretrofitrx.mvp.model.Fragment_twoM;
import com.senon.mvpretrofitrx.mvp.progress.ObserverResponseListener;
import com.senon.mvpretrofitrx.mvp.utils.ExceptionHandle;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * 作者：senon on 2017/12/27 10:34
 * 邮箱：a1083911695@163.com
 */
public class FragmentTwoPresenter extends Fragment_TwoC.Presenter {

    private Fragment_twoM model;
    private Context context;

    public FragmentTwoPresenter(Context context) {
        this.model = new Fragment_twoM();
        this.context = context;
    }


    @Override
    public void getTodayNews(HashMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getTodayNews(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object response) {
                if (getView() != null) {
                    getView().result((BaseResponse<List<itemNews>>) response, false);

                }


            }

            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (getView() != null) {
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

    @Override
    public void getTodayVideo(HashMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getTodayVideo(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object response) {
//                videoItem bean = new Gson().fromJson(response.toString(),  videoItem.class);
//                Log.i("今日头条","视频 "+bean.getCoverUrl());
                if (getView() != null) {
                    getView().videoResult((BaseResponse<List< videoItem>>) response, false);

                }
                Log.i("今日头条", "视频条uuuuuuuuuuu " + response.toString());

            }

            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (getView() != null) {
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

}
