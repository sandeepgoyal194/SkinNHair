package com.satyahair.skinnhair.view.skin.faq;

import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.model.bean.FAQ;
import com.satyahair.skinnhair.presenter.skin.ISkinFaqPresenter;
import com.satyahair.skinnhair.presenter.skin.SkinFAQPresenterImpl;
import com.satyahair.skinnhair.view.hair.faq.ActivityHairFAQ;

import java.util.List;

/**
 * Created by Sandeep on 30/12/2016.
 */

public class ActivitySkinFAQ extends ActivityHairFAQ implements ISkinFAQView {
    ISkinFaqPresenter mPresenter = new SkinFAQPresenterImpl(this);
    @Override
    protected List<BaseBean> getData() {
        showProgressBar();
        mPresenter.getSkinFAQ();
        return null;
    }

    @Override
    public void setFAQ(List<FAQ> faqs) {
        hideProgressBar();
        updateData(faqs);
    }
}
