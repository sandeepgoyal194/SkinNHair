package com.satyahair.skinnhair.view.hair.treatment;

import com.satyahair.skinnhair.model.bean.HairTreatment;

import java.util.List;

/**
 * Created by Sandeep on 27/01/2017.
 */

public interface IHairTreatmentView {
    public void setHairTreatmentTitleList(List<HairTreatment> hairTreatments);
    public void setHairContent(HairTreatment treatment);
    public void loadingStart();
    public void loadingComplete();
}
