package com.senon.mvpretrofitrx.mvp.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.activity.LoginActivity;
import com.senon.mvpretrofitrx.mvp.activity.ui.WebActivity;
import com.senon.mvpretrofitrx.mvp.adapter.LearnListAdapter;
import com.senon.mvpretrofitrx.mvp.base.BaseFragment;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_learnC;
import com.senon.mvpretrofitrx.mvp.entity.A_collect;
import com.senon.mvpretrofitrx.mvp.entity.learnDate;
import com.senon.mvpretrofitrx.mvp.presenter.Fragment_learnPresenter;
import com.senon.mvpretrofitrx.mvp.utils.AppDate;
import com.senon.mvpretrofitrx.mvp.utils.SpUtil;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.ObservableTransformer;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class LearnFragment extends BaseFragment<Fragment_learnC.View,
        Fragment_learnC.Presenter> implements Fragment_learnC.View {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    Unbinder unbinder;

    @Override
    public int getLayoutId() {
        return R.layout.frag_food;
    }

    @Override
    public Fragment_learnC.Presenter createPresenter() {
        return new Fragment_learnPresenter(mContext);
    }

    @Override
    public Fragment_learnC.View createView() {
        return this;
    }

    LearnListAdapter adapter;
    String userName = SpUtil.getString(getActivity(), AppDate.userName, "");

    @Override
    public void init() {
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new LearnListAdapter(R.layout.item_article, listBean, 0);
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setDuration(2000);
        recyclerView.setAdapter(animationAdapter);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), WebActivity.class)
                        .putExtra("uri", listBean.get(position).getLink())
                        .putExtra("title", listBean.get(position).getTitle()));
            }
        });
        adapter.setClickListener(new LearnListAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, learnDate.DataEntity.DatasEntity item) {
                Log.i("学习", " name  " + userName + "  " + userName.length());
                if (userName.length() == 0) {
                    ToastUtil.showShortToast("请登录");
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    return;
                }
                if (item.isCollect() == false) {
                    map.clear();
                    map.put("originId", item.getId() + "");
                    getPresenter().collect(item.getId() + "", true, false);
                } else {
                    map.clear();
                    map.put("originId", item.getId() + "");
                    getPresenter().canaelCollect(item.getId() + "", true, false);
                }
            }
        });
        map.clear();
        map.put("page", page + "");
        getPresenter().getLearn(page + "", true, false);
        Log.i(tag, "000000-----");
        initRefresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    String tag = "首页";
    HashMap<String, String> map = new HashMap<>();
    private List<learnDate.DataEntity.DatasEntity> listBean = new ArrayList<>();

    @Override
    public void result(String date, boolean hasnext) {
        Log.i(tag, "  uuu  " + date);
        learnDate bean = new Gson().fromJson(date, learnDate.class);
        if (page == 1) {
            mRefreshLayout.finishRefresh(true);
            listBean.clear();
            if (bean.getData().getDatas().size() == 0) {
                adapter.setEmptyView(getActivity().getLayoutInflater().inflate(R.layout.layout_no_data, null));
            }
        } else {
            if (bean.getData().getDatas().size() == 0) {
                page = page - 1;
            }
            mRefreshLayout.finishLoadMore();
        }
        listBean.addAll(bean.getData().getDatas());
        adapter.replaceData(listBean);

    }

    @Override
    public void collect(String date, boolean hasnext) {
        Log.i(tag, "收藏  " + date);
        A_collect bean = new Gson().fromJson(date, A_collect.class);
        ToastUtil.showShortToast(bean.getErrorMsg());
//        if (bean.getErrorCode() == -1001) {
//            startActivity(new Intent(getActivity(), LoginActivity.class));
//        } else {
//            map.clear();
//            map.put("originId", page + "");
//            getPresenter().getLearn(page + "", true, false);
//        }
    }

    @Override
    public void cancelCollect(String date, boolean hasnext) {
        Log.i(tag, "取消收藏  " + date);
    }

    @Override
    public void collectList(String date, boolean hasnext) {

    }

    @Override
    public void setMsg(String msg) {
        ToastUtil.showShortToast(msg);
        page = page - 1;
        ToastUtil.showShortToast(msg);
        mRefreshLayout.finishRefresh(false);
        mRefreshLayout.finishLoadMore(false);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindUntilEvent(FragmentEvent.PAUSE);
    }

    int page = 1;
    int rows = 20;

    private void initRefresh() {
        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                map.clear();
                page++;
                map.clear();
                map.put("page", page + "");
                getPresenter().getLearn(page + "", true, false);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                map.clear();
                map.put("page", page + "");
                getPresenter().getLearn(page + "", true, false);
            }
        });
    }

}
