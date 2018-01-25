package com.satyahair.skinnhair.view.hair.contactus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.BaseDashBoardItem;

/**
 * Created by Sandeep on 18/02/2017.
 */

public class DashContactUsItem extends BaseDashBoardItem {

    Context mContext;
    public DashContactUsItem(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getDrawable() {
        return R.drawable.contact;
    }

    @Override
    public String getText() {
        return mContext.getResources().getString(R.string.contact_us);
    }

    @Override
    public void onClick() {
        Intent intent = new Intent();
        intent.setClass(mContext,ActivityContactUs.class);
        mContext.startActivity(intent);
    }
}
