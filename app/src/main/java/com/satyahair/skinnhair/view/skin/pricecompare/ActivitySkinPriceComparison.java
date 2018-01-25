package com.satyahair.skinnhair.view.skin.pricecompare;

import android.os.Bundle;
import android.webkit.WebView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseContentData;
import com.satyahair.skinnhair.presenter.skin.ISkinPriceComparisonPresenter;
import com.satyahair.skinnhair.presenter.skin.SkinComparisonPresenterImpl;
import com.satyahair.skinnhair.view.HairNCairBaseActivity;

/**
 * Created by Sandeep on 03/05/2017.
 */

public class ActivitySkinPriceComparison extends HairNCairBaseActivity implements ISkinComparisonView {
    WebView webView;
    ISkinPriceComparisonPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casestudy_detail);
        setmToolbar();
        webView = (WebView) findViewById(R.id.webview);
        mPresenter = new SkinComparisonPresenterImpl(this);
        mPresenter.onCreate();
        setTitle(getResources().getString(R.string.price_comparison));
    }

    @Override
    public void setContent(BaseContentData data) {
        String content =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                        "<html><head>" +
                        "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />" +
                        "<head><body>";

        content += data.getmContent() + "</body></html>";
        if (data != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadData(content, "text/html; charset=utf-8", "UTF-8");
        }
    }
}
