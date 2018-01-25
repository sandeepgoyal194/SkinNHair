package com.satyahair.skinnhair.view.skin.treatments;

import android.content.Context;
import android.content.Intent;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.BaseDashBoardItem;
import com.satyahair.skinnhair.view.skin.treatments.ActivitySkinTreatments;

/**
 * Created by n.goyal on 12/5/2016.
 */
public class DashTreatmentsItem extends BaseDashBoardItem {

    Context mContext;

    public DashTreatmentsItem(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getDrawable() {
        return R.drawable.treatments;
    }

    @Override
    public String getText() {
        return mContext.getResources().getString(R.string.treatments);
    }

    @Override
    public void onClick() {

        //Toast.makeText(mContext, "Clicked on Hair Treatments", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.setClass(mContext, ActivitySkinTreatments.class);
        mContext.startActivity(intent);

    }
}
