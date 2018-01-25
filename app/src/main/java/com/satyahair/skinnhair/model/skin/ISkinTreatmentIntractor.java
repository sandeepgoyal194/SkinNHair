package com.satyahair.skinnhair.model.skin;

import com.satyahair.skinnhair.model.bean.SkinTreatment;

import java.util.List;

/**
 * Created by Sandeep on 01/01/2017.
 */

public interface ISkinTreatmentIntractor {
    public void getSkinTretmentList(OnSkinTreatmentLoaded listener);

    public void getSkinCometicSurgeryList(OnSkinTreatmentLoaded listener);

    public void getSkinPreBridalTreatment(OnSkinTreatmentload listener);

    public void getSkinCommonDisease(OnSkinTreatmentload listener);

    public interface OnSkinTreatmentLoaded {
        public void onSkinTreatmentLoadec(List<SkinTreatment> skinTreatments);

        public void onSkinCosmeticSurgeryLoaded(List<SkinTreatment> skinTreatments);
        public void onSkinComesticLoadFail();
    }
    public interface OnSkinTreatmentload {
        public void onSkinTreatmentLoaded(SkinTreatment skinTreatments);
        public void onSkinTreatmentLoadFail();
    }
}
