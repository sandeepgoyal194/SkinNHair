package com.satyahair.skinnhair.model.skin;

import com.satyahair.skinnhair.model.bean.BaseContentData;

/**
 * Created by Sandeep on 03/05/2017.
 */

public interface ISkinComparisonIntractor {
    public void getSkinData(OnDataSync onDataSync);
    public String getLink();
    public interface OnDataSync {
        public void onDataSyncSuccess(BaseContentData data);
        public void onDataSyncFail();
    }
}
