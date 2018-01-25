package com.satyahair.skinnhair.presenter.hair;

import com.satyahair.skinnhair.model.bean.HairCaseStudies;
import com.satyahair.skinnhair.model.hair.HairCaseStudyIntractorImpl;
import com.satyahair.skinnhair.model.hair.IHairCaseStudyIntractor;
import com.satyahair.skinnhair.view.hair.casestudy.IHairCaseStudyView;

import java.util.List;

/*
 * Created by Sandeep on 14/01/2017.
 */

public class HairCaseStudyPresenterImpl implements IHairCaseStudyPresenter,IHairCaseStudyIntractor.OnHairGalleryLoaded {
    IHairCaseStudyView mView;

    public HairCaseStudyPresenterImpl(IHairCaseStudyView mView) {
        this.mView = mView;
    }

    @Override
    public void getHairGalleryList() {
        IHairCaseStudyIntractor intractor = new HairCaseStudyIntractorImpl();
        mView.loadingStart();
        intractor.getHairGallery(this);
    }

    @Override
    public void setHairGallery(List<HairCaseStudies> hairGallery) {
        mView.loadingComplete();
        mView.setHairTreatmentList(hairGallery);
    }
}
