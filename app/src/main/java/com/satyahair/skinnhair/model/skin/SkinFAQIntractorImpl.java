package com.satyahair.skinnhair.model.skin;

import com.satyahair.skinnhair.model.bean.FAQ;
import com.satyahair.skinnhair.network.GsonFactory;
import com.satyahair.skinnhair.network.IServerResponseListener;
import com.satyahair.skinnhair.network.ServerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sandeep on 04/01/2017.
 */

public class SkinFAQIntractorImpl implements ISkinFAQInteractor {
    @Override
    public void getSkinFAQ(final OnSkinFAQLoaded listener) {
        final List<FAQ> faqs = new ArrayList<>();

        ServerManager.getInstance().requestDataFromServer("http://www.satyaskinlaser.com/wp-json/posts?filter[category_name]=faq", new IServerResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        faqs.addAll(Arrays.asList(GsonFactory.getGson().fromJson(response, FAQ[].class)));
                        listener.setSkinFAQ(faqs);
                    }

                    @Override
                    public void onErrorResponse(int errorType, String response) {
                        listener.setSkinFAQ(faqs);
                    }
                }
                , null, IServerResponseListener.REQUEST_GET);

    }
}

