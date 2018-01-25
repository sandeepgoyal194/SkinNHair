package com.satyahair.skinnhair.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sandeep on 20/12/2016.
 */

public class HairCaseStudies extends BaseBean {
    Title title;
    Title content;
    @SerializedName("_embedded")
    FeaturedImage image;

    int featured_media;

    public int getFeatured_media() {
        return featured_media;
    }

    public void setFeatured_media(int featured_media) {
        this.featured_media = featured_media;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Title getContent() {
        return content;
    }

    public void setContent(Title content) {
        this.content = content;
    }

    public FeaturedImage getImage() {
        return image;
    }

    public void setImage(FeaturedImage image) {
        this.image = image;
    }

    public class FeaturedImage implements Serializable {

        public class Json implements Serializable{
            String source_url;

            public String getSource_url() {
                return source_url;
            }

            public void setSource_url(String source_url) {
                this.source_url = source_url;
            }
        }

        @SerializedName("wp:featuredmedia")
        Json[] thumbnailUrl;

        public String getThumbnailUrl() {
            return thumbnailUrl[0].getSource_url();
        }

        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl[0].source_url = thumbnailUrl;
        }
    }

    @Override
    public boolean equals(Object obj) {
        HairCaseStudies caseStudies = (HairCaseStudies) obj;
        return caseStudies.getTitle().equals(getTitle());
    }

    public class Title extends BaseBean {
        String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

        @Override
        public String toString() {
            return rendered;
        }
    }
}
