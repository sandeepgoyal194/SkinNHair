package com.satyahair.skinnhair.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandeep on 18/12/2016.
 */

public abstract class HairNSkinBaseListViewFragment<T extends ViewHolder> extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    public List<BaseBean> mData = new ArrayList<>();
    protected Toolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getResId(), container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        init(view);
        getData();
        return view;
    }

    protected int getResId() {
        return R.layout.activity_list_view;
    }

    void init(View view) {
        setRecyclerView(getRecyclerView(view));
        setAdapter();
    }

    protected RecyclerView getRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        return recyclerView;
    }

    void setRecyclerView(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;

    }

    private void setAdapter() {
        mRecyclerView.setLayoutManager(getLayoutManager());
        mAdapter = new RecyclerViewAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setmRecyclerViewData(mData);
    }


    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    protected abstract void getData();

    protected abstract T onCreateViewHolder(ViewGroup parent, int viewType);

    public void updateData(List<? extends BaseBean> data) {
        mAdapter.setmRecyclerViewData(data);
        mAdapter.notifyDataSetChanged();

    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<T> {

        Context mContext;
        List<? extends BaseBean> mRecyclerViewData;

        public RecyclerViewAdapter(Context context) {
            mContext = context;

        }

        public void setmRecyclerViewData(List<? extends BaseBean> mRecyclerViewData) {
            this.mRecyclerViewData = mRecyclerViewData;
        }

        @Override
        public T onCreateViewHolder(ViewGroup parent, int viewType) {
            return HairNSkinBaseListViewFragment.this.onCreateViewHolder(parent, viewType);
        }


        @Override
        public void onBindViewHolder(T holder, int position) {
            holder.setContent(mRecyclerViewData.get(position));
        }

        @Override
        public int getItemCount() {
            return mRecyclerViewData.size();
        }


    }
}


