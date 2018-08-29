package com.qiyou.qtoolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QToolBar extends Toolbar {

    private static final String TAG = "QToolBar";
    private TextView mTitle;//中间标题
    private Context mContext;

    public QToolBar(Context context) {
        super(context);
        init(context);
    }

    public QToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public QToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mTitle = new TextView(context);
        Toolbar.LayoutParams lp = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        mTitle.setLayoutParams(lp);
        this.addView(mTitle);
        this.setTitle("");
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setToolBarTitle(String title) {
        if (mTitle != null) {
            if (TextUtils.isEmpty(title)) {
                throw new NullPointerException(TAG + " error: title is null");
            }
            mTitle.setText(title);
        }
    }

    /**
     * 设置标题颜色
     *
     * @param colorID
     */
    public void setToolBarTitleColor(int colorID) {
        mTitle.setTextColor(colorID);
    }

    /**
     * 设置标题大小
     *
     * @param size
     */
    public void setToolBarTitleSize(float size) {
        mTitle.setTextSize(size);
    }

    /**
     * 左侧图标
     *
     * @param resID
     */
    public void setToolBarLeftIcon(int resID) {
        this.setNavigationIcon(resID);
    }

    public void setToolBarLeftIcon(Drawable icon) {
        this.setNavigationIcon(icon);
    }

    /**
     * 设置左侧按钮点击事件
     *
     * @param leftIconListener
     */
    public void setToolBarLeftIconListener(OnClickListener leftIconListener) {
        this.setNavigationOnClickListener(leftIconListener);
    }

    /**
     * 更改右侧图标 需实现onCreateOptionsMenu方法
     *
     * @param icon
     */
    public void setToolBarRightIcon(Drawable icon) {
        this.setOverflowIcon(icon);
    }

    /**
     * 更改popopmenu样式
     *
     * @param styleID
     */
    public void setToolBarPopupThem(int styleID) {
        this.setPopupTheme(styleID);
    }

}
