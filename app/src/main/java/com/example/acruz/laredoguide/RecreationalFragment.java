package com.example.acruz.laredoguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecreationalFragment extends Fragment {

    //Declare variables
    private ArrayList<Item> RecAttractions;

    public RecreationalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.browse_item_list, container, false);

        RecAttractions = new ArrayList<Item>();
        RecAttractions.add(new Item(getString(R.string.lake_casa_blanca),
                R.drawable.lakecasablanca,
                getString(R.string.lake_casa_blanca_website),
                getString(R.string.lake_casa_blanca_address),
                getString(R.string.lake_casa_blanca_phone)));
        RecAttractions.add(new Item(getString(R.string.country_club),
                R.drawable.countryclub,
                getString(R.string.country_club_website),
                getString(R.string.country_club_address),
                getString(R.string.country_club_phone)));
        RecAttractions.add(new Item(getString(R.string.laredo_parks),
                R.drawable.parksandleisure,
                getString(R.string.laredo_parks_website),
                getString(R.string.laredo_parks_address),
                getString(R.string.laredo_parks_phone)));
        RecAttractions.add(new Item(getString(R.string.arena_gun_club),
                R.drawable.arenagunclub,
                getString(R.string.arena_gun_club_website),
                getString(R.string.arena_gun_club_address),
                getString(R.string.arena_gun_club_phone)));

        ItemAdapter adapter = new ItemAdapter(getActivity(), RecAttractions);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent detailsIntent = new Intent(getActivity(), DetailsActivity.class);
                // Share the selected item with the Details Category
                detailsIntent.putExtra(getString(R.string.selected_item), RecAttractions.get(i));
                startActivity(detailsIntent);
            }
        });

        return rootView;

    }

}
