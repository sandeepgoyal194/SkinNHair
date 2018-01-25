package com.satyahair.skinnhair.presenter.skin;

import com.satyahair.skinnhair.model.bean.SkinTreatment;
import com.satyahair.skinnhair.model.skin.ISkinCareIntractor;
import com.satyahair.skinnhair.model.skin.SkinCareIntractorImpl;
import com.satyahair.skinnhair.view.skin.treatments.IHairCareView;
import com.satyahair.skinnhair.view.skin.treatments.ISkinCareView;

import java.util.List;

/**
 * Created by Sandeep on 26/03/2017.
 */

public class SkinCarePresenterImpl implements ISkinCarePresenter, ISkinCareIntractor.onSkinCareTreatmentListLoaded {
    ISkinCareView mView;
    IHairCareView mHairView;

    public SkinCarePresenterImpl(ISkinCareView mView) {
        this.mView = mView;
    }

    public SkinCarePresenterImpl(IHairCareView mHairView) {
        this.mHairView = mHairView;
    }

    @Override
    public void getSkinCareTreatmentList() {
        ISkinCareIntractor intractor = new SkinCareIntractorImpl();
        mView.loadingStart();
        intractor.getSkinCareTreatmentTitleList(this);
    }

    @Override
    public void getSkinCareTreatmentContent(SkinTreatment treatment) {
        ISkinCareIntractor intractor = new SkinCareIntractorImpl();
        mView.loadingStart();
        intractor.getSkinCareTreamentContent(treatment, this);
    }

    @Override
    public void setSkinCareTreatmentTitleList(List<SkinTreatment> skinTreatments) {
        mView.loadingComplete();
        mView.setSkinTreatmentTitleList(skinTreatments);
    }

    @Override
    public void setSkinCareContent(SkinTreatment treatment) {
        if (mView != null) {
            mView.loadingComplete();
            mView.setSkinContent(treatment);
        } else if (mHairView != null) {
            mHairView.loadingComplete();
            mHairView.setHairContent(treatment);
        }
    }

    @Override
    public void setSkinCareContentFailed() {
        mView.loadingComplete();
    }

    @Override
    public void setHairCareTreatmentTitleList(List<SkinTreatment> hairTreatments) {
        mHairView.loadingComplete();
        mHairView.setHairTreatmentTitleList(hairTreatments);
    }

    @Override
    public void getHairCareList() {
        ISkinCareIntractor intractor = new SkinCareIntractorImpl();
        mHairView.loadingStart();
        intractor.getHairCareTreatmentTitleList(this);
    }
}
