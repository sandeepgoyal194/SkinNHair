package com.satyahair.skinnhair.view.skin.treatments;

import com.satyahair.skinnhair.model.bean.HairTreatment;
import com.satyahair.skinnhair.model.bean.SkinTreatment;

import java.util.List;

/**
 * Created by Sandeep on 27/01/2017.
 */

public interface ISkinCareView {
    public void setSkinTreatmentTitleList(List<SkinTreatment> hairTreatments);
    public void setSkinContent(SkinTreatment treatment);
    public void loadingStart();
    public void loadingComplete();
}
