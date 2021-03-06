package com.example.plantmanager.layouts.plantInstance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plantmanager.Plant;
import com.example.plantmanager.PlantDB;
import com.example.plantmanager.R;
import com.example.plantmanager.enums.PlantBreed;

/**
 * Activity for the creation and editing of Plant objects. Editable fields include:
 * - Name
 * - Age
 * - Image
 * Plant breed is set when navigating from the Search activity, and cannot be changed in this activity.
 *
 * Activity can be started with either a Plant Breed, if creating a new Plant, or a Plant ID, if
 * editing a currently existing Plant.
 * Attempting to start the activity without bundling one of these two variables will cause a
 * RuntimeException.
 *
 * This activity provides a ListenerViewModel to pass itself to it's child fragments as an OnClickListener
 */

public class PlantInstanceEditActivity extends PlantInstanceActivity implements View.OnClickListener{

    // GUI Views
    private TextView plantNameTextView;
    private ImageView plantImageView;

    public PlantInstanceEditActivity() {
        super();
    }

    /**
     * Standard Activity method, sets the screen up. Contains the following functionality:
     * - Gets a database interface
     * - Instantiates the fragments and applies them to the layout
     * - Instantiates the View Models and adds the relevant data
     * - Gets the views via their IDs
     * - Gets initial plant data values from either the current plant or from the defaults
     * - Applies initial plant data to the views
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_instance_edit);

        Bundle args = getIntent().getBundleExtra(getString(R.string.plant_instance_bundle_key));

        plantDBInterface = PlantDB.getInstance(this).plantDBInterface();

        // Generic setup methods
        setupFragments(getString(R.string.plant_instance_edit_activity_footer_button_fragment_text));
        getViewsFromID();

        // Initial plant data is read from the given plant or from the defaults depending on bundle input
        if (args == null) {
            throw new RuntimeException("Cannot start PlantInstanceEditActivity without bundle");

        } else if ((plantID = args.getInt(getString(R.string.plant_id_key))) != 0) { // Plant ID input
            getPlantDataFromPlantInstance(plantID);

        } else if ((plantBreed = (PlantBreed) args.getSerializable(getString(R.string.plant_breed_key))) != null) { // Plant Breed input
            getPlantDataFromDefaults(plantBreed);
        } else {
            throw new RuntimeException("No type or plant ID passed to PlantInstanceEditActivity");
        }
        // Setting view values
        addPlantDataToViews();
        setupViewModels(this, this, plantID);
    }


    /**
     * Private helper method that gets View objects from their resource IDs.
     */
    @Override
    protected void getViewsFromID() {
        super.getViewsFromID();
        plantNameTextView = findViewById(R.id.headerTextView);
        plantImageView = findViewById(R.id.plantInstanceImageView);
    }


    /**
     * Private helper method for setting up Views to the initial data set.
     */
    @Override
    protected void addPlantDataToViews() {
        super.addPlantDataToViews();
        plantNameTextView.setText(plantName);
        plantImageView.setImageResource(plantImageID);
    }


    /**
     * Lazy way of handling the OnClick events from all Views on screen.
     * @param view : The View that fired the OnClick event
     */
    @Override
    public void onClick(View view) { // TODO... Handle image button press

        // Reading plant data from views TODO... Ensure that data isn't empty
        plantName = plantNameTextView.getText().toString();
        // plantType is enforced and cannot be changed from this screen
        plantAge = Integer.parseInt(plantAgeTextView.getText().toString());
        // plantImageID is set when user finished with the picture button screen

        if (plantInstance == null) { // Making new Plant
            plantInstance = new Plant(plantName, plantAge, plantImageID,  plantBreed);
            plantID = (int) plantDBInterface.insertPlant(plantInstance);
        } else { // Editing existing Plant Object
            plantInstance.setPlantName(plantName);
            // plant type is enforced and cannot be changed
            plantInstance.setAge(plantAge);
            plantInstance.setImageID(plantImageID);
        }


        Intent goToPlantInstancePageIntent = new Intent(this, PlantInstanceViewActivity.class);
        Bundle args = new Bundle();
        args.putInt(getString(R.string.plant_id_key), plantID);
        goToPlantInstancePageIntent.putExtra(getString(R.string.plant_instance_bundle_key), args);
        startActivity(goToPlantInstancePageIntent);

    }
}