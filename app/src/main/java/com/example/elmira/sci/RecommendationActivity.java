package com.example.elmira.sci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecommendationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String [] rcmndStringArray = getResources().getStringArray(R.array.recomended_cases);
        ArrayAdapter<String> rcmndAdapter=new ArrayAdapter <String> (this,
                android.R.layout.simple_list_item_1, android.R.id.text1, rcmndStringArray);

        ListView rcmndList= (ListView) findViewById(R.id.listView2);
        rcmndList.setAdapter(rcmndAdapter);

        rcmndList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(RecommendationActivity.this, ShowCaseActivity.class);
                startActivity(i);
            }
        });

    }
}
