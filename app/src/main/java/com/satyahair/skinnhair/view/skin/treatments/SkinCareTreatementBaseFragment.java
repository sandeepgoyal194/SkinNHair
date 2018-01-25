package com.satyahair.skinnhair.view.skin.treatments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.model.bean.SkinTreatment;
import com.satyahair.skinnhair.presenter.skin.ISkinTreatmentPresenter;
import com.satyahair.skinnhair.presenter.skin.SkinTreatmentPresetnerImpl;
import com.satyahair.skinnhair.view.HairNSkinBaseListView;
import com.satyahair.skinnhair.view.ViewHolder;

import java.util.List;

/**
 * Created by Sandeep on 01/01/2017.
 */

public abstract class SkinCareTreatementBaseFragment extends HairNSkinBaseListView<SkinCareTreatementBaseFragment.Treatments> implements ISkinTreatmentView {
    ISkinTreatmentPresenter presenter;
    static int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = 0;
    }

    @Override
    protected SkinCareTreatementBaseFragment.Treatments onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hair_case_treatment_item, parent, false);
        return new SkinCareTreatementBaseFragment.Treatments(view);
    }

    @Override
    protected List<BaseBean> getData() {
        presenter = new SkinTreatmentPresetnerImpl(this);
        return mData;
    }

    @Override
    public void setSkinTreatmentList(List<SkinTreatment> skinTreatmentList) {
        updateData(skinTreatmentList);
    }

    public class Treatments extends ViewHolder<SkinTreatment> {

        TextView mSkinTreatmentView;
        SkinTreatment treatment;
        TextView mTreatmentCounter;
        public Treatments(View itemView) {
            super(itemView);
            mSkinTreatmentView = (TextView) itemView.findViewById(R.id.treatment_titile);
            mTreatmentCounter = (TextView) itemView.findViewById(R.id.treatment_counter);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(SkinCareTreatementBaseFragment.this,SkinTreatmentDetail.class);
                    i.putExtra("treatment",treatment);
                    startActivity(i);
                }
            });
        }

        @Override
        public void setContent(SkinTreatment object) {
            if(object.getCounter() == 0) {
                object.setCounter(++counter);
            }
            treatment = object;
            mSkinTreatmentView.setText(object.getTitle());
            mTreatmentCounter.setText(object.getCounter()+"");
        }


    }
}
