package com.senon.mvpretrofitrx.mvp.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.bean.smalBean;
import com.senon.mvpretrofitrx.mvp.bean.wx;

import java.util.List;

public class WXadapter extends BaseQuickAdapter<smalBean,BaseViewHolder> {
    public WXadapter(int layoutResId, List<smalBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, smalBean item) {
        TextView  title=helper.getView(R.id.title);
        ImageView  pic=helper.getView(R.id.frist_pic);
        pic.setVisibility(View.GONE);

        helper.setText(R.id.count, "浏览："+item.getViewCount()+"");
        helper.setText(R.id.sour, item.getContent());
        helper.setText(R.id.time, item.getPublishDateStr());
    }
}
