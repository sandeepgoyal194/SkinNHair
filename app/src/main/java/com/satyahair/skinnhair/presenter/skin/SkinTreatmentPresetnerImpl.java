package com.satyahair.skinnhair.presenter.skin;

import com.satyahair.skinnhair.model.bean.SkinTreatment;
import com.satyahair.skinnhair.model.skin.ISkinTreatmentIntractor;
import com.satyahair.skinnhair.model.skin.SkinTreatmentIntratorImpl;
import com.satyahair.skinnhair.view.skin.treatments.ISkinTreatmentLoadView;
import com.satyahair.skinnhair.view.skin.treatments.ISkinTreatmentView;

import java.util.List;

/**
 * Created by Sandeep on 01/01/2017.
 */

public class SkinTreatmentPresetnerImpl implements ISkinTreatmentPresenter, ISkinTreatmentIntractor.OnSkinTreatmentLoaded, ISkinTreatmentIntractor.OnSkinTreatmentload {
    ISkinTreatmentView mView;
    ISkinTreatmentLoadView mLoadView;

    public SkinTreatmentPresetnerImpl(ISkinTreatmentView mView) {
        this.mView = mView;
    }

    public SkinTreatmentPresetnerImpl(ISkinTreatmentLoadView mLoadView) {
        this.mLoadView = mLoadView;
    }

    @Override
    public void getSkinTreatmentList() {
        ISkinTreatmentIntractor intractor = new SkinTreatmentIntratorImpl();
        mView.loadingStart();
        intractor.getSkinTretmentList(this);
    }

    @Override
    public void getSkinCosmeticSurgeryList() {
        ISkinTreatmentIntractor intractor = new SkinTreatmentIntratorImpl();
        mView.loadingStart();
        intractor.getSkinCometicSurgeryList(this);
    }

    @Override
    public void getCommonDisease() {
        ISkinTreatmentIntractor intractor = new SkinTreatmentIntratorImpl();
        mLoadView.loadingStart();
        intractor.getSkinCommonDisease(this);
    }

    @Override
    public void getPreBridalTreatment() {
        ISkinTreatmentIntractor intractor = new SkinTreatmentIntratorImpl();
        mLoadView.loadingStart();
        intractor.getSkinPreBridalTreatment(this);
    }


    @Override
    public void onSkinTreatmentLoadec(List<SkinTreatment> skinTreatments) {
        mView.loadingComplete();
        mView.setSkinTreatmentList(skinTreatments);
    }

    @Override
    public void onSkinCosmeticSurgeryLoaded(List<SkinTreatment> skinTreatments) {
        mView.loadingComplete();
        mView.setSkinTreatmentList(skinTreatments);
    }

    @Override
    public void onSkinComesticLoadFail() {
        if (mView != null) {
            mView.loadingComplete();
        }
        if (mLoadView != null) {
            mLoadView.loadingComplete();
        }
    }

    @Override
    public void onSkinTreatmentLoaded(SkinTreatment skinTreatments) {
        mLoadView.loadingComplete();
        mLoadView.setSkinTreatmentList(skinTreatments);
    }

    @Override
    public void onSkinTreatmentLoadFail() {
        mLoadView.loadingComplete();
    }
}
