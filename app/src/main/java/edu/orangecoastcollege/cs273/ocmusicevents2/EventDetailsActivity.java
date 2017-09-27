package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);


        Intent intent = getIntent();

        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);
        TextView eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView eventDateTextView = (TextView) findViewById(R.id.eventDateTextView);
        TextView eventDayTextView = (TextView) findViewById(R.id.eventDayTextView);
        TextView eventTimeTextView = (TextView) findViewById(R.id.eventTimeTextView);
        TextView eventLocationTextView = (TextView) findViewById(R.id.eventLocationTextView);
        TextView eventAddres1TextView = (TextView) findViewById(R.id.eventAddress1TextView);
        TextView eventAddres2TextView = (TextView) findViewById(R.id.eventAddress2TextView);

        AssetManager am = this.getAssets();
        try {
            InputStream stream = am.open(intent.getStringExtra("ImageName"));
            Drawable image = Drawable.createFromStream(stream, intent.getStringExtra("Title"));
            eventImageView.setImageDrawable(image);
        }
        catch (IOException e)
        {
            Log.e("OC Music Events", "Error loading image: " + intent.getStringExtra("ImageName"), e);
        }


        eventTitleTextView.setText(intent.getStringExtra("Title"));
        eventDateTextView.setText(intent.getStringExtra("Date"));
        eventDayTextView.setText(intent.getStringExtra("Day"));
        eventTimeTextView.setText(intent.getStringExtra("Time"));
        eventLocationTextView.setText(intent.getStringExtra("Location"));
        eventAddres1TextView.setText(intent.getStringExtra("Address1"));
        eventAddres2TextView.setText(intent.getStringExtra("Address2"));
    }

    protected void goBackToList(View v)
    {
        finish();
    }
}
