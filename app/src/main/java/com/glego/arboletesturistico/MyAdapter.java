package com.glego.arboletesturistico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HOME-I on 19/02/2017.
 */

public class MyAdapter extends ArrayAdapter<ListPlaces> {


    public MyAdapter(Context context, ArrayList<ListPlaces> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ListPlaces codes = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_places, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.list_title);
        TextView tvDetail = (TextView) convertView.findViewById(R.id.list_subtitle);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.list_detail);
        ImageView ivIcon = (ImageView) convertView.findViewById(R.id.list_icon);
        // Populate the data into the template view using the data object
        tvTitle.setText(codes.getTitle());
        tvDetail.setText(codes.getDetail());
        tvPrice.setText(codes.getPrice());
        ivIcon.setImageResource(codes.getImageId());
        // Return the completed view to render on screen
        return convertView;
    }

}