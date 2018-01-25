package com.satyahair.skinnhair.presenter.skin;

import com.satyahair.skinnhair.model.bean.SkinGallery;

/**
 * Created by Sandeep on 08/01/2017.
 */

public interface ISkinGalleryPresenter {
    void getSkinCaseStudyHeaders();
    void getSkinCaseStudyContent(SkinGallery skinGallery);
}
