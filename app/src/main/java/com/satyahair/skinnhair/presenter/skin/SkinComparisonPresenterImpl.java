package com.satyahair.skinnhair.presenter.skin;

import com.satyahair.skinnhair.model.bean.BaseContentData;
import com.satyahair.skinnhair.model.skin.ISkinComparisonIntractor;
import com.satyahair.skinnhair.model.skin.SkinComparisonIntractorImpl;
import com.satyahair.skinnhair.view.skin.pricecompare.ISkinComparisonView;

/**
 * Created by Sandeep on 03/05/2017.
 */

public class SkinComparisonPresenterImpl implements ISkinPriceComparisonPresenter,ISkinComparisonIntractor.OnDataSync {
    private ISkinComparisonView mView;

    public SkinComparisonPresenterImpl(ISkinComparisonView mView) {
        this.mView = mView;
    }

    @Override
    public void onCreate() {
        ISkinComparisonIntractor intractor = new SkinComparisonIntractorImpl();
        mView.showProgressBar();
        intractor.getSkinData(this);
    }


    @Override
    public void onDataSyncSuccess(BaseContentData data) {
        mView.hideProgressBar();
        mView.setContent(data);
    }

    @Override
    public void onDataSyncFail() {
        mView.hideProgressBar();
    }
}
