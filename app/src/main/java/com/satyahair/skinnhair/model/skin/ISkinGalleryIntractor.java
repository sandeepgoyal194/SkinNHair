package com.satyahair.skinnhair.model.skin;

import com.satyahair.skinnhair.model.bean.SkinGallery;

import java.util.List;

/**
 * Created by Sandeep on 08/01/2017.
 */

public interface ISkinGalleryIntractor {
    public void getSkinCaseStudiesHeader(ISkinGalleryIntractor.OnSkinGalleryLoaded lisener);
    public void getSkinGalleryContent(SkinGallery caseStudy,ISkinGalleryIntractor.OnSkinGalleryLoaded listener);
    public interface OnSkinGalleryLoaded {
        public void setSkinGalleryContent(SkinGallery caseStudy);
        public void setSkinCaseStudyHeaders(List<SkinGallery> skinGallery);
    }
}
