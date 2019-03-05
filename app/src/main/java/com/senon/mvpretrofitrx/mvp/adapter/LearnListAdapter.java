package com.senon.mvpretrofitrx.mvp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.activity.ui.WebActivity;
import com.senon.mvpretrofitrx.mvp.api.Api;
import com.senon.mvpretrofitrx.mvp.entity.filemDate;
import com.senon.mvpretrofitrx.mvp.entity.learnDate;
import com.senon.mvpretrofitrx.mvp.progress.ProgressObserver;
import com.senon.mvpretrofitrx.mvp.utils.AppDate;
import com.senon.mvpretrofitrx.mvp.utils.IconFontTextView;
import com.senon.mvpretrofitrx.mvp.utils.SpUtil;


import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Description：
 * Created time：18-6-4 上午9:26
 * author：wisedeve
 * email：wisedeve@163.com
 */
public class LearnListAdapter extends BaseQuickAdapter<learnDate.DataEntity.DatasEntity, BaseViewHolder> {
    private int type;//普通文章列表0 ;收藏列表1(因为收藏列表返回文章数据无collect,同时也并不需要判断)

    public LearnListAdapter(int layoutResId, List<learnDate.DataEntity.DatasEntity> data, int type) {
        super(layoutResId, data);
        this.type = type;
    }

    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
    public static interface OnItemClickListener {
        void onClick(View view, learnDate.DataEntity.DatasEntity  item);
    }
    @Override
    protected void convert(final BaseViewHolder holder, final learnDate.DataEntity.DatasEntity item) {
        holder.setText(R.id.tv_author, item.getAuthor())
                .setText(R.id.tv_time, item.getNiceDate())
                .setText(R.id.tv_title, Html.fromHtml(item.getTitle()))
                .setText(R.id.tv_type, item.getChapterName());
        final IconFontTextView tvCollect = holder.getView(R.id.icon_collect);
        if (!TextUtils.isEmpty(item.getEnvelopePic())) {
            Glide.with(mContext)
                    .load(item.getEnvelopePic())
                    .placeholder(R.drawable.me_3)
                    .crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into((ImageView) holder.getView(R.id.iv_head));
        } else {
            Glide.with(mContext).load(R.drawable.me_3).into((ImageView) holder.getView(R.id.iv_head));
        }

        if (type == 0) {
            //普通文章列表
            if (item.isCollect()) {
                tvCollect.setText(mContext.getResources().getText(R.string.ic_collect_sel));
                tvCollect.setTextColor(mContext.getResources().getColor(R.color.read2));
            } else {
                tvCollect.setText(mContext.getResources().getText(R.string.ic_collect_nor));
                tvCollect.setTextColor(mContext.getResources().getColor(R.color.gray));
            }
        } else if (type == 1) {
            //收藏列表
            tvCollect.setText(mContext.getResources().getText(R.string.ic_collect_sel));
            tvCollect.setTextColor(mContext.getResources().getColor(R.color.read2));
        }
        final TextView textView = holder.getView(R.id.icon_collect);
        holder.getView(R.id.icon_collect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(textView, item);
//                if (!SPUtils.getBoolean(mContext, ServiceApi.IS_LOGIN_KEY,false)) {
//                    T.showShort(mContext,"请先登录");
//                    LoginActivity.startAction(mContext);
//                    return;
//                }
//                if (type == 0) {
//                    //普通文章列表
//                    if (item.isCollect()) {
////                        cancelCollect(item,tvCollect);
//                    }else {
////                        collect(item, tvCollect);
//                    }
//                }else if (type == 1){
//                    //收藏列表
////                    cancelCollect2(item,tvCollect, holder.getAdapterPosition());
//                }
            }
        });
    }


}
