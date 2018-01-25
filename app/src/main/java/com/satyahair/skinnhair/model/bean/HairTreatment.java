package com.satyahair.skinnhair.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sandeep on 27/01/2017.
 */

public class HairTreatment extends BaseBean {
    @SerializedName("title")
    private String title;

    @SerializedName("link")
    private String link;

    @SerializedName("content")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
