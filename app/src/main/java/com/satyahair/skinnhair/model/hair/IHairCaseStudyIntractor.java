package com.satyahair.skinnhair.model.hair;

import com.satyahair.skinnhair.model.bean.HairCaseStudies;

import java.util.List;

/**
 * Created by Sandeep on 13/01/2017.
 */

public interface IHairCaseStudyIntractor {
    public void getHairGallery(IHairCaseStudyIntractor.OnHairGalleryLoaded listener);
    public interface OnHairGalleryLoaded {
        public void setHairGallery(List<HairCaseStudies> hairGallery);
    }
}
