package com.example.elmira.sci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String [] homeStringArray = getResources().getStringArray(R.array.homelist);
        ArrayAdapter <String> homeAdapter=new ArrayAdapter <String> (this,
                android.R.layout.simple_list_item_1, android.R.id.text1, homeStringArray);

        ListView homeList= (ListView) findViewById(R.id.listView);
        homeList.setAdapter(homeAdapter);

        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView) view).getText().toString();
                Intent i;
                switch (position){
                    case 0:
                        i = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(i);
                        return;
                    case 1:
                            i = new Intent(MainActivity.this, RecommendationActivity.class);
                            startActivity(i);
                            return;
                        case 2:
                            i = new Intent(MainActivity.this, RecentlyWatchedCasesActivity.class);
                            startActivity(i);
                            return;
                        case 3:
                            finish();
                            return;

                }
            }
        });
    }
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}