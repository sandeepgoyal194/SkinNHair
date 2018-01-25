package com.satyahair.skinnhair.view.skin.treatments;

import com.satyahair.skinnhair.model.bean.SkinTreatment;

import java.util.List;

/**
 * Created by Sandeep on 26/03/2017.
 */

public interface ISkinTreatmentLoadView {
    public void setSkinTreatmentList(SkinTreatment skinTreatment);
    public void loadingStart();
    public void loadingComplete();
}
