package com.satyahair.skinnhair.presenter.hair;

import android.util.Patterns;
import android.view.View;

import com.satyahair.skinnhair.model.bean.ContactUsInfo;
import com.satyahair.skinnhair.model.hair.HairContactUsIntractorImpl;
import com.satyahair.skinnhair.model.hair.IHairContactUsIntarctor;
import com.satyahair.skinnhair.view.hair.contactus.IContactUSView;

/**
 * Created by Sandeep on 18/02/2017.
 */

public class HairContactUsPresenterImpl implements IHairContactPresenter, IHairContactUsIntarctor.OnQuerySubmitted {
    IContactUSView mView;
    ContactUsInfo info;

    public HairContactUsPresenterImpl(IContactUSView mView) {
        this.mView = mView;
    }

    @Override
    public void onQuerySubmittedSuccesfully() {
        mView.uploadingEnd();
        mView.clearAll();
        mView.showMessage("Success-Fully Submitted");
        mView.finish();
    }

    @Override
    public void onQuerySubmittedFailed() {
        mView.uploadingEnd();
    }

    @Override
    public void onSubmitClick() {
        if (!isConsultentSelected) {
            if (checkDoctorNotSelected()) {
                return;
            } else if (checkScheduleNotSelected()) {
                return;
            }
        }

        if (checkNameNotValid()) {
            return;
        } else if (checkEmailNotValid()) {
            return;
        } else if (checkPhoneNotValid()) {
            return;
        }
        info = getDetails();
        IHairContactUsIntarctor intractor = new HairContactUsIntractorImpl();
        mView.uploadingStart();
        intractor.onSubmitClick(info, this);
    }

    private boolean checkScheduleNotSelected() {
        if (mView.getSelectedSchedule().equals("")) {
            mView.setScheduleError("Please Select Schedule");
            return true;
        }
        return false;
    }

    private boolean checkDoctorNotSelected() {
        if (mView.getSelectedDoctor().equals("")) {
            mView.setDoctorSelectError("Please Select Doctor");
            return true;
        }
        return false;
    }

    boolean isConsultentSelected = false;

    @Override
    public void onCategorySelected(int position) {
        if (position == 1) {
            mView.setTitle("Query");
            mView.setSelectDoctorVisiblity(View.GONE);
            mView.setSelectScheduleVisiblity(View.GONE);
            mView.updatePicUploadView(View.VISIBLE);
            isConsultentSelected = true;
        } else {
            mView.setSelectDoctorVisiblity(View.VISIBLE);
            mView.setSelectScheduleVisiblity(View.VISIBLE);
            mView.setTitle("Book an Appointment");
            mView.updatePicUploadView(View.GONE);
            isConsultentSelected = false;
        }
    }

    @Override
    public void onDoctorSelected(int position) {
        if (position == 1) {
            mView.setAdapterForDrRuchi();
        } else if (position == 0) {
            mView.setAdapterForDrShail();
        }
    }

    @Override
    public void onCancelClick() {
        mView.clearAll();
        mView.finish();
    }

    private ContactUsInfo getDetails() {
        ContactUsInfo info = new ContactUsInfo();
        if (mView.getSelectedCategory().equals("Appointment")) {
            info.setClinic_name(mView.getSelectedSchedule());
            info.setDr_name(mView.getSelectedDoctor());
        }
        info.setType(mView.getSelectedCategory());
        info.setName(mView.getName());
        info.setEmail(mView.getEmail());
        info.setMessage(mView.getMessage());
        info.setPhoneno(mView.getPhone());
        info.setBackpic(mView.getBackPic());
        info.setFrontpic(mView.getFrontPic());
        info.setRightpic(mView.getRigthPic());
        info.setLeftpic(mView.getLeftPic());
        info.setToppic(mView.getTopPic());
        return info;
    }

    private boolean checkEmailNotValid() {
        if (mView.getEmail().isEmpty()) {
            mView.setEmailError("Email Can't be Empty");
            return true;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(mView.getEmail()).matches()) {
            mView.setEmailError("Please Enter Valid Email Address");
            return true;
        }
        return false;
    }

    private boolean checkNameNotValid() {
        if (mView.getName().isEmpty()) {
            mView.setNameError("Name Can't be Empty");
            return true;
        }
        return false;
    }

    private boolean checkPhoneNotValid() {
        if (mView.getPhone().isEmpty()) {
            mView.setPhoneError("Phone Can't be Empty");
            return true;
        } else if (mView.getPhone().length() == 10 && !Patterns.PHONE.matcher(mView.getPhone()).matches()) {
            mView.setEmailError("Please Enter Valid Phone Address");
            return true;
        }
        return false;
    }
}
