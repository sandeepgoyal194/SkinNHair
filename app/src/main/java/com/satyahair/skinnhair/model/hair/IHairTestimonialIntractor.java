package com.satyahair.skinnhair.model.hair;

import com.satyahair.skinnhair.model.bean.HairTestimonial;

import java.util.List;

/**
 * Created by Sandeep on 27/12/2016.
 */

public interface IHairTestimonialIntractor {
    public void getTestimonials(OnTestimonialLoaded listener);
    public interface OnTestimonialLoaded {
        public void setTestimonials(List<HairTestimonial> testimonials);
    }
}
