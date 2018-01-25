package com.satyahair.skinnhair.view.skin.pricecompare;

import com.satyahair.skinnhair.model.bean.BaseContentData;

/**
 * Created by Sandeep on 03/05/2017.
 */

public interface ISkinComparisonView {
    public void showProgressBar();
    public void hideProgressBar();
    public void setContent(BaseContentData data);
}
