package com.satyahair.skinnhair.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.satyahair.skinnhair.R;

/**
 * Created by Sandeep on 01/01/2017.
 */

public class SkinNHairSelectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_hair_selection);
        setTitle("Visit Our");
        LinearLayout hairSeelction = (LinearLayout) findViewById(R.id.btn_hair);
        LinearLayout skinSelection = (LinearLayout) findViewById(R.id.btn_skin);
        hairSeelction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });
        skinSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(2);
                finish();
            }
        });
     /*   String[] treatmentList = {"Skin Section", "Hair Section"};
         ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, treatmentList);


       setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //create constant for result
                if (position == 0) {
                    setResult(2);
                } else {
                    setResult(1);
                }
                finish();
            }
        });*/
    }
}
