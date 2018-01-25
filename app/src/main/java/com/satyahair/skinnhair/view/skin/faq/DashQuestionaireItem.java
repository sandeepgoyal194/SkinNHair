package com.satyahair.skinnhair.view.skin.faq;

import android.content.Context;
import android.content.Intent;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.BaseDashBoardItem;
import com.satyahair.skinnhair.view.skin.faq.ActivitySkinFAQ;

/**
 * Created by n.goyal on 12/1/2016.
 */
public class DashQuestionaireItem extends BaseDashBoardItem {

    Context mContext;
    public DashQuestionaireItem(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public int getDrawable() {
        return R.drawable.faq;
    }

    @Override
    public String getText() {
        return mContext.getResources().getString(R.string.faq);
    }

    @Override
    public void onClick() {
       // Toast.makeText(mContext, "Clicked on Hair Questionaire", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(mContext,ActivitySkinFAQ.class);
        mContext.startActivity(intent);
    }
}
