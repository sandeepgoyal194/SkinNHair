package com.satyahair.skinnhair.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.satyahair.skinnhair.R;

public class YouTubeActivity extends YouTubeBaseActivity {

    YouTubePlayerView mPlayerView = null;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    String URL;
    ImageView mCloseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
        final String videoPath = getIntent().getStringExtra("videoPath");
        mPlayerView = (YouTubePlayerView) findViewById(R.id.youTubeView);
        mCloseView = (ImageView) findViewById(R.id.txtClose);
        mCloseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (videoPath != null) {
                    youTubePlayer.loadVideo(videoPath);

                } else {
                    finish();
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        mPlayerView.initialize("AIzaSyDukZFIYoTMw6uTfafaeINSZUZS9tGywdg", mOnInitializedListener);

    }
}
