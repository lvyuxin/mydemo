package com.senon.mvpretrofitrx.mvp.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.bean.smalBean;
import com.senon.mvpretrofitrx.mvp.entity.User;

import java.util.List;

public class Useradapter extends BaseQuickAdapter<User,BaseViewHolder> {
    public Useradapter(int layoutResId,  List<User> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper,  User item) {
        TextView  title=helper.getView(R.id.title);
        ImageView  pic=helper.getView(R.id.frist_pic);
        pic.setVisibility(View.GONE);

        helper.setText(R.id.count, "id  ："+item.getId());
        helper.setText(R.id.sour, item.getUserName()+"---"+item.getContent());
        helper.setText(R.id.time, item.getPassword());
    }
}
