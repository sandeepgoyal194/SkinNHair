package com.satyahair.skinnhair.model.skin;

import com.satyahair.skinnhair.model.bean.SkinTreatment;

import java.util.List;

/**
 * Created by Sandeep on 26/03/2017.
 */

public interface ISkinCareIntractor {
    public void getSkinCareTreatmentTitleList(onSkinCareTreatmentListLoaded listLoaded);
    public void getHairCareTreatmentTitleList(onSkinCareTreatmentListLoaded listLoaded);
    public void getSkinCareTreamentContent(SkinTreatment treatment,onSkinCareTreatmentListLoaded listLoaded);
    public interface onSkinCareTreatmentListLoaded {
        public void setSkinCareTreatmentTitleList(List<SkinTreatment> hairTreatments);
        public void setSkinCareContent(SkinTreatment treatment);
        public void setSkinCareContentFailed();
        public void setHairCareTreatmentTitleList(List<SkinTreatment> hairTreatments);
    }

}
