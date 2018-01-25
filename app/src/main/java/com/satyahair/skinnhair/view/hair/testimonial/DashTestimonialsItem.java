package com.satyahair.skinnhair.view.hair.testimonial;

import android.content.Context;
import android.content.Intent;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.BaseDashBoardItem;
import com.satyahair.skinnhair.view.hair.testimonial.ActivityHairTestimonial;

/**
 * Created by n.goyal on 12/5/2016.
 */
public class DashTestimonialsItem extends BaseDashBoardItem {

    Context mContext;
    public DashTestimonialsItem(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getDrawable() {
        return R.drawable.testimonials;
    }

    @Override
    public String getText() {
        return mContext.getResources().getString(R.string.testimonials);
    }

    @Override
    public void onClick() {

        //Toast.makeText(mContext,"Clicked on Testimonials",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.setClass(mContext,ActivityHairTestimonial.class);
        mContext.startActivity(intent);

    }
}
