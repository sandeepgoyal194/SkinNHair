package com.satyahair.skinnhair.view.hair.casestudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.LogPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.model.bean.HairCaseStudies;
import com.satyahair.skinnhair.network.imageloader.GlideImageLoaderImpl;
import com.satyahair.skinnhair.network.imageloader.ImageLoader;
import com.satyahair.skinnhair.presenter.hair.HairCaseStudyPresenterImpl;
import com.satyahair.skinnhair.presenter.hair.IHairCaseStudyPresenter;
import com.satyahair.skinnhair.view.HairNSkinBaseListView;
import com.satyahair.skinnhair.view.ViewHolder;

import java.util.List;

/**
 * Created by Sandeep on 20/12/2016.
 */

public class ActivityHairCaseStudies extends HairNSkinBaseListView<ActivityHairCaseStudies.CaseStudiesViewHolder> implements IHairCaseStudyView {
    static int counter = 0;

    IHairCaseStudyPresenter mPresenter = new HairCaseStudyPresenterImpl(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Hair-CaseStudies");
    }

    @Override
    protected List<BaseBean> getData() {
        mPresenter.getHairGalleryList();
        return null;
    }

    @Override
    protected ActivityHairCaseStudies.CaseStudiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hair_case_study_item, parent, false);
        return new ActivityHairCaseStudies.CaseStudiesViewHolder(view);
    }

    @Override
    public void setHairTreatmentList(List<HairCaseStudies> hairTreatmentList) {
        updateData(hairTreatmentList);

    }

    @Override
    public void loadingStart() {
        showProgressBar();
    }

    @Override
    public void loadingComplete() {
        hideProgressBar();
    }

    public class CaseStudiesViewHolder extends ViewHolder<HairCaseStudies> {

        TextView mHairTreatmentView;
        HairCaseStudies caseStudy;
        ImageView caseStudyThumb;
        ImageLoader mImageLoader;
        public CaseStudiesViewHolder(View itemView) {
            super(itemView);
            mImageLoader = new GlideImageLoaderImpl(itemView.getContext());
            mHairTreatmentView = (TextView) itemView.findViewById(R.id.txt_title);
            caseStudyThumb = (ImageView) itemView.findViewById(R.id.casestudy_thumb);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ActivityHairCaseStudies.this, ActivityCaseStudyDetail.class);
                    i.putExtra("case_study",caseStudy);
                    startActivity(i);
                }
            });
        }

        @Override
        public void setContent(HairCaseStudies object) {
            caseStudy = object;
            if(object.getCounter() == 0) {
                object.setCounter(++counter);
            }

            LogPrinter log = new LogPrinter(2,"hairncair");
            log.println(object.getTitle().getRendered());
            HairCaseStudies.FeaturedImage image = object.getImage();
            if(image != null) {
                mImageLoader.loadImage(image.getThumbnailUrl(), caseStudyThumb);
            }
            mHairTreatmentView.setText(object.getTitle().getRendered());
        }


    }
}
