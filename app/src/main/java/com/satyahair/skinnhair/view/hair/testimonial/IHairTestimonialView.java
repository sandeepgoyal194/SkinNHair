package com.satyahair.skinnhair.view.hair.testimonial;

import com.satyahair.skinnhair.model.bean.HairTestimonial;

import java.util.List;

/**
 * Created by Sandeep on 27/12/2016.
 */

public interface IHairTestimonialView {
    public void setHairTestimonials(List<HairTestimonial> testimonials);
    public void loadingStart();
    public void loadingFinished();
}
