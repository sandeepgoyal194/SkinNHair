package com.satyahair.skinnhair.model.skin;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.SkinNHair;
import com.satyahair.skinnhair.model.bean.SkinTreatment;
import com.satyahair.skinnhair.network.GsonFactory;
import com.satyahair.skinnhair.network.IServerResponseListener;
import com.satyahair.skinnhair.network.ServerManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandeep on 01/01/2017.
 */

public class SkinTreatmentIntratorImpl implements ISkinTreatmentIntractor {
    @Override
    public void getSkinTretmentList(final OnSkinTreatmentLoaded listener) {
        final String mSkinTreatmentList[] = SkinNHair.getApplication().getResources().getStringArray(R.array.skin_care);
        final List<SkinTreatment> skinTreatments = new ArrayList<>(mSkinTreatmentList.length);
        //TODO loading view
        for (int i = 0; i < mSkinTreatmentList.length; i++) {
            ServerManager.getInstance().requestDataFromServer(mSkinTreatmentList[i], new IServerResponseListener() {
                        @Override
                        public void onResponse(String response) {
                            SkinTreatment treatment = GsonFactory.getGson().fromJson(response, SkinTreatment.class);
                            skinTreatments.add(treatment);
                            if (skinTreatments.size() % 10 == 0 || skinTreatments.size() >= mSkinTreatmentList.length - 4) {
                                listener.onSkinTreatmentLoadec(skinTreatments);
                            }
                        }

                        @Override
                        public void onErrorResponse(int errorType, String response) {
                            listener.onSkinComesticLoadFail();
                        }
                    }
                    , null, IServerResponseListener.REQUEST_GET);
        }
    }

    @Override
    public void getSkinCometicSurgeryList(final OnSkinTreatmentLoaded listener) {
        final String mSkinSurgeryList[] = SkinNHair.getApplication().getResources().getStringArray(R.array.skin_cosmetic_surgery);
        final List<SkinTreatment> skinTreatments = new ArrayList<>(mSkinSurgeryList.length);
        for (int i = 0; i < mSkinSurgeryList.length; i++) {
            ServerManager.getInstance().requestDataFromServer(mSkinSurgeryList[i], new IServerResponseListener() {
                        @Override
                        public void onResponse(String response) {
                            SkinTreatment treatment = GsonFactory.getGson().fromJson(response, SkinTreatment.class);
                            skinTreatments.add(treatment);
                            if (skinTreatments.size() == mSkinSurgeryList.length) {
                                listener.onSkinTreatmentLoadec(skinTreatments);
                            }
                        }

                        @Override
                        public void onErrorResponse(int errorType, String response) {
                            listener.onSkinComesticLoadFail();
                        }
                    }
                    , null, IServerResponseListener.REQUEST_GET);
        }
    }

    @Override
    public void getSkinPreBridalTreatment(final OnSkinTreatmentload listener) {
        ServerManager.getInstance().requestDataFromServer("http://www.satyaskinlaser.com/wp-json/pages/205", new IServerResponseListener() {
            @Override
            public void onResponse(String response) {
                SkinTreatment treatment = GsonFactory.getGson().fromJson(response, SkinTreatment.class);
                listener.onSkinTreatmentLoaded(treatment);
            }

            @Override
            public void onErrorResponse(int errorType, String response) {
                listener.onSkinTreatmentLoadFail();
            }
        }, null, IServerResponseListener.REQUEST_GET);
    }

    @Override
    public void getSkinCommonDisease(final OnSkinTreatmentload listener) {
        ServerManager.getInstance().requestDataFromServer("http://www.satyaskinlaser.com/wp-json/pages/207", new IServerResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        SkinTreatment treatment = GsonFactory.getGson().fromJson(response, SkinTreatment.class);
                        listener.onSkinTreatmentLoaded(treatment);
                    }

                    @Override
                    public void onErrorResponse(int errorType, String response) {
                        listener.onSkinTreatmentLoadFail();
                    }
                }
                , null, IServerResponseListener.REQUEST_GET);
    }
}
