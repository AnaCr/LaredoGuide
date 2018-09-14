package com.example.acruz.laredoguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BrowseEducationalActivity extends AppCompatActivity{

    //Declare variables
    private ArrayList<Item> EduAttractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_item_list);

        // TODO: List the educational attractions
        EduAttractions = new ArrayList<Item>();
        EduAttractions.add(new Item("The Republic of the Rio Grande Museum	",R.drawable.repriograndemuseum,
                "webbheritage.org","1005 Zaragoza St, Laredo, TX 78040",
                "(956) 727-3480"));
        EduAttractions.add(new Item("Lamar Bruni Vergara Planetarium",R.drawable.planetarium,
                "tamiu.edu/planetarium",
                "5201 University Boulevard Laredo, Tx 78041 inside Texas A&M International University",
                "(956) 326-2444"));
        EduAttractions.add(new Item("Villa Antigua Border Heritage Museum",R.drawable.villanatigua,
                "webbheritage.org","810 Zaragoza St, Laredo, TX 78040	",
                "(956) 718-2727"));
        EduAttractions.add(new Item("Helen Richter Watson Art Gallery - TAMIU	",R.drawable.watsongallery,
                "tamiu.edu/watsongallery",
                "5201 University Boulevard Laredo, Tx 78041 inside the Sue and Radcliffe Killam Library",
                "(956) 326-4483"));
        EduAttractions.add(new Item("Laredo Center for the Arts",R.drawable.centerforarts,
                "laredoartcenter.org","	500 San Agustin Ave, Laredo, TX 78040",
                "(956) 725-1715"));
        EduAttractions.add(new Item("Lamar Bruni Vergara Environmental Science Center",R.drawable.lbvenvsciencecenter,
                "1 W End Washington St, Laredo, TX 78040 inside Laredo Community College",
                "(956) 764-5701"));

        ItemAdapter adapter = new ItemAdapter(this, EduAttractions);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent detailsIntent = new Intent(BrowseEducationalActivity.this, DetailsActivity.class);
                // Share the selected item with the Details Category
                detailsIntent.putExtra("selectedItem", EduAttractions.get(i));
                startActivity(detailsIntent);
            }
        });
    }
}
