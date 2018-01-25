package com.satyahair.skinnhair.model.hair;

import com.satyahair.skinnhair.model.bean.FAQ;

import java.util.List;

/**
 * Created by Sandeep on 25/12/2016.
 */

public interface IHairFAQIntractor {
    public void getHairFAQ(OnHairFAQLoaded listener);
    public interface OnHairFAQLoaded {
        public void setHairFAQ(List<FAQ> faqs);
    }
}
