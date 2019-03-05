package com.senon.mvpretrofitrx.mvp.activity.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.adapter.Videoadapter;
import com.senon.mvpretrofitrx.mvp.base.BaseFragment;
import com.senon.mvpretrofitrx.mvp.base.BaseResponse;
import com.senon.mvpretrofitrx.mvp.bean.itemNews;
import com.senon.mvpretrofitrx.mvp.bean.videoItem;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_TwoC;
import com.senon.mvpretrofitrx.mvp.presenter.FragmentTwoPresenter;
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

public class FoodFragment extends BaseFragment<Fragment_TwoC.View,
        Fragment_TwoC.Presenter> implements Fragment_TwoC.View {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    Unbinder unbinder;
//    private List<TodayNews.DataEntity> listBean = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.frag_new;
    }

    @Override
    public Fragment_TwoC.Presenter createPresenter() {
        return new FragmentTwoPresenter(mContext);
    }

    @Override
    public Fragment_TwoC.View createView() {
        return this;
    }

    Videoadapter adapter;

    @Override
    public void init() {
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Videoadapter(R.layout.item_wx, listBean);
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setDuration(2000);
//        给RecyclerView设置适配器
        recyclerView.setAdapter(animationAdapter);
//        给RecyclerView设置适配器
        recyclerView.setAdapter(adapter);
        map.clear();

        map.put("pageToken", page + "");
        map.put("kw", "演唱会");
        map.put("apikey", "wZDZBjbnz7P7CPHhH3OOIxRM2nAMzf4mzJVH9kLMdNZS5dWrByRCZND1ZRfT6p4T");
//        getPresenter().getTodayVideo(map, true, false);
        Log.i(tag, "000000-----");
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

    String tag = "今日头条";
    HashMap<String, String> map = new HashMap<>();
    private List<videoItem > listBean = new ArrayList<>();
    @Override
    public void result(BaseResponse<List<itemNews>> data, boolean hasNext) {
        Log.i(tag, "视频  " + data.getData());
    }

    @Override
    public void videoResult(BaseResponse<List<videoItem>> data, boolean hasNext) {
        if (page == 1) {
            mRefreshLayout.finishRefresh(true);
            listBean.clear();
            if (data.getData().size() == 0) {
                adapter.setEmptyView(getActivity().getLayoutInflater().inflate(R.layout.layout_no_data, null));
            }
        } else {
            if (data.getData().size() == 0) {
                page = page - 1;
            }
            mRefreshLayout.finishLoadMore();
        }
        listBean.addAll(data.getData());
        adapter.replaceData(listBean);
    }

    @Override
    public void failed(String msg) {

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
                map.put("pageToken", page + "");
                map.put("kw", "nba");
                map.put("apikey", "wZDZBjbnz7P7CPHhH3OOIxRM2nAMzf4mzJVH9kLMdNZS5dWrByRCZND1ZRfT6p4T");
                getPresenter().getTodayNews(map, false, false);
//                getPresenter().getWX(map, false, false);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                map.clear();
                map.put("pageToken", page + "");
                map.put("kw", "nba");
                map.put("apikey", "wZDZBjbnz7P7CPHhH3OOIxRM2nAMzf4mzJVH9kLMdNZS5dWrByRCZND1ZRfT6p4T");
                getPresenter().getTodayNews(map, false, false);
//                getPresenter().getWX(map, false, false);
            }
        });
    }

}
