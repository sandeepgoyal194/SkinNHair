package com.satyahair.skinnhair.view;

import android.content.Context;

import com.satyahair.skinnhair.model.bean.BaseBean;

public abstract class BaseDashBoardItem extends BaseBean{
    Context mContext;

    public BaseDashBoardItem(Context context) {
        mContext = context;
    }

    public abstract int getDrawable();

    public abstract String getText();

    public abstract void onClick();
}