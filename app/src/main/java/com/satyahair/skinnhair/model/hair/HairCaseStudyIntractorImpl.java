package com.satyahair.skinnhair.model.hair;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.SkinNHair;
import com.satyahair.skinnhair.model.bean.HairCaseStudies;
import com.satyahair.skinnhair.network.GsonFactory;
import com.satyahair.skinnhair.network.IServerResponseListener;
import com.satyahair.skinnhair.network.ServerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sandeep on 14/01/2017.
 */

public class HairCaseStudyIntractorImpl implements IHairCaseStudyIntractor {
    @Override
    public void getHairGallery(final OnHairGalleryLoaded listener) {
        final String mHairTreatmentList[] = SkinNHair.getApplication().getResources().getStringArray(R.array.hair_gallery);
        final List<HairCaseStudies> hairTreatments = new ArrayList<>();
        /*for (int i = 0; i < mHairTreatmentList.length; i++) {*/
        ServerManager.getInstance().requestDataFromServer("http://www.hairtransplantindia.co.in/patient-gallery-case-studies/wp-json/wp/v2/posts/?per_page=100&page=1&_embed", new IServerResponseListener() {
                    @Override
                    public void onResponse(String response) {
                   /* try {
                        JSONObject object = new JSONObject(response);
                        response = object.get("items").toString();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/

                   // REVERSE LIST AS CLIENT NEEDS IT IN REVFERSE ORDER
                        List<HairCaseStudies> treatments = new ArrayList<>();
                        treatments.addAll(Arrays.asList(GsonFactory.getGson().fromJson(response, HairCaseStudies[].class)));
                        for(int i = treatments.size()-1;i>=0;i--) {
                            HairCaseStudies caseStudies = treatments.get(i);
                            if (!hairTreatments.contains(caseStudies)) {
                                hairTreatments.add(caseStudies);
                            }
                        }
                        listener.setHairGallery(hairTreatments);
                    }

                    @Override
                    public void onErrorResponse(int errorType, String response) {

                    }
                }
                , null, IServerResponseListener.REQUEST_GET);
    }
}

