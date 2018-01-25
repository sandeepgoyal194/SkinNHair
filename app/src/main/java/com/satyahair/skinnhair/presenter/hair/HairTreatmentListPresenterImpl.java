package com.satyahair.skinnhair.presenter.hair;

import com.satyahair.skinnhair.model.bean.HairTreatment;
import com.satyahair.skinnhair.model.hair.HairTreatmentIntractorImpl;
import com.satyahair.skinnhair.model.hair.IHairTreatmentIntractor;
import com.satyahair.skinnhair.view.hair.treatment.IHairTreatmentView;

import java.util.List;

/**
 * Created by Sandeep on 27/01/2017.
 */

public class HairTreatmentListPresenterImpl implements IHairTreatmentPresenter,IHairTreatmentIntractor.onHairTreatmentListLoaded {
    IHairTreatmentView mView;

    public HairTreatmentListPresenterImpl(IHairTreatmentView mView) {
        this.mView = mView;
    }

    @Override
    public void getHairTreatmentTitleList() {
        IHairTreatmentIntractor intractor = new HairTreatmentIntractorImpl();
        intractor.getHairTreatmentTitleList(this);
    }

    @Override
    public void getHairTreatmentContent(HairTreatment treatment) {
        IHairTreatmentIntractor intractor = new HairTreatmentIntractorImpl();
        mView.loadingStart();
        intractor.getHairTreamentContent(treatment,this);
    }

    @Override
    public void setHairTreatmentTitleList(List<HairTreatment> hairTreatments) {
        mView.setHairTreatmentTitleList(hairTreatments);
    }

    @Override
    public void setHairContent(HairTreatment treatment) {
        mView.loadingComplete();
        mView.setHairContent(treatment);
    }

    @Override
    public void setHairContentFailed() {
        mView.loadingComplete();
    }
}
