package com.example.acruz.laredoguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finds the views by id
        TextView browseRestaurants = findViewById(R.id.restaurants_text_view);
        TextView browseEntertainment = findViewById(R.id.entertainment_text_view);
        TextView browseRecreation = findViewById(R.id.recreational_text_view);
        TextView browseEducation = findViewById(R.id.educational_text_view);

        browseRestaurants.setOnClickListener(this);
        browseEntertainment.setOnClickListener(this);
        browseRecreation.setOnClickListener(this);
        browseEducation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Perform action on click
        switch (v.getId()) {
            case R.id.restaurants_text_view:
                // create and start the browse restaurants intent
                Intent browseRestaurantsIntent = new Intent(MainActivity.this, BrowseRestaurantsActivity.class);
                startActivity(browseRestaurantsIntent);
                break;
            case R.id.entertainment_text_view:
                // create and start the browse entertainment intent
                Intent browseEntertainmentIntent = new Intent(MainActivity.this, BrowseEntertainmentActivity.class);
                startActivity(browseEntertainmentIntent);
                break;
            case R.id.recreational_text_view:
                // create and start the browse recreational attractions intent
                Intent browseRecreationalIntent = new Intent(MainActivity.this, BrowseRecreationalActivity.class);
                startActivity(browseRecreationalIntent);
                break;
            case R.id.educational_text_view:
                // create and start the browse educational attractions intent
                Intent browseEducationalIntent = new Intent(MainActivity.this, BrowseEducationalActivity.class);
                startActivity(browseEducationalIntent);
                break;
        }

    }
}
