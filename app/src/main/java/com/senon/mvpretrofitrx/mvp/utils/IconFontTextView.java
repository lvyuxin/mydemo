package com.senon.mvpretrofitrx.mvp.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class IconFontTextView extends android.support.v7.widget.AppCompatTextView{
    private Context mContext;

    public IconFontTextView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public IconFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        Typeface iconfont = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        setTypeface(iconfont);
    }
}
