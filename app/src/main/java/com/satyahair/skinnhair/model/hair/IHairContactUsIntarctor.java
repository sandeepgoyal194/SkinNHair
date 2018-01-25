package com.satyahair.skinnhair.model.hair;

import com.satyahair.skinnhair.model.bean.ContactUsInfo;

/**
 * Created by Sandeep on 18/02/2017.
 */

public interface IHairContactUsIntarctor {
    public void onSubmitClick(ContactUsInfo info,OnQuerySubmitted listener);
    public interface OnQuerySubmitted {
        public void onQuerySubmittedSuccesfully();
        public void onQuerySubmittedFailed();
    }
}
