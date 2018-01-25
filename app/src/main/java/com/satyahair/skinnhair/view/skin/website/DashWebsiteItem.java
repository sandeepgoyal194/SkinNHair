package com.satyahair.skinnhair.view.skin.website;

import android.content.Context;
import android.content.Intent;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.BaseDashBoardItem;
import com.satyahair.skinnhair.view.skin.website.ActivitySkinWebSite;

/**
 * Created by Sandeep on 18/01/2017.
 */

public class DashWebsiteItem extends BaseDashBoardItem {

    Context mContext;
    public DashWebsiteItem(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getDrawable() {
        return R.drawable.website;
    }

    @Override
    public String getText() {
        return mContext.getResources().getString(R.string.website);
    }

    @Override
    public void onClick() {
        Intent intent = new Intent();
        intent.setClass(mContext,ActivitySkinWebSite.class);
        mContext.startActivity(intent);
    }
}
