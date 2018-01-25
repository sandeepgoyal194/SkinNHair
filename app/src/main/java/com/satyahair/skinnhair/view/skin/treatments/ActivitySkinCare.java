package com.satyahair.skinnhair.view.skin.treatments;


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
import com.satyahair.skinnhair.SkinNHair;
import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.model.bean.HairTreatment;
import com.satyahair.skinnhair.model.bean.SkinTreatment;
import com.satyahair.skinnhair.presenter.hair.HairTreatmentListPresenterImpl;
import com.satyahair.skinnhair.presenter.hair.IHairTreatmentPresenter;
import com.satyahair.skinnhair.presenter.skin.ISkinCarePresenter;
import com.satyahair.skinnhair.presenter.skin.SkinCarePresenterImpl;
import com.satyahair.skinnhair.presenter.skin.SkinTreatmentPresetnerImpl;
import com.satyahair.skinnhair.view.HairNSkinBaseListView;
import com.satyahair.skinnhair.view.ViewHolder;
import com.satyahair.skinnhair.view.hair.treatment.ActivityHairTreatements;
import com.satyahair.skinnhair.view.hair.treatment.ActivityHairTreatmentDetail;
import com.satyahair.skinnhair.view.skin.treatments.SkinCareTreatementBaseFragment;

import java.util.List;

/**
 * Created by Sandeep on 01/01/2017.



 */

public class ActivitySkinCare extends HairNSkinBaseListView<ActivitySkinCare.Treatments> implements ISkinCareView {
    ISkinCarePresenter mPresenter;
    static int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = 0;
        setTitle("Skin Care");
    }
    @Override
    protected List<BaseBean> getData() {
        mPresenter = new SkinCarePresenterImpl(this);
        mPresenter.getSkinCareTreatmentList();
        return null;
    }

    @Override
    protected ActivitySkinCare.Treatments onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hair_case_treatment_item, parent, false);
        return new ActivitySkinCare.Treatments(view);
    }




    public class Treatments extends ViewHolder<SkinTreatment> {

        TextView mHairTreatmentView;
        TextView countertext;
        SkinTreatment treatment;
        View divider;
        public Treatments(View itemView) {
            super(itemView);
            mHairTreatmentView = (TextView) itemView.findViewById(R.id.treatment_titile);
            countertext = (TextView) itemView.findViewById(R.id.treatment_counter);
            divider = itemView.findViewById(R.id.divider_color);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.getSkinCareTreatmentContent(treatment);
                }
            });
        }

        @Override
        public void setContent(SkinTreatment object) {
            treatment = object;
            if(object.getCounter() == 0) {
                object.setCounter(++counter);
            }
            String title = object.getTitle();
            countertext.setVisibility(View.VISIBLE);
            /*String divide[] = title.split("!");
            if(!divide[0].isEmpty()) {
                itemView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.heading_background));
                divider.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.divider_color));
                mHairTreatmentView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                mHairTreatmentView.setTypeface(null, Typeface.BOLD);
            }*/
            mHairTreatmentView.setText(title);
            countertext.setText(object.getCounter()+"");
        }


    }


    @Override
    public void setSkinTreatmentTitleList(List<SkinTreatment> hairTreatments) {
        updateData(hairTreatments);
    }

    @Override
    public void setSkinContent(SkinTreatment treatment) {
        Intent i = new Intent(this,SkinTreatmentDetail.class);
        i.putExtra("treatment",treatment);
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


}
