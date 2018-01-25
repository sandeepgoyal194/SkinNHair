package com.satyahair.skinnhair.model.skin;

import android.util.LogPrinter;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.SkinNHair;
import com.satyahair.skinnhair.model.bean.HairTreatment;
import com.satyahair.skinnhair.model.bean.SkinGallery;
import com.satyahair.skinnhair.network.GsonFactory;
import com.satyahair.skinnhair.network.IServerResponseListener;
import com.satyahair.skinnhair.network.ServerManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sandeep on 08/01/2017.
 */

public class SkinGalleryIntractorImpl implements ISkinGalleryIntractor {
  /*  @Override
    public void getSkinGallery(final OnSkinGalleryLoaded listener) {
        final List<SkinGallery> gallery = new ArrayList<>();

        ServerManager.getInstance().requestDataFromServer("http://www.satyaskinlaser.com/wp-json/posts?filter[category_name]=mobileskingallery", new IServerResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        gallery.addAll(Arrays.asList(GsonFactory.getGson().fromJson(response, SkinGallery[].class)));
                        listener.setSkinGallery(gallery);
                    }

                    @Override
                    public void onErrorResponse(int errorType, String response) {
                        listener.setSkinGallery(gallery);
                    }
                }
                , null, IServerResponseListener.REQUEST_GET);
    }
*/
    @Override
    public void getSkinCaseStudiesHeader(OnSkinGalleryLoaded lisener) {
      List<SkinGallery> caseStudies = new ArrayList<>();
      String[] casestudies = SkinNHair.getApplication().getResources().getStringArray(R.array.skin_casestudies);
      for(String casestudy:casestudies) {
        String tret[] = casestudy.split("\\?");
        SkinGallery skinCaseStudy = new SkinGallery();
        skinCaseStudy.setmTitle(tret[0]);
        skinCaseStudy.setLink(tret[1]);
        /*  try {
              skinCaseStudy.setLink(tret[1]);
          } catch (Exception e) {
              LogPrinter logPrinter = new LogPrinter(1,"skinnhair");
              logPrinter.println(tret[0]);
          }*/
        caseStudies.add(skinCaseStudy);
      }
      lisener.setSkinCaseStudyHeaders(caseStudies);
    }

    @Override
    public void getSkinGalleryContent(SkinGallery caseStudy, final OnSkinGalleryLoaded listener) {
      ServerManager.getInstance().requestDataFromServer(caseStudy.getLink(), new IServerResponseListener() {
                @Override
                public void onResponse(String response) {
                  try {
                    JSONObject object = new JSONObject(response);
                    response = object.get("items").toString();
                  } catch (JSONException e) {
                    e.printStackTrace();
                  }
                  SkinGallery caseStudy = GsonFactory.getGson().fromJson(response, SkinGallery.class);
                  listener.setSkinGalleryContent(caseStudy);
                /*  HairTreatment treatment = GsonFactory.getGson().fromJson(response, HairTreatment.class);
                  listLoaded.setHairContent(treatment);*/
                }

                @Override
                public void onErrorResponse(int errorType, String response) {

                }
              }
              , null, IServerResponseListener.REQUEST_GET);
    }
}
