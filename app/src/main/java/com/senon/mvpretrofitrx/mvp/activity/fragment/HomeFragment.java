package com.senon.mvpretrofitrx.mvp.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.activity.LoginActivity;
import com.senon.mvpretrofitrx.mvp.adapter.FindAdapte;
import com.senon.mvpretrofitrx.mvp.base.BaseFragment;
import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseView;
import com.senon.mvpretrofitrx.mvp.utils.AppDate;
import com.senon.mvpretrofitrx.mvp.utils.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout  tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    Unbinder unbinder;
    private List<Fragment> mFragments;
    private List<String> titleList;
    NewFragment   toutiao,shehui,guonei,guoji,yule;
    String[] titles=null;
    @Override
    public int getLayoutId() {
        return R.layout.frag_home;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init() {
        String name = SpUtil.getString(getActivity(), AppDate.userName, "");
        if (TextUtils.isEmpty(name)) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }
        titles=new String[]{"头条","社会","国内","国际",
        "娱乐"};
        mFragments = new ArrayList<>();
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        FindAdapte findAAdapter = new FindAdapte(getActivity().getSupportFragmentManager(),
//                titellist, mFragments);
//        viewPager.setAdapter(findAAdapter);
        MyAdapter myAdapter=new MyAdapter(getActivity().getSupportFragmentManager(), titles);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
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


    public class MyAdapter extends FragmentPagerAdapter {
        String[] _titles;

        public MyAdapter(FragmentManager fm, String[] titles) {
            super(fm);
            _titles = titles;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return _titles[position];
        }

        @Override
        public int getCount() {
            return _titles == null ? 0 : _titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (toutiao == null) {
                        toutiao = new NewFragment();
                        Bundle arguments = new Bundle();
                        arguments.putInt("type",1);
                        arguments.putString("name","top");
                        toutiao.setArguments(arguments);
                    }
                    return toutiao;
                case 1:
                    if (shehui== null) {
                        shehui= new NewFragment();
                        Bundle arguments = new Bundle();
                        arguments.putInt("type",2);
                        arguments.putString("name","shehui");
                       shehui.setArguments(arguments);
                    }
                    return shehui;
                case 2:
                    if (guonei == null) {
                        guonei = new NewFragment();
                        Bundle arguments = new Bundle();
                        arguments.putInt("type",3);
                        arguments.putString("name","guonei");
                        guonei .setArguments(arguments);
                    }
                    return guonei;
                case 3:
                    if (guoji== null) {
                        guoji= new NewFragment();
                        Bundle arguments = new Bundle();
                        arguments.putInt("type",4);
                        arguments.putString("name","guoji");
                        guoji.setArguments(arguments);
                    }
                    return guoji;
                case 4:
                    if (yule == null) {
                        yule = new NewFragment();
                        Bundle arguments = new Bundle();
                        arguments.putInt("type",4);
                        arguments.putString("name","yule");
                        yule .setArguments(arguments);
                    }
                    return yule;
                default:
                    if (shehui== null) {
                        shehui= new NewFragment();
                        Bundle arguments = new Bundle();
                        arguments.putInt("type",1);
                        arguments.putString("name","shehui");
                        shehui.setArguments(arguments);
                    }
                    return shehui;
            }
        }
    }
}
