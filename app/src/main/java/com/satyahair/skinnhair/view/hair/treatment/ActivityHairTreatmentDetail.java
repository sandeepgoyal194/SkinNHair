package com.satyahair.skinnhair.view.hair.treatment;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.FAQ;
import com.satyahair.skinnhair.model.bean.HairTreatment;
import com.satyahair.skinnhair.model.bean.SkinGallery;
import com.satyahair.skinnhair.view.HairNCairBaseActivity;

/**
 * Created by Sandeep on 27/01/2017.
 */

public class ActivityHairTreatmentDetail extends HairNCairBaseActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setmToolbar();

        setmToolbar();
        WebView webView = (WebView) findViewById(R.id.webview);
        TextView textView = (TextView) findViewById(R.id.txt_answer);
        textView.setVisibility(View.GONE);
        webView.setVisibility(View.VISIBLE);
        HairTreatment treatment = (HairTreatment) getIntent().getSerializableExtra("hair_treatment");
        setTitle(treatment.getTitle());
        String content =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                        "<html><head>"+
                        "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                        "<head><body>";

        content += treatment.getContent() + "</body></html>";
        if(treatment != null) {
            webView.loadData(content,"text/html; charset=utf-8", "UTF-8");
        }
    }
}
