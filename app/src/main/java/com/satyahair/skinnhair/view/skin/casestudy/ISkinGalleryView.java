package com.satyahair.skinnhair.view.skin.casestudy;

import com.satyahair.skinnhair.model.bean.SkinGallery;

import java.util.List;

/**
 * Created by Sandeep on 08/01/2017.
 */

public interface ISkinGalleryView {
    public void loadingStart();
    public void loadingEnd();
    public void setGalleryHeaders(List<SkinGallery> gallery);
    public void setGalleryContent(SkinGallery gallery);

}
