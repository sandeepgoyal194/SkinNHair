package com.satyahair.skinnhair.view.hair.casestudy;

import com.satyahair.skinnhair.model.bean.HairCaseStudies;

import java.util.List;

/**
 * Created by Sandeep on 14/01/2017.
 */

public interface IHairCaseStudyView {
    public void setHairTreatmentList(List<HairCaseStudies> hairTreatmentList);
    public void loadingStart();
    public void loadingComplete();
}
