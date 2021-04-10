package com.example.plantmanager.layouts.plantInstance;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.plantmanager.Plant;
import com.example.plantmanager.PlantDB;
import com.example.plantmanager.PlantDBInterface;
import com.example.plantmanager.R;
import com.example.plantmanager.enums.PlantBreed;
import com.example.plantmanager.layouts.fragments.FooterButtonFragment;
import com.example.plantmanager.viewModels.ListenerViewModel;
import com.example.plantmanager.viewModels.PlantInstanceViewModel;

public abstract class PlantInstanceActivity extends AppCompatActivity {

    protected final String PLANT_ID_KEY = getString(R.string.plant_id_key);

    protected FooterButtonFragment footerButtonFragment;

    protected ViewModelProvider viewModelProvider;
    protected ListenerViewModel listenerViewModel;
    protected PlantInstanceViewModel plantInstanceViewModel;

    protected TextView plantNameTextView;
    protected TextView plantTypeTextView;
    protected TextView plantAgeTextView;

    protected int plantID;
    protected String plantName;
    protected PlantBreed plantBreed;
    protected int plantAge;
    protected int plantImageID;

    protected Plant plantInstance;
    protected final PlantDBInterface plantDBInterface;

    public PlantInstanceActivity() {
        plantDBInterface = PlantDB.getInstance(this).plantDBInterface();
    }

    protected void setupFragments(String footerButtonText) {
        footerButtonFragment = FooterButtonFragment.newFooter(footerButtonText);
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.plantInstanceFooterButtonFragmentContainerView, footerButtonFragment)
                .commit();
    }

    protected void setupViewModels(AppCompatActivity activity, View.OnClickListener listener, int plantID) {
        viewModelProvider = new ViewModelProvider(activity);

        listenerViewModel = viewModelProvider.get(ListenerViewModel.class);
        listenerViewModel.setListener(listener);

        if (plantID != 0) {
            plantInstanceViewModel = viewModelProvider.get(PlantInstanceViewModel.class);
            plantInstanceViewModel.addPlantInstance(plantID, plantDBInterface.getPlant(plantID));
        }
    }

    protected void getViewsFromID() {
        plantNameTextView = findViewById(R.id.headerTextView);
        plantTypeTextView = findViewById(R.id.plantInstanceTypeDetailValueView);
        plantAgeTextView = findViewById(R.id.plantInstanceAgeDetailValueView);
    }

    /**
     * Private helper method for retrieving plant data from a plant object.
     * @param plantID : The plant ID of the Plant object.
     */
    protected void getPlantDataFromPlantInstance(int plantID) {
        // Getting Plant from database
        plantInstance = plantDBInterface.getPlant(plantID);

        // Reading data from Plant object
        plantName = plantInstance.getPlantName();
        plantBreed = plantInstance.getPlantBreed();
        plantAge = plantInstance.getAge();
        plantImageID = plantInstance.getImageID();
    }

    /**
     * Private helper method for retrieving default plant data from a specific PlantBreed.
     * @param plantBreed : The breed of plant which is being created.
     */
    protected void getPlantDataFromDefaults(PlantBreed plantBreed) {
        // Reading plant data from resources folder and PlantBreed enum
        plantID = 0;
        plantInstance = null;
        plantName = getString(R.string.default_plant_instance_name_text);
        plantAge = Integer.parseInt(getString(R.string.default_plant_instance_age_value));
        plantImageID = plantBreed.getImageID();
    }

    /**
     * Private helper method for setting up Views to the initial data set.
     */
    protected void addPlantDataToViews() {
        plantNameTextView.setText(plantName);
        plantTypeTextView.setText(plantBreed.getName());
        plantAgeTextView.setText(plantAge);
    }
}
