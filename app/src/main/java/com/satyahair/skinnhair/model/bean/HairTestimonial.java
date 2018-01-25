package com.satyahair.skinnhair.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sandeep on 20/12/2016.
 */

public class HairTestimonial extends BaseBean {
    @SerializedName("id")
    VideoId id;
    @SerializedName("snippet")
    Snippet snippet;


    class VideoId {
        @SerializedName("videoId")
        String videoId;

        public String getVideoId() {
            return videoId;
        }

    }

    class Snippet {
        @SerializedName("description")
        String description;

        public String getDescription() {
            return description;
        }
    }

    public String getId() {
        return id.getVideoId();
    }



    public String getDescription() {
        return snippet.getDescription();
    }


}
