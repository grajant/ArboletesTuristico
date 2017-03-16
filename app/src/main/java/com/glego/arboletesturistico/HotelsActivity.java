package com.glego.arboletesturistico;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsActivity extends DrawerActivity {

    private ListView listView;
    private ArrayList<ListPlaces> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        // Get all extras coming from other activities
        //extras = getIntent().getExtras();

        //Instance hotel values to ArrayList
        list = ListPlaces.hotelsValues(this);
        //Create custom adapter to use in listview
        MyAdapter adapter = new MyAdapter(this, list);

        // Create listview from xml resource and set adapter and method to handle clicks
        listView = (ListView) findViewById(R.id.list_view_hotels);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listItemListener);
    }

    OnItemClickListener listItemListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Intent intent = new Intent();
            //ResistorCode selectedColor = list.get(position);

            //intent.putExtra("color", selectedColor.color);
            //setResult(RESULT_OK, intent);
            //finish();
        }
    };

    @Override
    protected String toolbarTitle() {
        return getString(R.string.hotel_title);
    }
}
