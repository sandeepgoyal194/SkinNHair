package com.satyahair.skinnhair.view.hair.blog;

import android.content.Context;
import android.content.Intent;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.BaseDashBoardItem;
import com.satyahair.skinnhair.view.hair.casestudy.ActivityHairCaseStudies;

/**
 * Created by Sandeep on 14/03/2017.
 */

public class DashBlogItem extends BaseDashBoardItem {

    Context mContext;
    public DashBlogItem(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getDrawable() {
        return R.drawable.blog;

    }

    @Override
    public String getText() {
        return mContext.getResources().getString(R.string.blog);
    }

    @Override
    public void onClick() {
        //Toast.makeText(mContext, "Clicked on hair case Studies", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(mContext,ActivityHairBlog.class);
        mContext.startActivity(intent);

    }
}
