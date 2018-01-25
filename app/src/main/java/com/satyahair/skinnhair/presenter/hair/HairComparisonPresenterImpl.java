package com.satyahair.skinnhair.presenter.hair;

import com.satyahair.skinnhair.model.bean.BaseContentData;
import com.satyahair.skinnhair.model.hair.HairComparisonIntractorImpl;
import com.satyahair.skinnhair.model.hair.IHairComparsionIntractor;
import com.satyahair.skinnhair.model.skin.ISkinComparisonIntractor;
import com.satyahair.skinnhair.model.skin.SkinComparisonIntractorImpl;
import com.satyahair.skinnhair.view.hair.pricecompare.IHairComparisonView;
import com.satyahair.skinnhair.view.skin.pricecompare.ISkinComparisonView;

/**
 * Created by Sandeep on 03/05/2017.
 */

public class HairComparisonPresenterImpl implements IHairPriceComparisonPresenter,ISkinComparisonIntractor.OnDataSync {
    private IHairComparisonView mView;

    public HairComparisonPresenterImpl(IHairComparisonView mView) {
        this.mView = mView;
    }

    @Override
    public void onCreate() {
        IHairComparsionIntractor intractor = new HairComparisonIntractorImpl();
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
