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
public interface LoginC {

    interface View extends BaseView {

        void loginresult(String date);
        void regsingresult(String date);
        void setMsg(String msg);
        <T> ObservableTransformer<T, T> bindLifecycle();

    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void login(String  name,String  pas, boolean isDialog, boolean cancelable);
        public abstract void regsin(HashMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}
