package com.satyahair.skinnhair.view.skin.pricecompare;

import android.content.Context;
import android.content.Intent;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.BaseDashBoardItem;

/**
 * Created by Sandeep on 03/05/2017.
 */

public class DashPriceComparisonItem extends BaseDashBoardItem {

    Context mContext;

    public DashPriceComparisonItem(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getDrawable() {
        return R.drawable.price_compare;
    }

    @Override
    public String getText() {
        return mContext.getResources().getString(R.string.price_comparison);
    }

    @Override
    public void onClick() {
        Intent intent = new Intent();
        intent.setClass(mContext, ActivitySkinPriceComparison.class);
        mContext.startActivity(intent);
    }
}

