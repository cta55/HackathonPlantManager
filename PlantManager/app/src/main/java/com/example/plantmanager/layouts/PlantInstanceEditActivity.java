package com.example.plantmanager.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.plantmanager.Plant;
import com.example.plantmanager.PlantDB;
import com.example.plantmanager.PlantDBInterface;
import com.example.plantmanager.R;
import com.example.plantmanager.enums.PlantBreed;
import com.example.plantmanager.layouts.fragments.FooterButtonFragment;
import com.example.plantmanager.layouts.fragments.HeaderFragment;
import com.example.plantmanager.viewModels.ListenerViewModel;

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

public class PlantInstanceEditActivity extends AppCompatActivity implements View.OnClickListener{

    // Bundle keys
    private final String PLANT_BREED_KEY = getString(R.string.plant_breed_key);
    private final String PLANT_ID_KEY = getString(R.string.plant_id_key);

    // Child Fragments
    private HeaderFragment headerFragment;
    private FooterButtonFragment footerButtonFragment;

    // View Models
    private ListenerViewModel listenerViewModel;

    // GUI Views
    private EditText plantNameEditText;
    private TextView plantTypeTextView;
    private EditText plantAgeEditText;
    private ImageButton plantImageButton;

    // Plant data
    private int plantID;
    private String plantName;
    private PlantBreed plantBreed;
    private int plantAge;
    private int plantImageID;

    // Plant Object
    private Plant plantInstance;
    private PlantDBInterface plantDBInterface;

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

        // Getting database interface from static method
        plantDBInterface = PlantDB.getInstance(this).plantDBInterface();

        // Generic setup methods
        setupFragments();
        setupViewModels();
        getViewsFromID();

        // Initial plant data is read from the given plant or from the defaults depending on bundle input
        if (savedInstanceState == null) {
            throw new RuntimeException("Cannot start PlantInstanceEditActivity without bundle");

        } else if ((plantID = savedInstanceState.getInt(PLANT_ID_KEY)) != 0) { // Plant ID input
            getPlantDataFromPlantInstance(plantID);

        } else if ((plantBreed = (PlantBreed) savedInstanceState.getSerializable(PLANT_BREED_KEY)) != null) { // Plant Breed input
            getPlantDataFromDefaults(plantBreed);
        } else {
            throw new RuntimeException("No type or plant ID passed to PlantInstanceEditActivity");
        }
        // Setting view values
        addPlantDataToViews();
    }


    /**
     * Private helper method that instantiates fragments and adds them to the layout. Fragment input
     * values are sourced from the resources folder and then via the View Models.
     */
    private void setupFragments() {
        // Instantiating fragments with specific input values
        headerFragment = HeaderFragment.newHeader(
                getString(R.string.plant_instance_edit_activity_header_text)
        );
        footerButtonFragment = FooterButtonFragment.newFooter(
                getString(R.string.plant_instance_edit_activity_footer_button_fragment_text)
        );

        // Adding fragments to layout
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.plantInstanceEditHeaderFragmentContainerView, headerFragment)
                .add(R.id.plantInstanceEditFooterButtonFragmentContainerView, footerButtonFragment)
                .commit();
    }

    /**
     * Private helper method that instantiates View Models and enters relevant data. This activity
     * only uses the ListenerViewModel in order to pass itself as a OnClickListener.
     */
    private void setupViewModels() {
        // Getting View Model
        listenerViewModel = new ViewModelProvider(this).get(ListenerViewModel.class);
        // Setting this as the relevant listener
        listenerViewModel.setListener(this);
    }

    /**
     * Private helper method that gets View objects from their resource IDs.
     */
    private void getViewsFromID() {
        plantNameEditText = null; // TODO...
        plantTypeTextView = findViewById(R.id.plantInstanceEditTypeDetailValueView);
        plantAgeEditText = findViewById(R.id.plantInstanceEditAgeDetailEditTextNumber);
        plantImageButton = findViewById(R.id.plantInstanceEditImageButtonView);
    }

    /**
     * Private helper method for retrieving plant data from a plant object.
     * @param plantID : The plant ID of the Plant object.
     */
    private void getPlantDataFromPlantInstance(int plantID) {
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
    private void getPlantDataFromDefaults(PlantBreed plantBreed) {
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
    private void addPlantDataToViews() {
        plantNameEditText.setText(plantName);
        plantTypeTextView.setText(plantBreed.name());
        plantAgeEditText.setText(plantAge);
        plantImageButton.setImageResource(plantImageID);
    }

    /**
     * Lazy way of handling the OnClick events from all Views on screen.
     * @param view : The View that fired the OnClick event
     */
    @Override
    public void onClick(View view) { // TODO... Handle image button press

        // Reading plant data from views TODO... Ensure that data isn't empty
        plantName = plantNameEditText.getText().toString();
        // plantType is enforced and cannot be changed from this screen
        plantAge = Integer.parseInt(plantAgeEditText.getText().toString());
        // plantImageID is set when user finished with the picture button screen

        if (plantInstance == null) { // Making new Plant TODO... Fix description
            plantInstance = new Plant(plantName, plantAge,"placeholder", plantImageID,  plantBreed);
        } else { // Editing existing Plant Object
            plantInstance.setPlantName(plantName);
            // plant type is enforced and cannot be changed
            plantInstance.setAge(plantAge);
            plantInstance.setImageID(plantImageID);
        }

        // Sending user back to main page
        Intent goToMainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(goToMainActivityIntent);
    }
}