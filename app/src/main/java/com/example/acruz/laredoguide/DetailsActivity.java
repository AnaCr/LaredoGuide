package com.example.acruz.laredoguide;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //find views by id
        ImageView attractionImage = findViewById(R.id.attraction_image_view);
        TextView attractionName = findViewById(R.id.name);
        TextView attractionWebsite = findViewById(R.id.website);
        TextView attractionAddress = findViewById(R.id.address);
        TextView attractionPhone = findViewById(R.id.phone);

        //Get the selected Item
        Item selectedItem = getIntent().getParcelableExtra("selectedItem");

        // set the details for selected Item
        //Image
        attractionImage.setImageResource(selectedItem.getmItemDrawableId());
        //Name
        attractionName.setText(selectedItem.getmItemName());
        //Website
        if (selectedItem.getmItemWebsite().equals(Item.NO_WEBSITE_PROVIDED)) {
            attractionWebsite.setVisibility(View.GONE);
        } else {
            attractionWebsite.setText(selectedItem.getmItemWebsite());
        }
        //Address
        attractionAddress.setText(selectedItem.getmItemAddress());
        //Phone number
        attractionPhone.setText(selectedItem.getmItemPhone());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

