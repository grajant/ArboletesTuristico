package com.glego.arboletesturistico.Fragments;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.glego.arboletesturistico.DetailsActivity;
import com.glego.arboletesturistico.DrawerActivity;
import com.glego.arboletesturistico.ListPlaces;
import com.glego.arboletesturistico.MyAdapter;
import com.glego.arboletesturistico.R;

import java.util.ArrayList;

public class HotelListFragment extends ListFragment implements OnItemClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ((DrawerActivity) getActivity()).getSupportActionBar().setTitle(R.string.hotel_title);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<ListPlaces> list = ListPlaces.hotelsValues(getActivity());
        MyAdapter adapter  = new MyAdapter(getActivity(), list);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra("option", "hotel");
        intent.putExtra("position", position);
        startActivity(intent);
    }

}
