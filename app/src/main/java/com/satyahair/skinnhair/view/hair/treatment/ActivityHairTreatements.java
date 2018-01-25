package com.satyahair.skinnhair.view.hair.treatment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.model.bean.HairCaseStudies;
import com.satyahair.skinnhair.model.bean.HairTreatment;
import com.satyahair.skinnhair.presenter.hair.HairCaseStudyPresenterImpl;
import com.satyahair.skinnhair.presenter.hair.HairTreatmentListPresenterImpl;
import com.satyahair.skinnhair.presenter.hair.IHairCaseStudyPresenter;
import com.satyahair.skinnhair.presenter.hair.IHairTreatmentPresenter;
import com.satyahair.skinnhair.view.HairNSkinBaseListView;
import com.satyahair.skinnhair.view.ViewHolder;
import com.satyahair.skinnhair.view.hair.casestudy.IHairCaseStudyView;

import java.util.List;

/**
 * Created by Sandeep on 20/12/2016.
 */

public class ActivityHairTreatements extends HairNSkinBaseListView<ActivityHairTreatements.Treatments> implements IHairTreatmentView {

    IHairTreatmentPresenter mPresenter;
    static int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = 0;
        setTitle("Hair Treatments");
    }
    @Override
    protected List<BaseBean> getData() {
        mPresenter = new HairTreatmentListPresenterImpl(this);
        mPresenter.getHairTreatmentTitleList();
        return null;
    }

    @Override
    protected Treatments onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hair_case_treatment_item, parent, false);
        return new ActivityHairTreatements.Treatments(view);
    }

    @Override
    public void setHairTreatmentTitleList(List<HairTreatment> hairTreatments) {
        updateData(hairTreatments);
    }

    @Override
    public void setHairContent(HairTreatment treatment) {
        Intent i = new Intent(ActivityHairTreatements.this,ActivityHairTreatmentDetail.class);
        i.putExtra("hair_treatment",treatment);
        startActivity(i);
    }


    @Override
    public void loadingStart() {
        showProgressBar();
    }

    @Override
    public void loadingComplete() {
        hideProgressBar();
    }

    public class Treatments extends ViewHolder<HairTreatment> {

        TextView mHairTreatmentView;
        TextView countertext;
        HairTreatment treatment;
        View divider;
        public Treatments(View itemView) {
            super(itemView);
            mHairTreatmentView = (TextView) itemView.findViewById(R.id.treatment_titile);
            countertext = (TextView) itemView.findViewById(R.id.treatment_counter);
            divider = itemView.findViewById(R.id.divider_color);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.getHairTreatmentContent(treatment);
                }
            });
        }

        @Override
        public void setContent(HairTreatment object) {
            treatment = object;
            if(object.getCounter() == 0) {
                object.setCounter(++counter);
            }
            String title = object.getTitle();
            String divide[] = title.split("!");
            if(!divide[0].isEmpty()) {
                itemView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.heading_background));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.divider_color));
                mHairTreatmentView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                mHairTreatmentView.setTypeface(null, Typeface.BOLD);
            }
            mHairTreatmentView.setText(divide[1]);
            countertext.setText(object.getCounter()+"");
        }


    }
}
