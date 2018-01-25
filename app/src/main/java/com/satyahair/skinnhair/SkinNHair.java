package com.satyahair.skinnhair;

import android.app.Application;
import android.content.Context;

/**
 * Created by Sandeep on 18/12/2016.
 */

public class SkinNHair extends Application {
    private static SkinNHair mApplication;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mApplication = this;
    }

    public static SkinNHair getApplication() {
        return mApplication;
    }
}
