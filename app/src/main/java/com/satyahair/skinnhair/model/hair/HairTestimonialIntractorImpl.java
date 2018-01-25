package com.satyahair.skinnhair.model.hair;

import com.satyahair.skinnhair.model.bean.HairTestimonial;
import com.satyahair.skinnhair.network.GsonFactory;
import com.satyahair.skinnhair.network.IServerResponseListener;
import com.satyahair.skinnhair.network.ServerManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sandeep on 27/12/2016.
 */

public class HairTestimonialIntractorImpl implements IHairTestimonialIntractor {

    @Override
    public void getTestimonials(final OnTestimonialLoaded listener) {
        final List<HairTestimonial> testimonials = new ArrayList<>();

        ServerManager.getInstance().requestDataFromServer("https://www.googleapis.com/youtube/v3/search?key=AIzaSyDEgmi6kMSFiUGR4TeMnoJO6X_j4gGCy9c&channelId=UCP0xnXo1z6EccC4sc5XG3Rw&part=snippet,id&order=date&maxResults=50", new IServerResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            response = object.get("items").toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        testimonials.addAll(Arrays.asList(GsonFactory.getGson().fromJson(response, HairTestimonial[].class)));
                        listener.setTestimonials(testimonials);
                    }

                    @Override
                    public void onErrorResponse(int errorType, String response) {

                    }
                }
                , null, IServerResponseListener.REQUEST_GET);

    }
}

