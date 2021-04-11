package com.example.plantmanager.layouts;

import android.content.Intent;
import android.os.Bundle;

import com.example.plantmanager.R;
import com.example.plantmanager.enums.PlantBreed;
import com.example.plantmanager.layouts.fragments.PlantTypeDetailFragment;
import com.example.plantmanager.layouts.plantInstance.PlantInstanceEditActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.widget.Toolbar;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.view.MenuItem;

/**
 * An activity representing a single PlantType detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link PlantTypeListActivity}.
 */
public class PlantTypeDetailActivity extends AppCompatActivity {


    private PlantBreed plantBreed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planttype_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle plantEditBundle = new Bundle();
                plantEditBundle.putSerializable(getString(R.string.plant_breed_key), plantBreed);

                Intent goToPlantEditIntent = new Intent(view.getContext(), PlantInstanceEditActivity.class);
                goToPlantEditIntent.putExtra(getString(R.string.plant_instance_bundle_key), plantEditBundle);
                startActivity(goToPlantEditIntent);
            }
        });

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        plantBreed = (PlantBreed) getIntent().getSerializableExtra(PlantTypeDetailFragment.ARG_ITEM_ID);

        // Create the detail fragment and add it to the activity
        // using a fragment transaction.
        Bundle arguments = new Bundle();
        arguments.putSerializable(PlantTypeDetailFragment.ARG_ITEM_ID, plantBreed);

        PlantTypeDetailFragment fragment = new PlantTypeDetailFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.planttype_detail_container, fragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            navigateUpTo(new Intent(this, PlantTypeListActivity.class));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}