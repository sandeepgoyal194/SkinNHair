package com.satyahair.skinnhair.model.hair;

import com.satyahair.skinnhair.model.bean.HairTreatment;

import java.util.List;

/**
 * Created by Sandeep on 27/01/2017.
 */

public interface IHairTreatmentIntractor {
    public void getHairTreatmentTitleList(IHairTreatmentIntractor.onHairTreatmentListLoaded listLoaded);
    public void getHairTreamentContent(HairTreatment treatment,IHairTreatmentIntractor.onHairTreatmentListLoaded listLoaded);
    public interface onHairTreatmentListLoaded {
        public void setHairTreatmentTitleList(List<HairTreatment> hairTreatments);
        public void setHairContent(HairTreatment treatment);
        public void setHairContentFailed();
    }
}
