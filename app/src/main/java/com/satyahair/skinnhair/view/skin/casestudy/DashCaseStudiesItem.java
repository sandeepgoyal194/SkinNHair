package com.satyahair.skinnhair.view.skin.casestudy;

import android.content.Context;
import android.content.Intent;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.BaseDashBoardItem;
import com.satyahair.skinnhair.view.skin.casestudy.ActivitySkinCaseStudies;

/**
 * Created by n.goyal on 12/1/2016.
 */
public class DashCaseStudiesItem extends BaseDashBoardItem {

    Context mContext;

    public DashCaseStudiesItem(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getDrawable() {
        return R.drawable.case_study;

    }

    @Override
    public String getText() {
        return mContext.getResources().getString(R.string.casestudies);
    }

    @Override
    public void onClick() {
        //Toast.makeText(mContext, "Clicked on hair case Studies", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(mContext, ActivitySkinCaseStudies.class);
        mContext.startActivity(intent);

    }
}
