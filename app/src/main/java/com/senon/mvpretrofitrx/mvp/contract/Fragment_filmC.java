package com.senon.mvpretrofitrx.mvp.contract;

import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseResponse;
import com.senon.mvpretrofitrx.mvp.base.BaseView;


import java.util.HashMap;
import java.util.List;

import io.reactivex.ObservableTransformer;

/**
 * 作者：senon on 2017/12/27 10:30
 * 邮箱：a1083911695@163.com
 * LoginContract  V 、P契约类
 */
public interface Fragment_filmC {

    interface View extends BaseView {

        void result(String   date,
                    boolean hasnext);

        void setMsg(String msg);
        <T> ObservableTransformer<T, T> bindLifecycle();

    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getfilmNews(HashMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}
