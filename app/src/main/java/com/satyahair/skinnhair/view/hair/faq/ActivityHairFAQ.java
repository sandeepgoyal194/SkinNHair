package com.satyahair.skinnhair.view.hair.faq;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.model.bean.BaseBean;
import com.satyahair.skinnhair.model.bean.FAQ;
import com.satyahair.skinnhair.presenter.hair.HairFAQPresenterImpl;
import com.satyahair.skinnhair.presenter.hair.IHairFAQPresenter;
import com.satyahair.skinnhair.view.HairNSkinBaseListView;
import com.satyahair.skinnhair.view.ViewHolder;

import java.util.List;

/**
 * Created by Sandeep on 20/12/2016.
 */

public class ActivityHairFAQ extends HairNSkinBaseListView<ActivityHairFAQ.FAQHolder> implements IHairFAQView {
    static int counter = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = 0;
        setTitle("FAQ");
    }

    IHairFAQPresenter mPresenter = new HairFAQPresenterImpl(this);
    @Override
    protected List<BaseBean> getData() {
        showProgressBar();
        mPresenter.getHairFAQ();
        return null;
    }

    @Override
    protected FAQHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hair_faq_item, parent, false);
        return new FAQHolder(view);
    }

    @Override
    public void setHairFAQ(List<FAQ> faqs) {
        hideProgressBar();
        updateData(faqs);
    }

    public class FAQHolder extends ViewHolder<FAQ> {
        TextView question;
        TextView countertext;
        FAQ faq;
        public FAQHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.faq_question);
            countertext = (TextView) itemView.findViewById(R.id.faq_counter);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ActivityHairFAQ.this,HairFAQDetails.class);
                    i.putExtra("faq",faq);
                    startActivity(i);
                }
            });
        }

        @Override
        public void setContent(FAQ object) {
            faq = object;
            countertext.setText(++counter+"");
            question.setText(object.getQuestion());
        }
    }
}
