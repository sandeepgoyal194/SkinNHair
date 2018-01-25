package com.satyahair.skinnhair.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.view.hair.HairDashBoard;
import com.satyahair.skinnhair.view.skin.SkinDashBoard;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sandeep on 21/12/2016.
 */

public class ActivityDashBoard extends HairNCairBaseActivity {
    ImageView banner;
    int currentPage = 0;
    int selectedFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        banner = (ImageView) findViewById(R.id.banner);
        startSelectionActivity();
        setmToolbar();
        /*final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 3) {
                    currentPage = 0;
                }
                promtionalEvent.setCurrentItem(currentPage++, true);
            }
        };
        CirclePageIndicator circleIndicator = (CirclePageIndicator) findViewById(R.id.circles);
        circleIndicator.setViewPager(promtionalEvent);
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 500, 3000);*/
    }
    MenuItem menuItem = null;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chooseoption,menu);
        menuItem = menu.getItem(0);
        if (selectedFragment == 1) {
            menuItem.setTitle("Skin");
        }else if (selectedFragment == 2 ) {
            menuItem.setTitle("Hair");
        }
        return true;
    }
    void startSelectionActivity() {
        Intent i = new Intent(this, SkinNHairSelectionActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(selectedFragment == 1) {
            selectedFragment = 2;
        }else {
            selectedFragment = 1;
        }
        changeFragment();
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        selectedFragment = resultCode;
        if(resultCode == Activity.RESULT_CANCELED) {
            finish();
            return;
        }
        changeFragment();

    }

    private void changeFragment() {
        if (selectedFragment == 1) {
            if(menuItem != null) {
                menuItem.setTitle("Skin");
            }
            banner.setImageResource(R.drawable.collage_hair);
            addFrgment(HairDashBoard.HairDashBoardInstance(), "hair_dashboard", R.id.fragment_container);
        } else {
            banner.setImageResource(R.drawable.collage_skin);
            if(menuItem != null) {
                menuItem.setTitle("Hair");
            }
            addFrgment(SkinDashBoard.SkinDashBoardInstance(), "skin_dashboard", R.id.fragment_container);
        }
    }
}
