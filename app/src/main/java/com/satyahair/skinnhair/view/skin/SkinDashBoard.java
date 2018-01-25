package com.satyahair.skinnhair.view.skin;

import android.support.v4.app.Fragment;
import android.view.View;

import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.view.hair.HairDashBoard;
import com.satyahair.skinnhair.view.hair.contactus.DashContactUsItem;
import com.satyahair.skinnhair.view.skin.blog.DashBlogItem;
import com.satyahair.skinnhair.view.skin.casestudy.DashCaseStudiesItem;
import com.satyahair.skinnhair.view.skin.faq.DashQuestionaireItem;
import com.satyahair.skinnhair.view.skin.pricecompare.DashPriceComparisonItem;
import com.satyahair.skinnhair.view.skin.treatments.DashTreatmentsItem;
import com.satyahair.skinnhair.view.skin.website.DashWebsiteItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandeep on 30/12/2016.
 */

public class SkinDashBoard extends HairDashBoard {
    public static Fragment SkinDashBoardInstance() {
        Fragment fragment = new SkinDashBoard();
        return fragment;
    }

    @Override
    protected void getData() {
        mToolbar.setVisibility(View.GONE);
        List<BaseBean> optionList = new ArrayList<>();
        optionList.add(new DashCaseStudiesItem(getActivity()));
        optionList.add(new DashTreatmentsItem(getActivity()));
       // optionList.add(new DashTestimonialsItem(getActivity()));
        optionList.add(new DashQuestionaireItem(getActivity()));
        optionList.add(new DashPriceComparisonItem(getActivity()));
        optionList.add(new DashWebsiteItem(getActivity()));
        optionList.add(new DashBlogItem(getActivity()));
        optionList.add(new DashContactUsItem(getActivity()));
        updateData(optionList);

    }
}
