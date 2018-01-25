package com.satyahair.skinnhair.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandeep on 18/12/2016.
 */

//TODO need to merge both fragment and activity at one place
public abstract class HairNSkinBaseListView<T extends ViewHolder> extends HairNCairBaseActivity {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    public List<BaseBean> mData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        init();
        setmToolbar();
    }

    void init() {
        setRecyclerView(getRecyclerView());
        setAdapter();
    }

    protected RecyclerView getRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        return recyclerView;
    }

    void setRecyclerView(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;

    }

    private void setAdapter() {
        mRecyclerView.setLayoutManager(getLayoutManager());
        mAdapter = new RecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setmRecyclerViewData(getData());
    }


    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }

    protected abstract List<BaseBean> getData();

    protected abstract T onCreateViewHolder(ViewGroup parent, int viewType);

    public void updateData(List<? extends BaseBean> data) {
        mAdapter.setmRecyclerViewData(data);
        mAdapter.notifyDataSetChanged();

    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<T> {

        Context mContext;
        List<? extends BaseBean> mRecyclerViewData = new ArrayList<>();

        public RecyclerViewAdapter(Context context) {
            mContext = context;

        }

        public void setmRecyclerViewData(List<? extends BaseBean> mRecyclerViewData) {
            if (mRecyclerViewData != null)
                this.mRecyclerViewData = mRecyclerViewData;
        }

        @Override
        public T onCreateViewHolder(ViewGroup parent, int viewType) {
            return HairNSkinBaseListView.this.onCreateViewHolder(parent, viewType);
        }


        @Override
        public void onBindViewHolder(T holder, int position) {
            holder.setContent(mRecyclerViewData.get(position));
        }

        // TODO handle youtube leak
        @Override
        public int getItemCount() {
            return mRecyclerViewData.size();
        }


    }
}


