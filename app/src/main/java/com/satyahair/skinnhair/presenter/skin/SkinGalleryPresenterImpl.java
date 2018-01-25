package com.satyahair.skinnhair.presenter.skin;

import com.satyahair.skinnhair.model.bean.SkinGallery;
import com.satyahair.skinnhair.model.skin.ISkinGalleryIntractor;
import com.satyahair.skinnhair.model.skin.SkinGalleryIntractorImpl;
import com.satyahair.skinnhair.view.skin.casestudy.ISkinGalleryView;

import java.util.List;

/**
 * Created by Sandeep on 08/01/2017.
 */

public class SkinGalleryPresenterImpl implements ISkinGalleryPresenter,ISkinGalleryIntractor.OnSkinGalleryLoaded {
    ISkinGalleryView mView;

    public SkinGalleryPresenterImpl(ISkinGalleryView mView) {
        this.mView = mView;
    }




    @Override
    public void setSkinGalleryContent(SkinGallery skinGallery) {
        mView.loadingEnd();
        mView.setGalleryContent(skinGallery);
    }

    @Override
    public void setSkinCaseStudyHeaders(List<SkinGallery> skinGallery) {
        mView.setGalleryHeaders(skinGallery);
    }

    @Override
    public void getSkinCaseStudyHeaders() {
        ISkinGalleryIntractor intractor = new SkinGalleryIntractorImpl();
        intractor.getSkinCaseStudiesHeader(this);

    }

    @Override
    public void getSkinCaseStudyContent(SkinGallery skinGallery) {
        mView.loadingStart();
        ISkinGalleryIntractor intractor = new SkinGalleryIntractorImpl();
        intractor.getSkinGalleryContent(skinGallery,this);
    }
}
