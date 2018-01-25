package com.satyahair.skinnhair.network.imageloader;

import android.widget.ImageView;

/**
 * Created by sandeep.g9 on 10/20/2016.
 */

public interface  ImageLoader {
    public void loadImage(String url, ImageView imageView);
    public void loadImage(String url, ImageView imageView, int placeHolderID);
}
