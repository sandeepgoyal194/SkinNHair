package com.satyahair.skinnhair.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sandeep on 08/01/2017.
 */

public class SkinGallery extends BaseBean {
    @SerializedName("content")
    String mContent;
    @SerializedName("title")
    String mTitle;
    String link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
