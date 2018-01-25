package com.satyahair.skinnhair.presenter.skin;

import com.satyahair.skinnhair.model.bean.SkinTreatment;

/**
 * Created by Sandeep on 26/03/2017.
 */

public interface ISkinCarePresenter {
    public void getSkinCareTreatmentList();

    public void getSkinCareTreatmentContent(SkinTreatment treatment);

    public void getHairCareList();
}
