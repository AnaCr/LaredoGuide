package com.example.acruz.laredoguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationalFragment extends Fragment {

    //Declare variables
    private ArrayList<Item> EduAttractions;

    public EducationalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.browse_item_list, container, false);

        EduAttractions = new ArrayList<Item>();
        EduAttractions.add(new Item(getString(R.string.rio_grande_museum),R.drawable.repriograndemuseum,
                getString(R.string.rio_grande_museum_website),getString(R.string.rio_grande_museum_address),
                getString(R.string.rio_grande_museum_phone)));
        EduAttractions.add(new Item(getString(R.string.planetarium),R.drawable.planetarium,
                getString(R.string.planetarium_website),
                getString(R.string.planetarium_address),
                getString(R.string.planetarium_phone)));
        EduAttractions.add(new Item(getString(R.string.villa_antigua),R.drawable.villanatigua,
                getString(R.string.villa_antigua_website),
                getString(R.string.villa_antigua_address),
                getString(R.string.villa_antigua_phone)));
        EduAttractions.add(new Item(getString(R.string.helen_richter),R.drawable.watsongallery,
                getString(R.string.helen_richter_website),
                getString(R.string.helen_richter_address),
                getString(R.string.helen_richter_phone)));
        EduAttractions.add(new Item(getString(R.string.arts_center),R.drawable.centerforarts,
                getString(R.string.arts_center_website),
                getString(R.string.arts_center_address),
                getString(R.string.arts_center_phone)));
        EduAttractions.add(new Item(getString(R.string.lbv_science_center),R.drawable.lbvenvsciencecenter,
                getString(R.string.lbv_science_center_address),
                getString(R.string.lbv_science_center_phone)));

        ItemAdapter adapter = new ItemAdapter(getActivity(), EduAttractions);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent detailsIntent = new Intent(getActivity(), DetailsActivity.class);
                // Share the selected item with the Details Category
                detailsIntent.putExtra(getString(R.string.selected_item), EduAttractions.get(i));
                startActivity(detailsIntent);
            }
        });

        return rootView;

    }

}
