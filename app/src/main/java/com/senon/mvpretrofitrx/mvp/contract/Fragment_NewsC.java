package com.senon.mvpretrofitrx.mvp.contract;

import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseResponse;
import com.senon.mvpretrofitrx.mvp.base.BaseView;
import com.senon.mvpretrofitrx.mvp.bean.NewsSummary;
import com.senon.mvpretrofitrx.mvp.bean.smalBean;
import com.senon.mvpretrofitrx.mvp.bean.wx;
import com.senon.mvpretrofitrx.mvp.entity.Login;
import com.senon.mvpretrofitrx.mvp.entity.loginbean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.ObservableTransformer;

/**
 * 作者：senon on 2017/12/27 10:30
 * 邮箱：a1083911695@163.com
 * LoginContract  V 、P契约类
 */
public interface Fragment_NewsC {

    interface View extends BaseView {

        void result(BaseResponse<List<smalBean>> date,boolean  hasnext);

        void setMsg(String msg);
        <T> ObservableTransformer<T, T> bindLifecycle();

    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getSmalNews(HashMap<String, String> map, boolean isDialog, boolean cancelable);

    }
}
