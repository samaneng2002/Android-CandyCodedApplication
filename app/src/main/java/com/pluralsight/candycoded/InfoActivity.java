package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);



    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    public void createMapIntent(View view ){
        // Create a Uri from an intent string
        Uri uri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        // Create an Intent from uri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");
        //Check if googleMaps package exist on mobile before calling startActivity
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    public void createPhoneIntent(View view){
        // Create a Uri from an intent string
        Uri uri =Uri.parse("tel:0123456789");
        // Make implicit Intent with action dial
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        //Set intent data
        phoneIntent.setData(uri);
        startActivity(phoneIntent);
    }
}
