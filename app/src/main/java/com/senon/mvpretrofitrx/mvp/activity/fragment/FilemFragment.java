package com.senon.mvpretrofitrx.mvp.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.activity.ui.WebActivity;
import com.senon.mvpretrofitrx.mvp.adapter.Filemadapter;
import com.senon.mvpretrofitrx.mvp.base.BaseFragment;
import com.senon.mvpretrofitrx.mvp.contract.Fragment_filmC;
import com.senon.mvpretrofitrx.mvp.entity.filemDate;
import com.senon.mvpretrofitrx.mvp.presenter.FragmentFilmPresenter;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.ObservableTransformer;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class FilemFragment extends BaseFragment
        <Fragment_filmC.View, Fragment_filmC.Presenter> implements Fragment_filmC.View {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    Unbinder unbinder;
    @BindView(R.id.tv_basetitle)
    TextView tvBasetitle;

    @Override
    public int getLayoutId() {
        return R.layout.frag_food;
    }

    @Override
    public Fragment_filmC.Presenter createPresenter() {
        return new FragmentFilmPresenter(mContext);
    }

    @Override
    public Fragment_filmC.View createView() {
        return this;
    }

    Filemadapter adapter;
    HashMap<String, String> map = new HashMap<>();
    List<filemDate.ResultEntity.DataEntity> listBean;

    @Override
    public void init() {
        tvBasetitle.setText("学习");
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new SlideInLeftAnimator());
        adapter = new Filemadapter(R.layout.item_film, listBean);
        //渐变色动画
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setDuration(2000);
        recyclerView.setAdapter(animationAdapter);

        map.clear();
        map.put("page", "1");//当前页数，默认1
//        map.put("key", "9b54906dbd6846ec8eb59b4365bcfa04");//每页返回条数，最大100，默认20
        getPresenter().getfilmNews(map, true, false);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), WebActivity.class)
                        .putExtra("uri", listBean.get(position).getUrl())
                        .putExtra("title", listBean.get(position).getTitle()));
            }
        });
    }


    @Override
    public void result(String date, boolean hasnext) {
        Log.i("微头条", "-vvv---" + date.toString());
        filemDate bean = new Gson().fromJson(date, filemDate.class);
        if (bean.getResult() != null) {
            listBean = bean.getResult().getData();
            adapter.replaceData(listBean);
        } else {
            adapter.setEmptyView(getActivity().getLayoutInflater().inflate(R.layout.layout_no_data, null));
        }

    }

    @Override
    public void setMsg(String msg) {

    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindUntilEvent(FragmentEvent.PAUSE);
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
}
