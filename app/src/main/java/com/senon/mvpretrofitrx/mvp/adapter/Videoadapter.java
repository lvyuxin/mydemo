package com.senon.mvpretrofitrx.mvp.adapter;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.bean.itemNews;
import com.senon.mvpretrofitrx.mvp.bean.videoItem;

import java.util.List;

public class Videoadapter extends BaseQuickAdapter<videoItem,BaseViewHolder> {
    public Videoadapter(int layoutResId, List<videoItem> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper,videoItem item) {
        helper.setText(R.id.title, item.getTitle());
        helper.setText(R.id.sour, item.getDescription());
        helper.setText(R.id.time, item.getPublishDateStr());
        helper.setText(R.id.count, "浏览："+item.getViewCount()+"");
        Glide.with(mContext)
                .load(item.getCoverUrl())
                .placeholder(R.drawable.me_3)
                .crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into((ImageView) helper.getView(R.id.frist_pic));


    }
}
