package com.senon.mvpretrofitrx.mvp.contract;

import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseView;

import java.util.HashMap;

import io.reactivex.ObservableTransformer;

/**
 * 作者：senon on 2017/12/27 10:30
 * 邮箱：a1083911695@163.com
 * LoginContract  V 、P契约类
 */
public interface Fragment_learnC {

    interface View extends BaseView {

        void result(String date,
                    boolean hasnext);
        void collect(String date,
                    boolean hasnext);
        void cancelCollect(String date,
                    boolean hasnext);
        void collectList(String date,
                    boolean hasnext);
        void setMsg(String msg);
        <T> ObservableTransformer<T, T> bindLifecycle();

    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getLearn(String  map, boolean isDialog, boolean cancelable);
        public abstract void collect(String  map, boolean isDialog, boolean cancelable);
        public abstract void canaelCollect(String  map, boolean isDialog, boolean cancelable);
        public abstract void canaelCollectList(String  map, boolean isDialog, boolean cancelable);
    }
}
