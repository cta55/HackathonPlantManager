package com.example.plantmanager.layouts.plantInstance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.plantmanager.PlantDB;
import com.example.plantmanager.R;
import com.example.plantmanager.layouts.fragments.HeaderFragment;
import com.example.plantmanager.layouts.fragments.PlantInstancePictureFragment;

public class PlantInstanceViewActivity extends PlantInstanceActivity implements View.OnClickListener{

    private HeaderFragment plantInstanceHeaderFragment;
    private PlantInstancePictureFragment plantInstancePictureFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_instance_view);

        Bundle args = getIntent().getBundleExtra(getString(R.string.plant_instance_bundle_key));

        plantDBInterface = PlantDB.getInstance(this).plantDBInterface();

        if ((plantID = args.getInt(getString(R.string.plant_id_key))) == 0) {
            throw new RuntimeException("No plant ID given to PlantInstanceViewActivity");
        }
        getPlantDataFromPlantInstance(plantID);

        setupFragments(getString(R.string.plant_instance_view_activity_footer_button_fragment_text));
        getViewsFromID();
        addPlantDataToViews();
        setupViewModels(this, this, plantID);
    }

    @Override
    protected void setupFragments(String footerButtonText) {
        super.setupFragments(footerButtonText);

        plantInstanceHeaderFragment = HeaderFragment.newHeader(
                plantInstance.getPlantName()
        );
        plantInstancePictureFragment = PlantInstancePictureFragment.newPlantInstancePicture(
                plantID
        );

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.myPlantsHeaderFragmentContainerView, plantInstanceHeaderFragment)
                .add(R.id.plantInstancePictureFragmentContainerView, plantInstancePictureFragment)
                .commit();
    }



    @Override
    public void onClick(View v) {
        Intent goToPlantInstanceEditIntent = new Intent(this, PlantInstanceEditActivity.class);
        Bundle args = new Bundle();
        args.putInt(getString(R.string.plant_id_key), plantID);
        goToPlantInstanceEditIntent.putExtra(getString(R.string.plant_instance_bundle_key), args);
        startActivity(goToPlantInstanceEditIntent);
    }
}
