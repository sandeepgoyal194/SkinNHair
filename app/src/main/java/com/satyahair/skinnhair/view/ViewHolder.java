package com.satyahair.skinnhair.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.satyahair.skinnhair.model.bean.BaseBean;

public abstract class ViewHolder<TT extends BaseBean> extends RecyclerView.ViewHolder {

    public ViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setContent(TT object);



}