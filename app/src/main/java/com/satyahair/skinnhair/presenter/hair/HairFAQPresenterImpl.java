package com.satyahair.skinnhair.presenter.hair;

import com.satyahair.skinnhair.model.bean.FAQ;
import com.satyahair.skinnhair.model.hair.HairFAQIntractorImpl;
import com.satyahair.skinnhair.model.hair.IHairFAQIntractor;
import com.satyahair.skinnhair.view.hair.faq.IHairFAQView;

import java.util.List;

/**
 * Created by Sandeep on 25/12/2016.
 */

public class HairFAQPresenterImpl implements IHairFAQIntractor.OnHairFAQLoaded,IHairFAQPresenter {
    IHairFAQView mView;

    public HairFAQPresenterImpl(IHairFAQView mView) {
        this.mView = mView;
    }

    @Override
    public void setHairFAQ(List<FAQ> faqs) {
        mView.setHairFAQ(faqs);
    }

    @Override
    public void getHairFAQ() {
        IHairFAQIntractor intractor = new HairFAQIntractorImpl();
        intractor.getHairFAQ(this);
    }
}
