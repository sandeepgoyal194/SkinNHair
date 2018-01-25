package com.satyahair.skinnhair.view.skin.treatments;

import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.presenter.skin.SkinTreatmentPresetnerImpl;

import java.util.List;

/**
 * Created by Sandeep on 01/01/2017.
 */

public class ActivitySkinCosmeticSurgery extends SkinCareTreatementBaseFragment {
    @Override
    protected List<BaseBean> getData() {
        setTitle("Cosmetic Surgery");
        presenter = new SkinTreatmentPresetnerImpl(this);
        presenter.getSkinCosmeticSurgeryList();
        return super.getData();
    }

    @Override
    public void loadingStart() {
        showProgressBar();
    }

    @Override
    public void loadingComplete() {
        hideProgressBar();
    }
}
