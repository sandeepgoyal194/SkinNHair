package com.satyahair.skinnhair.presenter.hair;

import com.satyahair.skinnhair.model.bean.HairTreatment;
import com.satyahair.skinnhair.model.hair.IHairTreatmentIntractor;

/**
 * Created by Sandeep on 27/01/2017.
 */

public interface IHairTreatmentPresenter {
    public void getHairTreatmentTitleList();
    public void getHairTreatmentContent(HairTreatment treatment);
}
