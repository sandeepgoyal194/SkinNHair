package com.satyahair.skinnhair.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sandeep on 03/05/2017.
 */

public class BaseContentData {
    @SerializedName("content")
    String mContent;
    @SerializedName("title")
    String mTitle;

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
