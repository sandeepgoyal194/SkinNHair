package com.satyahair.skinnhair.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.satyahair.skinnhair.R;


/**
 * Created by Gagan on 12/4/2016.
 */

public class ActivitySplash extends Activity {

    ImageView iv;
    ObjectAnimator alpha;
    Animator.AnimatorListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);
        iv = (ImageView) findViewById(R.id.imageview);
        listener = new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent start = new Intent();
                start.setClass(ActivitySplash.this, ActivityDashBoard.class);
                startActivity(start);
                finish();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        };

        alpha = ObjectAnimator.ofFloat(iv, "alpha", 0.1f, 0.4f, 1.0f);
        alpha.setInterpolator(new AccelerateDecelerateInterpolator());
        alpha.setDuration(2000);
        alpha.addListener(listener);
        alpha.start();

    }


}
