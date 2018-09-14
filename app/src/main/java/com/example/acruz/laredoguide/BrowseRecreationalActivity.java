package com.example.acruz.laredoguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BrowseRecreationalActivity extends AppCompatActivity {

    //Declare variables
    private ArrayList<Item> RecAttractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

        RecAttractions = new ArrayList<Item>();
        RecAttractions.add(new Item("Lake Casa Blanca International State Park",
                R.drawable.placeholder,
                "	https://tpwd.texas.gov/state-parks/lake-casa-blanca	",
                "	5102 Bob Bullock Loop Laredo, TX 78041	",
                "	(956) 725-3826	"));
        RecAttractions.add(new Item("	Laredo Country Club	",
                R.drawable.placeholder,
                "	https://www.laredocc.com/	",
                "	1415 Country Club Dr, Laredo, TX 78045	",
                "	(956) 727-2900	"));
        RecAttractions.add(new Item("City of Laredo Parks & Leisure	",
                R.drawable.placeholder,
                "	http://www.cityoflaredo.com/PARKS/	",
                "	2201 Piedra China Laredo, Texas 78043	",
                "	(956) 795-2350	"));
        RecAttractions.add(new Item("	Arena Gun Club	",
                R.drawable.placeholder,
                "	https://www.arenagunclub.com/	",
                "	6501 Arena Blvd #106a, Laredo, TX 78041	",
                "	(956) 723-1911	"));

        ItemAdapter adapter = new ItemAdapter(this, RecAttractions);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent detailsIntent = new Intent(BrowseRecreationalActivity.this, DetailsActivity.class);
                // Share the selected item with the Details Category
                detailsIntent.putExtra("selectedItem", RecAttractions.get(i));
                startActivity(detailsIntent);
            }
        });
    }

}
