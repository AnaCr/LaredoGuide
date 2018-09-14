package com.example.acruz.laredoguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Get the selected Item
        Item selectedItem = getIntent().getParcelableExtra("selectedItem");

        //find views by id
        ImageView attractionImage = findViewById(R.id.attraction_image_view);
        TextView attractionName = findViewById(R.id.name);
        TextView attractionWebsite = findViewById(R.id.website);
        TextView attractionAddress = findViewById(R.id.address);
        TextView attractionPhone = findViewById(R.id.phone);

        // set the details for selected Item
        attractionImage.setImageResource(selectedItem.getmItemDrawableId());
        attractionName.setText(selectedItem.getmItemName());

        if (selectedItem.getmItemWebsite() == null){
            attractionWebsite.setVisibility(View.GONE);
        }else{attractionWebsite.setText(selectedItem.getmItemWebsite());}

        if(selectedItem.getmItemAddress() == null){
            attractionAddress.setVisibility(View.GONE);
        }else{attractionAddress.setText(selectedItem.getmItemAddress());}

        if(selectedItem.getmItemPhone() == null){
            attractionPhone.setVisibility(View.GONE);
        }else{attractionPhone.setText(selectedItem.getmItemPhone());}

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

