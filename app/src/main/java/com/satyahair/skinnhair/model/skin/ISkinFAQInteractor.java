package com.satyahair.skinnhair.model.skin;

import com.satyahair.skinnhair.model.bean.FAQ;

import java.util.List;

/**
 * Created by Sandeep on 04/01/2017.
 */

public interface ISkinFAQInteractor {
    public void getSkinFAQ(ISkinFAQInteractor.OnSkinFAQLoaded listener);
    public interface OnSkinFAQLoaded {
        public void setSkinFAQ(List<FAQ> faqs);
    }
}
