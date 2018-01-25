package com.satyahair.skinnhair.view.hair.casestudy;

import android.os.Bundle;
import android.webkit.WebView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.HairCaseStudies;
import com.satyahair.skinnhair.model.bean.SkinGallery;
import com.satyahair.skinnhair.view.HairNCairBaseActivity;

/**
 * Created by Sandeep on 08/01/2017.
 */

public class ActivityCaseStudyDetail extends HairNCairBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casestudy_detail);
        setmToolbar();
        WebView webView = (WebView) findViewById(R.id.webview);
        HairCaseStudies gallery = (HairCaseStudies) getIntent().getSerializableExtra("case_study");
        setTitle(gallery.getTitle().getRendered());
        String content =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                        "<html><head>"+
                        "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                        "<head><body>";

        content += gallery.getContent() + "</body></html>";
        if(gallery != null) {
            webView.loadData(content,"text/html; charset=utf-8", "UTF-8");
        }
    }
}
