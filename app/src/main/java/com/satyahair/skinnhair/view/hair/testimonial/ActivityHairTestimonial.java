package com.satyahair.skinnhair.view.hair.testimonial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.model.bean.HairTestimonial;
import com.satyahair.skinnhair.presenter.hair.HairTestimonialPresenterImpl;
import com.satyahair.skinnhair.presenter.hair.IHairTestimonialPresenter;
import com.satyahair.skinnhair.view.HairNSkinBaseListView;
import com.satyahair.skinnhair.view.ViewHolder;
import com.satyahair.skinnhair.view.YouTubeActivity;

import java.util.List;

/**
 * Created by Sandeep on 20/12/2016.
 */

public class ActivityHairTestimonial extends HairNSkinBaseListView<ActivityHairTestimonial.TestimonialsHolder> implements IHairTestimonialView {

    IHairTestimonialPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HairTestimonialPresenterImpl(this);
        presenter.getHairTestimonial();
        setTitle("Testimonials");
    }

    @Override
    protected List<BaseBean> getData() {
        return mData;
    }

    @Override
    protected TestimonialsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hair_testimonial_item, parent, false);
        return new ActivityHairTestimonial.TestimonialsHolder(view);
    }

    @Override
    public void setHairTestimonials(List<HairTestimonial> testimonials) {
        updateData(testimonials);

    }

    @Override
    public void loadingStart() {
        showProgressBar();
    }

    @Override
    public void loadingFinished() {
        hideProgressBar();
    }

    public class TestimonialsHolder extends ViewHolder<HairTestimonial> {

        YouTubeThumbnailView youTubeThumbnailView;
        TextView mHairTestimonials;
        HairTestimonial testimonial;
        YouTubeThumbnailLoader loader;

        public TestimonialsHolder(View itemView) {
            super(itemView);
            mHairTestimonials = (TextView) itemView.findViewById(R.id.testimonial_title);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.testimonial_thumbnail);
            youTubeThumbnailView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent startYouTubeActivityIntent = new Intent(ActivityHairTestimonial.this, YouTubeActivity.class);
                    startYouTubeActivityIntent.putExtra("videoPath", testimonial.getId());
                    startActivity(startYouTubeActivityIntent);
                }
            });
        }

        @Override
        public void setContent(final HairTestimonial object) {
            testimonial = object;
            mHairTestimonials.setText(object.getDescription());
            if(isFinishing() || isDestroyed()){
                return;
            }
            if(loader != null) {
                loader.release();
            }
            youTubeThumbnailView.initialize("AIzaSyDukZFIYoTMw6uTfafaeINSZUZS9tGywdg", new YouTubeThumbnailView.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                    loader = youTubeThumbnailLoader;
                    youTubeThumbnailLoader.setVideo(object.getId());

                }

                @Override
                public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

                }
            });

        }
    }
}
