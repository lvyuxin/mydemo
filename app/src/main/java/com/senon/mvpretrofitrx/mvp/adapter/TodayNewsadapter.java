package com.senon.mvpretrofitrx.mvp.adapter;


import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.bean.TodayNews;
import com.senon.mvpretrofitrx.mvp.bean.itemNews;
import com.senon.mvpretrofitrx.mvp.bean.wx;
import com.senon.mvpretrofitrx.mvp.utils.GlideCircleTransform;

import java.text.SimpleDateFormat;
import java.util.List;

public class TodayNewsadapter extends BaseQuickAdapter<itemNews,BaseViewHolder> {
    SimpleDateFormat dateFormater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public TodayNewsadapter(int layoutResId, List<itemNews> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper,itemNews item) {
        helper.setText(R.id.sour, item.getContent());
        TextView  textView =helper.getView(R.id.title);
        helper.setText(R.id.count, "浏览："+item.getViewCount()+"");
        helper.setText(R.id.time, item.getPublishDateStr());
        textView.setText(item.getTitle());
        Glide.with(mContext)
                .load(item.getCoverUrl())
                .placeholder(R.drawable.me_3)
                .crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into((ImageView) helper.getView(R.id.frist_pic));


    }
}
