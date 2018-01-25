package com.satyahair.skinnhair.view.hair.blog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.HairNCairBaseActivity;

/**
 * Created by Sandeep on 14/03/2017.
 */

public class ActivityHairBlog  extends HairNCairBaseActivity {
    private ProgressDialog mProgressDialog = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casestudy_detail);
        setmToolbar();
        WebView webView = (WebView) findViewById(R.id.webview);
        setTitle(getTitleText());
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
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
        return "Blog";
    }

    public String getWebURL() {
        return  "http://www.hairtransplantindia.co.in/hair-transplant-blog/";
    }
}
