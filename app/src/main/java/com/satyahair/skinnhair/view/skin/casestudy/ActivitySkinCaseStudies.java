package com.satyahair.skinnhair.view.skin.casestudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.model.bean.SkinGallery;
import com.satyahair.skinnhair.presenter.skin.ISkinGalleryPresenter;
import com.satyahair.skinnhair.presenter.skin.SkinGalleryPresenterImpl;
import com.satyahair.skinnhair.view.HairNSkinBaseListView;
import com.satyahair.skinnhair.view.ViewHolder;

import java.util.List;

/**
 * Created by Sandeep on 30/12/2016.
 */

public class ActivitySkinCaseStudies extends HairNSkinBaseListView<ActivitySkinCaseStudies.GalleryHolder> implements ISkinGalleryView {
    static int counter = 0;
    ISkinGalleryPresenter mPresenter = new SkinGalleryPresenterImpl(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = 0;
        setTitle("Skin-CaseStudies");
    }


    @Override
    protected List<BaseBean> getData() {
        showProgressBar();
        mPresenter.getSkinCaseStudyHeaders();
        return null;
    }

    @Override
    protected GalleryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_item, parent, false);
        return new ActivitySkinCaseStudies.GalleryHolder(view);
    }

    @Override
    public void loadingStart() {
        showProgressBar();
    }

    @Override
    public void loadingEnd() {
        hideProgressBar();
    }

    @Override
    public void setGalleryHeaders(List<SkinGallery> gallery) {
        hideProgressBar();
        updateData(gallery);
    }

    @Override
    public void setGalleryContent(SkinGallery gallery) {
        Intent i = new Intent(ActivitySkinCaseStudies.this, ActivityCaseStudyDetail.class);
        i.putExtra("case_study", gallery);
        startActivity(i);
    }


    public class GalleryHolder extends ViewHolder<SkinGallery> {
        TextView question;
        TextView countertext;
        SkinGallery gallery;

        public GalleryHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.txt_title);
            countertext = (TextView) itemView.findViewById(R.id.title_counter);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setGalleryContent(gallery);

                }
            });
        }

        @Override
        public void setContent(SkinGallery object) {
            gallery = object;
            if (object.getCounter() == 0) {
                object.setCounter(++counter);
            }
            countertext.setText(object.getCounter() + "");
            question.setText(object.getmTitle());
        }
    }
}
