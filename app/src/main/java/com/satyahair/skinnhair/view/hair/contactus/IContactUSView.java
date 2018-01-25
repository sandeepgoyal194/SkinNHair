package com.satyahair.skinnhair.view.hair.contactus;

import android.graphics.Bitmap;

import com.satyahair.skinnhair.model.bean.BitmapMap;

/**
 * Created by Sandeep on 18/02/2017.
 */

public interface IContactUSView {
    public String getName();
    public String getEmail();
    public String getPhone();
    public String getMessage();
    public BitmapMap getLeftPic();
    public BitmapMap getRigthPic();
    public BitmapMap getFrontPic();
    public BitmapMap getBackPic();
    public BitmapMap getTopPic();


    public void setNameError(String message);
    public void setEmailError(String emailError);
    public void setPhoneError(String phoneError);

    public void setSelectDoctorVisiblity(int visiblity);
    public void setSelectScheduleVisiblity(int visiblity);

    public void setAdapterForDrRuchi();
    public void setAdapterForDrShail();

    public String getSelectedDoctor();
    public String getSelectedSchedule();
    public String getSelectedCategory();


    public void setScheduleError(String errorMsg);
    public void setDoctorSelectError(String errorMsg);

    public void clearAll();

    public void uploadingStart();
    public void uploadingEnd();

    public void showMessage(String message);
    public void finish();

    public void updatePicUploadView(int visiblity);

    void setTitle(CharSequence s);
}
