package com.satyahair.skinnhair.model.skin;

import com.satyahair.skinnhair.model.bean.BaseContentData;
import com.satyahair.skinnhair.network.GsonFactory;
import com.satyahair.skinnhair.network.IServerResponseListener;
import com.satyahair.skinnhair.network.ServerManager;

/**
 * Created by Sandeep on 03/05/2017.
 */

public class SkinComparisonIntractorImpl implements ISkinComparisonIntractor {
    @Override
    public void getSkinData(final OnDataSync onDataSync) {
        ServerManager.getInstance().requestDataFromServer(getLink(), new IServerResponseListener() {
                    @Override
                    public void onResponse(String response) {

                        BaseContentData treatment = GsonFactory.getGson().fromJson(response, BaseContentData.class);
                        onDataSync.onDataSyncSuccess(treatment);
                    }

                    @Override
                    public void onErrorResponse(int errorType, String response) {
                        onDataSync.onDataSyncFail();
                    }
                }
                , null, IServerResponseListener.REQUEST_GET);
    }


    @Override
    public String getLink() {
        return "http://www.satyaskinlaser.com/wp-json/pages/1538";
    }
}
