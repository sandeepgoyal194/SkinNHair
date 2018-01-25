package com.satyahair.skinnhair.model.bean;

import android.graphics.Bitmap;

/**
 * Created by Sandeep on 19/02/2017.
 */

public class BitmapMap {
    String path;
    Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
