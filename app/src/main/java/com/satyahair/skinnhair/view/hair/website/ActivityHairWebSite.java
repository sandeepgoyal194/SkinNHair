package com.satyahair.skinnhair.view.hair.website;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.HairCaseStudies;
import com.satyahair.skinnhair.view.HairNCairBaseActivity;

/**
 * Created by Sandeep on 18/01/2017.
 */

public class ActivityHairWebSite  extends HairNCairBaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casestudy_detail);
        setmToolbar();
        WebView webView = (WebView) findViewById(R.id.webview);
        setTitle(getTitleText());
        showProgressBar();
        webView.loadUrl(getWebURL());
        webView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                hideProgressBar();
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }
        });

}

    protected String getTitleText() {
        return "Hair";
    }

    public String getWebURL() {
       return  "http://hairtransplantindia.co.in";
    }
}
