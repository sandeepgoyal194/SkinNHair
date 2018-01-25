package com.satyahair.skinnhair.model.hair;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.SkinNHair;
import com.satyahair.skinnhair.model.bean.HairTestimonial;
import com.satyahair.skinnhair.model.bean.HairTreatment;
import com.satyahair.skinnhair.network.GsonFactory;
import com.satyahair.skinnhair.network.IServerResponseListener;
import com.satyahair.skinnhair.network.ServerManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sandeep on 27/01/2017.
 */

public class HairTreatmentIntractorImpl implements IHairTreatmentIntractor {
    @Override
    public void getHairTreatmentTitleList(onHairTreatmentListLoaded listLoaded) {
        List<HairTreatment> hairTreatments = new ArrayList<>();
        String[] treatments = SkinNHair.getApplication().getResources().getStringArray(R.array.hair_treatment);
        for(String treatment:treatments) {
            String tret[] = treatment.split("\\?");
            HairTreatment hairTreatment = new HairTreatment();
            hairTreatment.setTitle(tret[0]);
            hairTreatment.setLink(tret[1]);
            hairTreatments.add(hairTreatment);
        }
        listLoaded.setHairTreatmentTitleList(hairTreatments);
    }

    @Override
    public void getHairTreamentContent(HairTreatment treatment, final onHairTreatmentListLoaded listLoaded) {

        ServerManager.getInstance().requestDataFromServer(treatment.getLink(), new IServerResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            response = object.get("items").toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        HairTreatment treatment = GsonFactory.getGson().fromJson(response, HairTreatment.class);
                        listLoaded.setHairContent(treatment);
                    }

                    @Override
                    public void onErrorResponse(int errorType, String response) {

                    }
                }
                , null, IServerResponseListener.REQUEST_GET);
    }
}
