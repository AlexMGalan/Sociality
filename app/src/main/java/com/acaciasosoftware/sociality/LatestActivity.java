package com.acaciasosoftware.sociality;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class LatestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_latest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.Home) {
            startActivity(new Intent(getApplicationContext(), MapsActivitySoc.class));
            return true;
        }

        if (id == R.id.search) {
            startActivity(new Intent(getApplicationContext(), SearchActivity.class));
            return true;
        }

        if (id == R.id.add) {
            Toast.makeText(getApplicationContext(), "Select a location on the Map to Add entry.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), AddActivity.class));
            return true;
        }

        if (id == R.id.latest) {

            startActivity(new Intent(getApplicationContext(), LatestActivity.class));
            return true;
        }

        if (id == R.id.about) {

            startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            return true;
        }

        if (id == R.id.profile) {
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            return true;
        }

        if (id == R.id.exit) {
            finish();
        }

        return false;
    }

}
