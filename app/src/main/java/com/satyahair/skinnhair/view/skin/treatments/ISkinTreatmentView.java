package com.satyahair.skinnhair.view.skin.treatments;

import com.satyahair.skinnhair.model.bean.SkinTreatment;

import java.util.List;

/**
 * Created by Sandeep on 01/01/2017.
 */

public interface ISkinTreatmentView {
    public void setSkinTreatmentList(List<SkinTreatment> skinTreatmentList);
    public void loadingStart();
    public void loadingComplete();
}
