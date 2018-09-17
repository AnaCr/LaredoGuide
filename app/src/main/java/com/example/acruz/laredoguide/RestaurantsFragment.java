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
        Restaurants = new ArrayList<Item>();
        Restaurants.add(new Item("Anise Kitchen + Market", R.drawable.anise,
                "anisekitchen.com",
                "3402 E Del Mar Blvd #220, Laredo, TX 78045",
                "(956) 441-0606"));
        Restaurants.add(new Item("Pino Burger", R.drawable.pino,
                "4205 Jaime Zapata Memorial Hwy, Laredo, TX 78043",
                "(956) 724-7466"));
        Restaurants.add(new Item("	Border Foundry",R.drawable.borderfoundry,
                "borderfoundrylaredo.com	",
                "7718 McPherson Rd, Laredo, TX 78045	",
                "(956) 724-5907"));
        Restaurants.add(new Item("	Korean BBQ",R.drawable.koreanbbq,
                "3910 E Del Mar Blvd #304, Laredo, TX 78045",
                "	(956) 516-5003"));
        Restaurants.add(new Item("	Pat's Kitchen",R.drawable.pats,
                "pats50skitchen.com","5517 McPherson Rd #12, Laredo, TX 78041",
                "(956) 753-7287"));
        Restaurants.add(new Item("	Ka Café	",R.drawable.ka,"kacafelaredo.com",
                "7510 McPherson Rd #106, Laredo, TX 78041","(956) 568-5640	"));
        Restaurants.add(new Item("	Puerto Palenque	",R.drawable.puertopalenque,
                "puertopalenque.com","7122 Bob Bullock Loop #20, Laredo, TX 78041",
                "(956) 568-0851"));
        Restaurants.add(new Item("	Mariscos El Pescador",R.drawable.elpescador,
                "mariscoselpescador.com","3919 San Dario Ave, Laredo, TX 78041",
                "(956) 724-8831"));
        Restaurants.add(new Item("	Sushi Madre	",R.drawable.sushimadre,
                "sushimadre.com","7124 Bob Bullock Loop, Laredo, TX 78041",
                "(956) 722-7874"));
        Restaurants.add(new Item("	La Laguna",R.drawable.lalaguna,
                "lalagunamariscosandsushi.com",
                "4205 Jaime Zapata Memorial Hwy #33, Laredo, TX 78043",
                "(956) 568-1980"));
        Restaurants.add(new Item("	Tacos Kissi",R.drawable.kissi,
                "1705 E Del Mar Blvd, Laredo, TX 78041","(956) 795-1709"));
        Restaurants.add(new Item("	La Churreria Sabor Mexico",R.drawable.lachurreria,
                "7124 Bob Bullock Loop #106, Laredo, TX 78041",
                "(956) 568-6680"));
        Restaurants.add(new Item("	Flip Flop Coffee Shop",R.drawable.flipflop,
                "flipflopcoffeeshop.com","3910 E Del Mar Blvd Ste 201, Laredo, TX 78045",
                "(956) 267-8228"));
        Restaurants.add(new Item("	Los Pinguinos Snacks",R.drawable.pinguinos,
                "2201 S Jarvis Ave, Laredo, TX 78046	","(956) 441-0976	"));
        Restaurants.add(new Item("	Fresh Snacks",R.drawable.fresh,
                "9708 McPherson Rd suite 300, Laredo, TX 78045","(956) 602-0222"));


        ItemAdapter adapter = new ItemAdapter(getActivity(), Restaurants);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent detailsIntent = new Intent(getActivity(), DetailsActivity.class);
                // Share the selected item with the Details Category
                detailsIntent.putExtra("selectedItem", Restaurants.get(i));
                startActivity(detailsIntent);
            }
        });

        return rootView;

    }

}
