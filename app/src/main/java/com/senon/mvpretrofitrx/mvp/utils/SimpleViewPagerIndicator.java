package com.senon.mvpretrofitrx.mvp.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.senon.mvpretrofitrx.R;

public class SimpleViewPagerIndicator extends LinearLayout {
    private static final int COLOR_TEXT_NORMAL = 0xFF000000;
    private static final int COLOR_INDICATOR_COLOR = Color.GREEN;


    private String[] mTitles;
    private View[] mView = new View[3];
    private int mTabCount;
    private int mIndicatorColor = COLOR_INDICATOR_COLOR;
    private float mTranslationX;
    private Paint mPaint = new Paint();
    private int mTabWidth;

    private boolean isBold;
    private boolean isMeetiong;

    private int mWiht = 0;

    public void setBold(boolean bold) {
        isBold = bold;
    }

    public SimpleViewPagerIndicator(Context context) {
        this(context, null);
    }

    public SimpleViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(getResources().getColor(R.color.color_2a62dd));
        mPaint.setStrokeWidth(10.0F);
        isBold = false;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mTabCount == 0) {
            mTabWidth = 0;
            return;
        }
        mWiht = w;
        mTabWidth = w / mTabCount;

    }

    public void setTitles(String[] titles) {
        mTitles = titles;
        mTabCount = titles.length;
        generateTitleView();
    }

    public void setTitlesMeetingLiveDetail(String[] titles, boolean meeting) {
        isMeetiong = meeting;
        mTitles = titles;
        mTabCount = titles.length;
        generateTitleMeetingLiveDes();
    }

    public void setIndicatorColor(int indicatorColor) {
        this.mIndicatorColor = indicatorColor;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        canvas.translate(mTranslationX, getHeight() - 1);
        if (mWiht > 0) {
            mTabWidth = mWiht / mTabCount;
        }
        if (isMeetiong) {
            if (mTabCount == 3) {
                canvas.drawLine((mTabWidth - AppUtils.dip2px(getContext(), 90)), 0, AppUtils.dip2px(getContext(), 90), 0, mPaint);
            } else if (mTabCount == 2) {
                canvas.drawLine((mTabWidth - AppUtils.dip2px(getContext(), 115)), 0, AppUtils.dip2px(getContext(), 115), 0, mPaint);
            }

        } else {
            canvas.drawLine((mTabWidth - AppUtils.dip2px(getContext(), 110)), 0, AppUtils.dip2px(getContext(), 110), 0, mPaint);

        }
        canvas.restore();
    }

    public void scroll(int position, float offset) {
        /**
         * <pre>
         *  0-1:position=0 ;1-0:postion=0;
         * </pre>
         */
        mTranslationX = getWidth() / mTabCount * (position + offset);
        invalidate();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    private void generateTitleView() {
        if (getChildCount() > 0)
            this.removeAllViews();
        int count = mTitles.length;

        setWeightSum(count);
        for (int i = 0; i < count; i++) {
            TextView tv = new TextView(getContext());
            LayoutParams lp = new LayoutParams(0,
                    LayoutParams.MATCH_PARENT);
            lp.weight = 1;
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(COLOR_TEXT_NORMAL);
            tv.setText(mTitles[i]);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            TextPaint tp = tv.getPaint();
            tp.setFakeBoldText(isBold);
            tv.setLayoutParams(lp);
            tv.setTag(i);

            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mChangeIndicatorCallback != null) {
                        mChangeIndicatorCallback.changeWithCurrentIndex((int) (v.getTag()));
                    }
                }
            });
            addView(tv);
            if (i == 0) {
                tv.setTextColor(getResources().getColor(R.color.color_2a62dd));
            } else {
                tv.setTextColor(getResources().getColor(R.color.color_535353));
            }
        }
    }

    private void generateTitleMeetingLiveDes() {
        if (getChildCount() > 0)
            this.removeAllViews();
        int count = mTitles.length;
        setWeightSum(count);
        TextView tv;
        for (int i = 0; i < count; i++) {
            tv = new TextView(getContext());
            mView[i] = tv;
            LayoutParams lp = new LayoutParams(0,
                    LayoutParams.MATCH_PARENT);
            lp.weight = 1;
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(COLOR_TEXT_NORMAL);
            tv.setText(mTitles[i]);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            TextPaint tp = tv.getPaint();
            tp.setFakeBoldText(true);
            tv.setLayoutParams(lp);
            tv.setTag(i);
            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mChangeIndicatorCallback != null) {
                        mChangeIndicatorCallback.changeWithCurrentIndex((int) (v.getTag()));
                    }
                }
            });

            addView(tv);
            if (i == 0) {
                tv.setTextColor(getResources().getColor(R.color.color_2a62dd));
            } else {
                tv.setTextColor(getResources().getColor(R.color.color_535353));
            }
        }
    }

    public void setLeftTextSelected() {

        ((TextView) getChildAt(0)).setTextColor(getResources().getColor(R.color.color_2a62dd));
        ((TextView) getChildAt(1)).setTextColor(getResources().getColor(R.color.color_535353));
    }


    public void setRightTextSelected() {

        ((TextView) getChildAt(1)).setTextColor(getResources().getColor(R.color.color_2a62dd));
        ((TextView) getChildAt(0)).setTextColor(getResources().getColor(R.color.color_535353));
    }

    public interface ChangeIndicatorCallback {
        public void changeWithCurrentIndex(int index);
    }

    private ChangeIndicatorCallback mChangeIndicatorCallback;

    public void setaChangeIndicatorCallback(ChangeIndicatorCallback aChangeIndicatorCallback) {
        this.mChangeIndicatorCallback = aChangeIndicatorCallback;
    }

    public void setLeftTextSelected2() {
        ((TextView) getChildAt(0)).setTextColor(getResources().getColor(R.color.color_2a62dd));
        ((TextView) getChildAt(1)).setTextColor(getResources().getColor(R.color.color_535353));
        ((TextView) getChildAt(2)).setTextColor(getResources().getColor(R.color.color_535353));
    }


    public void setRightTextSelected2() {
        ((TextView) getChildAt(1)).setTextColor(getResources().getColor(R.color.color_535353));
        ((TextView) getChildAt(0)).setTextColor(getResources().getColor(R.color.color_535353));
        ((TextView) getChildAt(2)).setTextColor(getResources().getColor(R.color.color_2a62dd));
    }

    public void setCenterTextSelected2() {
        ((TextView) getChildAt(0)).setTextColor(getResources().getColor(R.color.color_535353));
        ((TextView) getChildAt(1)).setTextColor(getResources().getColor(R.color.color_2a62dd));
        ((TextView) getChildAt(2)).setTextColor(getResources().getColor(R.color.color_535353));
    }

    public void setChildTextSelected(int selectIndex) {
        for (int i = 0; i < mTabCount; i++) {
            if (i == selectIndex) {
                ((TextView) getChildAt(i)).setTextColor(getResources().getColor(R.color.color_2a62dd));
            } else {
                ((TextView) getChildAt(i)).setTextColor(getResources().getColor(R.color.color_535353));
            }
        }
    }
}
