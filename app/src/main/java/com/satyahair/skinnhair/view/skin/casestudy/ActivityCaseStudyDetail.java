package com.satyahair.skinnhair.view.skin.casestudy;

import android.app.AlertDialog;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.SkinGallery;
import com.satyahair.skinnhair.view.HairNCairBaseActivity;

/**
 * Created by Sandeep on 08/01/2017.
 */

public class ActivityCaseStudyDetail extends HairNCairBaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casestudy_detail);
        setmToolbar();
        WebView webView = (WebView) findViewById(R.id.webview);
        SkinGallery gallery = (SkinGallery) getIntent().getSerializableExtra("case_study");
        setTitle(gallery.getmTitle());
        showProgressBar();
        webView.loadUrl(gallery.getLink());
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
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setJavaScriptEnabled(true);
    }


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casestudy_detail);
        setmToolbar();
        WebView webView = (WebView) findViewById(R.id.webview);
        SkinGallery gallery = (SkinGallery) getIntent().getSerializableExtra("case_study");
        setTitle(gallery.getmTitle());
        String content =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                        "<html><head>"+
                        "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                        "<head><body>";

        content += gallery.getmContent() + "</body></html>";
        if(gallery != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadData(content,"text/html; charset=utf-8", "UTF-8");
        }
    }*/
}
