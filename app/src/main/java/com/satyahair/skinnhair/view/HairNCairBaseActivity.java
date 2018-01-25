package com.satyahair.skinnhair.view;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;

import com.satyahair.skinnhair.R;

/**
 * Created by Sandeep on 21/12/2016.
 */

public abstract class HairNCairBaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;
    protected Fragment mAddedFragment;
    FragmentManager mFragmentManager;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setTitle(CharSequence title) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            super.setTitle(Html.fromHtml(title.toString(),Html.FROM_HTML_MODE_LEGACY));
        }else {
            super.setTitle(Html.fromHtml(title.toString()));
        }
    }

    public void hideProgressBar() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = null;
    }

    public void showProgressBar() {
        showProgressBar(null);
    }
    public void showProgressBar(String title) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, R.style.Theme_MyDialog);
            mProgressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
            mProgressDialog.setCanceledOnTouchOutside(false);
            if(title !=null) {
                mProgressDialog.setTitle(title);
            }
        }
        mProgressDialog.show();
    }


    protected void addFrgment(Fragment fragment, String fragmentTag, int containerView) {
        if(mFragmentManager==null) {
            mFragmentManager = getSupportFragmentManager();
        }
        FragmentTransaction mOwnerTransaction = mFragmentManager.beginTransaction();
        Fragment fragment1 = mFragmentManager.findFragmentByTag(fragmentTag);
        if (fragment1 != null) {
            fragment = fragment1;
        }
        if (!mFragmentManager.popBackStackImmediate(fragment.getClass().getName(), 0)) {
            mOwnerTransaction.replace(containerView, fragment, fragmentTag);
            if(mFragmentManager.getFragments()!=null && mFragmentManager.getFragments().size() > 0)
                //mOwnerTransaction.addToBackStack(null);
            mAddedFragment = fragment;
            mOwnerTransaction.commit();
        }
    }
    protected void popFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove(fragment);
        trans.commit();
        manager.popBackStack();
    }
    public void setmToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back_arrow));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
   
}
