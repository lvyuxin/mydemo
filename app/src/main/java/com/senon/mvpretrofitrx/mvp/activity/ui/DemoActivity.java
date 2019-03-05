package com.senon.mvpretrofitrx.mvp.activity.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabWidget;
import android.widget.TextView;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.ApplicationUtil;
import com.senon.mvpretrofitrx.mvp.adapter.Useradapter;
import com.senon.mvpretrofitrx.mvp.base.BaseActivity;
import com.senon.mvpretrofitrx.mvp.base.BasePresenter;
import com.senon.mvpretrofitrx.mvp.base.BaseView;
import com.senon.mvpretrofitrx.mvp.entity.User;
import com.senon.mvpretrofitrx.mvp.entity.UserDao;
import com.senon.mvpretrofitrx.mvp.greeDao.UserDaoUtils;
import com.senon.mvpretrofitrx.mvp.permission.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DemoActivity extends BaseActivity {
    @BindView(R.id.iv_senddynamic)
    ImageView ivSenddynamic;
    User user;
    UserDao dao;
    Useradapter useradapter;
    @BindView(R.id.permision)
    TextView permision;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.delde)
    TextView delde;
    @BindView(R.id.query)
    TextView query;
    @BindView(R.id.update)
    TextView update;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(android.R.id.tabs)
    TabWidget tabs;
    @BindView(R.id.send_title)
    TextView sendTitle;
    @BindView(R.id.rlv_send)
    RelativeLayout rlvSend;
    @BindView(R.id.listview)
    RecyclerView listview;
    Useradapter adapter;
    UserDao userDao;//方式1
    UserDaoUtils userDaoUtils;//方式2
    @BindView(R.id.edit_id)
    EditText editId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo;
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listview.setLayoutManager(layoutManager);
        dao = ApplicationUtil.getApplication().getDaoSession().getUserDao();
        utils = new UserDaoUtils();
        users = utils.selectAll();
//        for (User user2 : users) {
//            Log.i("数据", "---" + user2.toString());
//        }
        adapter = new Useradapter(R.layout.item_film, users);
        listview.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    UserDaoUtils utils;

    @OnClick(R.id.iv_senddynamic)
    public void onViewClicked() {
//

    }

    List<User> users = new ArrayList<>();

    @OnClick({R.id.permision, R.id.add, R.id.delde, R.id.query, R.id.update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.permision:
                if (!requestPermissionss(PermissionUtils.PERMISSIONS_LOCATION)) {
                    return;
                }
                break;
            case R.id.add:
                User user = new User(null, "Google", "111","添加");
                utils.insert(user);
                users.add(user);
                adapter.notifyDataSetChanged();
                Log.i("数据", user.toString());
                break;
            case R.id.delde:
                User user2 = new User();
                user2.setId((long) 1);
                utils.deleteWhere(Long.parseLong(editId.getText().toString()));
                break;
            case R.id.query:
//                User user3 = new User(null,"uuu","ppp","llll");
//                utils.seelctWhrer(editId.getText().toString());
                break;
            case R.id.update:
                break;
        }
    }
}

