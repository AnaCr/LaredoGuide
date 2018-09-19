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
public class EntertainmentFragment extends Fragment {

    //Declare variables
    private ArrayList<Item> EntAttractions;

    public EntertainmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.browse_item_list, container, false);

        EntAttractions = new ArrayList<Item>();
        EntAttractions.add(new Item(getString(R.string.alamo_drafthouse),R.drawable.alamodrafthouse,
                getString(R.string.alamo_drafthouse_website),
                getString(R.string.alamo_drafthouse_address),
                getString(R.string.alamo_drafthouse_phone)));
        EntAttractions.add(new Item(getString(R.string.cinemark),R.drawable.cinemark,
                getString(R.string.cinemark_website),
                getString(R.string.cinemark_address),
                getString(R.string.cinemark_phone)));
        EntAttractions.add(new Item(getString(R.string.sames_auto_arena),R.drawable.samesautoarena,
                getString(R.string.sames_auto_arena_website),
                getString(R.string.sames_auto_arena_address),
                getString(R.string.sames_auto_arena_phone)));
        EntAttractions.add(new Item(getString(R.string.uni_trade),R.drawable.unitrade,
                getString(R.string.uni_trade_address),
                getString(R.string.uni_trade_phone)));
        EntAttractions.add(new Item(getString(R.string.mall),R.drawable.malldelnorte,
                getString(R.string.mall_website),
                getString(R.string.mall_address),
                getString(R.string.mall_phone)));
        EntAttractions.add(new Item(getString(R.string.outlet),R.drawable.outletshoppes,
                getString(R.string.outlet_website),
                getString(R.string.outlet_address),
                getString(R.string.outlet_phone)));
        EntAttractions.add(new Item(getString(R.string.jett_bowl),R.drawable.jettbowl,
                getString(R.string.jett_bowl_website),
                getString(R.string.jett_bowl_address),
                getString(R.string.jett_bowl_phone)));

        ItemAdapter adapter = new ItemAdapter(getActivity(), EntAttractions);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent detailsIntent = new Intent(getActivity(), DetailsActivity.class);
                // Share the selected item with the Details Category
                detailsIntent.putExtra(getString(R.string.selected_item), EntAttractions.get(i));
                startActivity(detailsIntent);
            }
        });

        return rootView;

    }

}
