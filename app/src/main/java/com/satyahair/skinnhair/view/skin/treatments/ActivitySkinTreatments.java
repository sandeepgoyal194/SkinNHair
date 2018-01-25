package com.satyahair.skinnhair.view.skin.treatments;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.SkinTreatment;
import com.satyahair.skinnhair.presenter.skin.SkinTreatmentPresetnerImpl;
import com.satyahair.skinnhair.view.hair.treatment.ActivityHairTreatements;

/**
 * Created by Sandeep on 30/12/2016.
 */

public class ActivitySkinTreatments extends ListActivity implements ISkinTreatmentLoadView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Treatments");
        String[] treatmentList = {"Skin Care", "Cosmetic Surgery", "Hair Care",  "Pre Bridal Treatments", "Treatment For Common Diseases"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, treatmentList);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                if (position == 0) {
                    i.setClass(ActivitySkinTreatments.this, ActivitySkinCare.class);
                } else if (position == 1) {
                    i.setClass(ActivitySkinTreatments.this, ActivitySkinCosmeticSurgery.class);
                } else if (position == 2) {
                    i.setClass(ActivitySkinTreatments.this, ActivityHairCare.class);
                } else if (position == 4) {
                    new SkinTreatmentPresetnerImpl(ActivitySkinTreatments.this).getCommonDisease();
                    return;
                } else if (position == 3) {
                    new SkinTreatmentPresetnerImpl(ActivitySkinTreatments.this).getPreBridalTreatment();
                    return;
                }
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void setSkinTreatmentList(SkinTreatment skinTreatment) {
        Intent i = new Intent(this, SkinTreatmentDetail.class);
        i.putExtra("treatment",skinTreatment);
        startActivity(i);
        finish();
    }
    private ProgressDialog mProgressDialog;
    @Override
    public void loadingStart() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, R.style.Theme_MyDialog);
            mProgressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setCancelable(false);
        }
        mProgressDialog.show();
    }

    @Override
    public void loadingComplete() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = null;
    }
}
