package com.senon.mvpretrofitrx.mvp.click;

import android.view.View;

import com.chad.library.adapter.base.listener.OnItemClickListener;

public class recyclerClick {
    private OnItemClickListener clickListener;
    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public static interface OnItemClickListener {
        void onClick(View view, int position);
    }
}
