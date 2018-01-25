package com.satyahair.skinnhair.view.hair;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.view.BaseDashBoardItem;
import com.satyahair.skinnhair.view.HairNSkinBaseListViewFragment;
import com.satyahair.skinnhair.view.ViewHolder;
import com.satyahair.skinnhair.view.hair.blog.DashBlogItem;
import com.satyahair.skinnhair.view.hair.casestudy.DashCaseStudiesItem;
import com.satyahair.skinnhair.view.hair.contactus.DashContactUsItem;
import com.satyahair.skinnhair.view.hair.faq.DashQuestionaireItem;
import com.satyahair.skinnhair.view.hair.pricecompare.DashPriceComparisonItem;
import com.satyahair.skinnhair.view.hair.testimonial.DashTestimonialsItem;
import com.satyahair.skinnhair.view.hair.treatment.DashTreatmentsItem;
import com.satyahair.skinnhair.view.hair.website.DashWebsiteItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandeep on 21/12/2016.
 */

public class HairDashBoard extends HairNSkinBaseListViewFragment {

    public static Fragment  HairDashBoardInstance() {
        Fragment fragment = new HairDashBoard();
        return fragment;
    }



    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(getActivity(),3);
    }

    @Override
    protected void getData() {
        mToolbar.setVisibility(View.GONE);
        List<BaseBean> optionList = new ArrayList<>();
        optionList.add(new DashCaseStudiesItem(getActivity()));
        optionList.add(new DashTreatmentsItem(getActivity()));
        optionList.add(new DashTestimonialsItem(getActivity()));
        optionList.add(new DashQuestionaireItem(getActivity()));
        optionList.add(new DashPriceComparisonItem(getActivity()));
        optionList.add(new DashWebsiteItem(getActivity()));
        optionList.add(new DashBlogItem(getActivity()));
        optionList.add(new DashContactUsItem(getActivity()));
        updateData(optionList);
    }

    @Override
    protected ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hair_care_layout, parent, false);
        return new DashBoardItemHolder(view);
    }

    public class DashBoardItemHolder extends ViewHolder<BaseDashBoardItem> {
        ImageView optionImage;
        TextView optionText;
        BaseDashBoardItem mItem;

        public DashBoardItemHolder(View itemView) {
            super(itemView);
            optionImage = (ImageView)itemView.findViewById(R.id.optionimage);
            optionText = (TextView)itemView.findViewById(R.id.optiontext);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItem.onClick();
                }
            });
        }

        @Override
        public void setContent(BaseDashBoardItem item) {
            optionImage.setImageResource(item.getDrawable());
            optionText.setText(item.getText());
            mItem = item;
        }
    }
}
