package com.satyahair.skinnhair.view.skin.treatments;

import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.SkinTreatment;
import com.satyahair.skinnhair.view.HairNCairBaseActivity;

/**
 * Created by Sandeep on 01/01/2017.
 */

public class SkinTreatmentDetail extends HairNCairBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casestudy_detail);
        setmToolbar();
        WebView webView = (WebView) findViewById(R.id.webview);
        SkinTreatment treatment = (SkinTreatment) getIntent().getSerializableExtra("treatment");
        if (treatment != null) {
            // questionText.setText(faq.getQuestion());
            setTitle(Html.fromHtml(treatment.getTitle()));
            int index = treatment.getContent().indexOf("<script");
            String contentText;
            if (index != -1) {
                contentText = treatment.getContent().substring(0, index - 1);
            } else {
                contentText = treatment.getContent();
            }
            String content =
                    "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                            "<html><head>" +
                            "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />" +
                            "<head><body>";

            content += contentText + "</body></html>";
            webView.loadData(content, "text/html; charset=utf-8", "UTF-8");
        }
    }
}
