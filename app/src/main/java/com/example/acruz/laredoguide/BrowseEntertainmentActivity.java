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

        //TODO: List the entertainment attractions
        EntAttractions = new ArrayList<Item>();
        EntAttractions.add(new Item("Anise Kitchen + Market", R.drawable.placeholder,
                "http://anisekitchen.com/",
                "3402 E Del Mar Blvd #220, Laredo, TX 78045",
                "(956) 441-0606"));

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
