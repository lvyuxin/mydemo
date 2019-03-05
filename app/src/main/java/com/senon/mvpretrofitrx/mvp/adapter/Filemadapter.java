package com.senon.mvpretrofitrx.mvp.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.bean.smalBean;
import com.senon.mvpretrofitrx.mvp.entity.filemDate;
import com.senon.mvpretrofitrx.mvp.entity.itemDate;

import java.util.List;

public class Filemadapter extends BaseQuickAdapter<filemDate.ResultEntity.DataEntity,BaseViewHolder> {
    public Filemadapter(int layoutResId, List<filemDate.ResultEntity.DataEntity> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, filemDate.ResultEntity.DataEntity item) {

        Glide.with(mContext)
                .load(item.getThumbnail_pic_s())
                .placeholder(R.drawable.me_3)
                .crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into((ImageView) helper.getView(R.id.frist_pic));
        helper.setText(R.id.title, item.getAuthor_name());
        helper.setText(R.id.sour, item.getTitle());
        helper.setText(R.id.time, item.getDate());
    }
}
