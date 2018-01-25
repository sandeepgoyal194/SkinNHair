package com.satyahair.skinnhair.model.hair;

import com.satyahair.skinnhair.model.bean.FAQ;
import com.satyahair.skinnhair.network.GsonFactory;
import com.satyahair.skinnhair.network.IServerResponseListener;
import com.satyahair.skinnhair.network.ServerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sandeep on 25/12/2016.
 */

public class HairFAQIntractorImpl implements IHairFAQIntractor {
    @Override
    public void getHairFAQ(final OnHairFAQLoaded listener) {
        final List<FAQ> faqs = new ArrayList<>();

        ServerManager.getInstance().requestDataFromServer("http://www.hairtransplantindia.co.in/wp-json/posts?type=dict_faqs", new IServerResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        faqs.addAll(Arrays.asList(GsonFactory.getGson().fromJson(response, FAQ[].class)));
                        listener.setHairFAQ(faqs);
                    }

                    @Override
                    public void onErrorResponse(int errorType, String response) {

                    }
                }
                , null, IServerResponseListener.REQUEST_GET);

    }
}
