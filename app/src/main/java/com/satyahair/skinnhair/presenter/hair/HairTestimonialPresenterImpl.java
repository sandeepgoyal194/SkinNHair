package com.satyahair.skinnhair.presenter.hair;

import com.satyahair.skinnhair.model.bean.HairTestimonial;
import com.satyahair.skinnhair.model.hair.HairTestimonialIntractorImpl;
import com.satyahair.skinnhair.model.hair.IHairTestimonialIntractor;
import com.satyahair.skinnhair.view.hair.testimonial.IHairTestimonialView;

import java.util.List;

/**
 * Created by Sandeep on 27/12/2016.
 */

public class HairTestimonialPresenterImpl implements IHairTestimonialIntractor.OnTestimonialLoaded,IHairTestimonialPresenter{

    IHairTestimonialView mView;

    public HairTestimonialPresenterImpl(IHairTestimonialView mView) {
        this.mView = mView;
    }

    @Override
    public void setTestimonials(List<HairTestimonial> testimonials) {
        mView.loadingFinished();
        mView.setHairTestimonials(testimonials);
    }

    @Override
    public void getHairTestimonial() {
        IHairTestimonialIntractor intractor = new HairTestimonialIntractorImpl();
        mView.loadingStart();
        intractor.getTestimonials(this);
    }
}
