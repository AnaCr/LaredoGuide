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
public class RestaurantsFragment extends Fragment {

    //Declare variables
    private ArrayList<Item> Restaurants;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.browse_item_list, container, false);

        // List the restaurants
        Restaurants = new ArrayList<>();
        Restaurants.add(new Item(getString(R.string.anise), R.drawable.anise,
                getString(R.string.anise_website),
                getString(R.string.anise_address),
                getString(R.string.anise_phone)));
        Restaurants.add(new Item(getString(R.string.pino), R.drawable.pino,
                getString(R.string.pino_address),
                getString(R.string.pino_phone)));
        Restaurants.add(new Item(getString(R.string.border_foundry),R.drawable.borderfoundry,
                getString(R.string.border_foundry_website),
                getString(R.string.border_foundry_address),
                getString(R.string.border_foundry_phone)));
        Restaurants.add(new Item(getString(R.string.korean_bbq),R.drawable.koreanbbq,
                getString(R.string.korean_bbq_address),
                getString(R.string.korean_bbq_phone)));
        Restaurants.add(new Item(getString(R.string.pats),R.drawable.pats,
                getString(R.string.pats_website),
                getString(R.string.pats_address),
                getString(R.string.pats_phone)));
        Restaurants.add(new Item(getString(R.string.ka),R.drawable.ka,
                getString(R.string.ka_website),
                getString(R.string.ka_address),
                getString(R.string.ka_phone)));
        Restaurants.add(new Item(getString(R.string.puerto_palenque), R.drawable.puertopalenque,
                getString(R.string.puerto_palenque_website),
                getString(R.string.puerto_palenque_address),
                getString(R.string.puerto_palenque_phone)));
        Restaurants.add(new Item(getString(R.string.el_pescador),R.drawable.elpescador,
                getString(R.string.el_pescador_website),
                getString(R.string.el_pescador_address),
                getString(R.string.el_pescador_phone)));
        Restaurants.add(new Item(getString(R.string.sushi_madre),R.drawable.sushimadre,
                getString(R.string.sushi_madre_website),
                getString(R.string.sushi_madre_address),
                getString(R.string.sushi_madre_phone)));
        Restaurants.add(new Item(getString(R.string.la_laguna),R.drawable.lalaguna,
                getString(R.string.la_laguna_website),
                getString(R.string.la_laguna_address),
                getString(R.string.la_laguna_phone)));
        Restaurants.add(new Item(getString(R.string.kissi),R.drawable.kissi,
                getString(R.string.kissi_address),
                getString(R.string.kissi_phone)));
        Restaurants.add(new Item(getString(R.string.churreria),R.drawable.lachurreria,
                getString(R.string.churreria_address),
                getString(R.string.churreria_phone)));
        Restaurants.add(new Item(getString(R.string.flip_flop),R.drawable.flipflop,
                getString(R.string.flip_flop_website),
                getString(R.string.flip_flop_address),
                getString(R.string.flip_flop_phone)));
        Restaurants.add(new Item(getString(R.string.pinguinos),R.drawable.pinguinos,
                getString(R.string.pinguinos_address),
                getString(R.string.pinguinos_phone)));
        Restaurants.add(new Item(getString(R.string.fresh_snacks),R.drawable.fresh,
                getString(R.string.fresh_snacks_address),
                getString(R.string.fresh_snacks_phone)));


        ItemAdapter adapter = new ItemAdapter(getActivity(), Restaurants);

        ListView listView =  rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent detailsIntent = new Intent(getActivity(), DetailsActivity.class);
                // Share the selected item with the Details Category
                detailsIntent.putExtra(getString(R.string.selected_item), Restaurants.get(i));
                startActivity(detailsIntent);
            }
        });

        return rootView;

    }

}
