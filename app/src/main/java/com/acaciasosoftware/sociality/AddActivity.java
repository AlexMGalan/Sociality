package com.acaciasosoftware.sociality;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class AddActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
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
            Toast.makeText(getApplicationContext(), "Search is coming soon.", Toast.LENGTH_LONG).show();
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
