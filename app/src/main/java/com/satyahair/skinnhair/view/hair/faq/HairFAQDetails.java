package com.satyahair.skinnhair.view.hair.faq;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.FAQ;
import com.satyahair.skinnhair.view.HairNCairBaseActivity;


/**
 * Created by Sandeep on 25/12/2016.
 */

public class HairFAQDetails extends HairNCairBaseActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_detail);
        setmToolbar();


        FAQ faq = (FAQ) getIntent().getSerializableExtra("faq");
        if(faq != null) {
            TextView questionText = (TextView) findViewById(R.id.txt_question);
            TextView ansText = (TextView) findViewById(R.id.txt_answer);
           // questionText.setText(faq.getQuestion());
            setTitle(Html.fromHtml(faq.getQuestion()));
            ansText.setText(faq.getAnswer());
        }
    }
}
