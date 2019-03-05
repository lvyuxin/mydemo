package com.senon.mvpretrofitrx.mvp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.activity.fragment.FilemFragment;
import com.senon.mvpretrofitrx.mvp.activity.fragment.FoodFragment;
import com.senon.mvpretrofitrx.mvp.activity.fragment.HomeFragment;
import com.senon.mvpretrofitrx.mvp.activity.fragment.LearnFragment;
import com.senon.mvpretrofitrx.mvp.activity.fragment.MainFragmen;
import com.senon.mvpretrofitrx.mvp.activity.fragment.videoFragmen;
import com.senon.mvpretrofitrx.mvp.base.BaseActivity;
import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseView;
import com.senon.mvpretrofitrx.mvp.utils.AppDate;
import com.senon.mvpretrofitrx.mvp.utils.SpUtil;
import com.zhihu.matisse.Matisse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class mainActivity extends BaseActivity {
    @BindView(R.id.fragment)
    FrameLayout fragment;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.rv_home)
    LinearLayout rvHome;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.rv_mine)
    LinearLayout rvMine;
    @BindView(R.id.btn_home)
    ImageView btnHome;
    @BindView(R.id.btn_mine)
    ImageView btnMine;
    @BindView(R.id.rl_bottombar)
    LinearLayout rlBottombar;
    @BindView(R.id.btn_video)
    ImageView btnVideo;
    @BindView(R.id.tv_video)
    TextView tvVideo;
    @BindView(R.id.rv_video)
    LinearLayout rvVideo;
    @BindView(R.id.btn_food)
    ImageView btnFood;
    @BindView(R.id.tv_food)
    TextView tvFood;
    @BindView(R.id.rv_food)
    LinearLayout rvFood;
    private ArrayList<Fragment> fragments;
    private FragmentManager supportFragmentManager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main2;
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
        String name = SpUtil.getString(this, AppDate.userName, "");
        if (TextUtils.isEmpty(name)) {
            startActivity(new Intent(this, LoginActivity.class));
        }
        initFragments();
        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add(R.id.fragment, fragments.get(0)).commit();
        tvHome.setTextColor(getResources().getColor(R.color.read2));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rv_home, R.id.rv_mine, R.id.rv_video,R.id.rv_food})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rv_video:
                tvVideo.setTextColor(getResources().getColor(R.color.read2));
                btnVideo.setImageResource(R.drawable.learn);
                tvFood.setTextColor(getResources().getColor(R.color.back));
                btnFood.setImageResource(R.drawable.food_n);
                tvMine.setTextColor(getResources().getColor(R.color.black));
                tvHome.setTextColor(getResources().getColor(R.color.back));
                btnMine.setImageResource(R.drawable.me_n);
                btnHome.setImageResource(R.mipmap.ic_home_normal);
                supportFragmentManager.beginTransaction().replace(R.id.fragment, fragments.get(1)).commit();
                break;
            case R.id.rv_home:
                tvVideo.setTextColor(getResources().getColor(R.color.back));
                btnVideo.setImageResource(R.drawable.learn_n);
                tvFood.setTextColor(getResources().getColor(R.color.back));
                btnFood.setImageResource(R.drawable.food_n);
                tvMine.setTextColor(getResources().getColor(R.color.black));
                tvHome.setTextColor(getResources().getColor(R.color.read2));
                btnMine.setImageResource(R.drawable.me_n);
                btnHome.setImageResource(R.mipmap.ic_home_selected);
                supportFragmentManager.beginTransaction().replace(R.id.fragment, fragments.get(0)).commit();
                break;
            case R.id.rv_mine:
                tvVideo.setTextColor(getResources().getColor(R.color.back));
                btnVideo.setImageResource(R.drawable.learn_n);
                tvFood.setTextColor(getResources().getColor(R.color.back));
                btnFood.setImageResource(R.drawable.food_n);
                btnMine.setImageResource(R.drawable.me);
                btnHome.setImageResource(R.mipmap.ic_home_normal);
                tvHome.setTextColor(getResources().getColor(R.color.black));
                tvMine.setTextColor(getResources().getColor(R.color.read2));
                supportFragmentManager.beginTransaction().replace(R.id.fragment, fragments.get(3)).commit();
                break;
            case R.id.rv_food:
                tvVideo.setTextColor(getResources().getColor(R.color.back));
                btnVideo.setImageResource(R.drawable.learn_n);
                tvFood.setTextColor(getResources().getColor(R.color.back));
                btnFood.setImageResource(R.drawable.food);

                btnMine.setImageResource(R.drawable.me_n);
                btnHome.setImageResource(R.mipmap.ic_home_normal);
                tvHome.setTextColor(getResources().getColor(R.color.black));
                tvMine.setTextColor(getResources().getColor(R.color.back));
                supportFragmentManager.beginTransaction().replace(R.id.fragment, fragments.get(2)).commit();
                break;
        }
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new LearnFragment());
        fragments.add(new videoFragmen());
        fragments.add(new MainFragmen());

    }

    List<String> mPaths;
    String tag = "我的";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            mPaths = Matisse.obtainPathResult(data);
            Log.i(tag, " 111   " + mPaths.get(0));
        }
    }
}
