package com.satyahair.skinnhair.model.skin;

import android.widget.Toast;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.SkinNHair;
import com.satyahair.skinnhair.model.bean.SkinTreatment;
import com.satyahair.skinnhair.network.GsonFactory;
import com.satyahair.skinnhair.network.IServerResponseListener;
import com.satyahair.skinnhair.network.ServerManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandeep on 26/03/2017.
 */

public class SkinCareIntractorImpl implements ISkinCareIntractor {
    @Override
    public void getSkinCareTreatmentTitleList(onSkinCareTreatmentListLoaded listLoaded) {
        List<SkinTreatment> hairTreatments = new ArrayList<>();
        String[] treatments = SkinNHair.getApplication().getResources().getStringArray(R.array.skin_care_list);
        for(String treatment:treatments) {
            String tret[] = treatment.split("\\?");
            SkinTreatment skinTreatment = new SkinTreatment();
            skinTreatment.setTitle(tret[0]);
            try{
            skinTreatment.setLink(tret[1]);}
            catch (ArrayIndexOutOfBoundsException e){
                Toast.makeText(SkinNHair.getApplication(),tret[0],Toast.LENGTH_LONG).show();
            }
            hairTreatments.add(skinTreatment);
        }
        listLoaded.setSkinCareTreatmentTitleList(hairTreatments);
    }

    @Override
    public void getHairCareTreatmentTitleList(onSkinCareTreatmentListLoaded listLoaded) {
        List<SkinTreatment> hairTreatments = new ArrayList<>();
        String[] treatments = SkinNHair.getApplication().getResources().getStringArray(R.array.hair_care);
        for(String treatment:treatments) {
            String tret[] = treatment.split("\\?");
            SkinTreatment skinTreatment = new SkinTreatment();
            skinTreatment.setTitle(tret[0]);
            skinTreatment.setLink(tret[1]);
            hairTreatments.add(skinTreatment);
        }
        listLoaded.setHairCareTreatmentTitleList(hairTreatments);
    }

    @Override
    public void getSkinCareTreamentContent(SkinTreatment treatment, final onSkinCareTreatmentListLoaded listLoaded) {
        ServerManager.getInstance().requestDataFromServer(treatment.getLink(), new IServerResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            response = object.get("items").toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        SkinTreatment treatment = GsonFactory.getGson().fromJson(response, SkinTreatment.class);
                        listLoaded.setSkinCareContent(treatment);
                    }

                    @Override
                    public void onErrorResponse(int errorType, String response) {
                        listLoaded.setSkinCareContentFailed();
                    }
                }
                , null, IServerResponseListener.REQUEST_GET);
    }
}
