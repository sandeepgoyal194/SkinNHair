package com.satyahair.skinnhair.presenter.skin;

import com.satyahair.skinnhair.model.bean.FAQ;
import com.satyahair.skinnhair.model.skin.ISkinFAQInteractor;
import com.satyahair.skinnhair.model.skin.SkinFAQIntractorImpl;
import com.satyahair.skinnhair.view.skin.faq.ISkinFAQView;

import java.util.List;

/**
 * Created by Sandeep on 04/01/2017.
 */

public class SkinFAQPresenterImpl implements ISkinFaqPresenter,ISkinFAQInteractor.OnSkinFAQLoaded{
    ISkinFAQView mView;

    public SkinFAQPresenterImpl(ISkinFAQView mView) {
        this.mView = mView;
    }

    @Override
    public void getSkinFAQ() {
        ISkinFAQInteractor faqInteractor = new SkinFAQIntractorImpl();
        faqInteractor.getSkinFAQ(this);
    }

    @Override
    public void setSkinFAQ(List<FAQ> faqs) {
        mView.setFAQ(faqs);
    }
}
