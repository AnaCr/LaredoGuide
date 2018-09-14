package com.example.acruz.laredoguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BrowseEntertainmentActivity extends AppCompatActivity {

    //Declare variables
    private ArrayList<Item> EntAttractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

        EntAttractions = new ArrayList<Item>();
        EntAttractions.add(new Item("The Alamo Drafthouse",R.drawable.alamodrafthouse,
                "drafthouse.com/laredo",
                "11210 EastPoint Dr, Laredo, TX 78045","(956) 242-6440	"));
        EntAttractions.add(new Item("Cinemark Theatres	",R.drawable.cinemark,
                "cinemark.com",
                "5300 San Dario Ave, Laredo, TX 78041 inside Mall Del Norte",
                "(956) 725-0132"));
        EntAttractions.add(new Item("Sames Auto Arena",R.drawable.samesautoarena,
                "samesautoarena.com",
                "6700 Arena Blvd, Laredo, TX 78041","(956) 791-9192"));
        EntAttractions.add(new Item("Uni-Trade Stadium	",R.drawable.unitrade,
                "6320 Sinatra Pkwy, Laredo, TX 78041",
                "(956) 753-6877"));
        EntAttractions.add(new Item("Mall Del Norte",R.drawable.malldelnorte,
                "malldelnorte.com",
                "5300 San Dario Ave, Laredo, TX 78041","(956)724-8191"));
        EntAttractions.add(new Item("The Outlet Shoppes",R.drawable.outletshoppes,
                "theoutletshoppesatlaredo.com",
                "1600 Water St, Laredo, TX 78040	","(956)625-5350"));
        EntAttractions.add(new Item("Jett Bowl North",R.drawable.jettbowl,
                "jettbowl.com","5823 McPherson Rd, Laredo, TX 78041",
                "(956) 724-2695"));

        ItemAdapter adapter = new ItemAdapter(this, EntAttractions);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent detailsIntent = new Intent(BrowseEntertainmentActivity.this, DetailsActivity.class);
                // Share the selected item with the Details Category
                detailsIntent.putExtra("selectedItem", EntAttractions.get(i));
                startActivity(detailsIntent);
            }
        });
    }
}
