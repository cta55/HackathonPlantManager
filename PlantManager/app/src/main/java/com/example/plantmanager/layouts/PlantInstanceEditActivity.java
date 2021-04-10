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

public class PlantInstanceEditActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String PLANT_BREED_KEY = "plant_type";
    private static final String PLANT_ID_KEY = "plant_id";

    private HeaderFragment headerFragment;
    private FooterButtonFragment footerButtonFragment;


    private ListenerViewModel listenerViewModel;

    private EditText plantNameEditText;
    private TextView plantTypeTextView;
    private EditText plantAgeEditText;
    private ImageButton plantImageButton;

    private int plantID;
    private String plantName;
    private PlantBreed plantBreed;
    private int plantAge;
    private int plantImageID;

    private Plant plantInstance;
    private PlantDBInterface plantDBInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_instance_edit);

        plantDBInterface = PlantDB.getInstance(this).plantDBInterface();

        // ---------- Fragments -------------------------
        headerFragment = HeaderFragment.newHeader(getString(R.string.plant_instance_edit_activity_header_text));
        footerButtonFragment = FooterButtonFragment.newFooter(getString(R.string.plant_instance_edit_activity_footer_button_fragment_text));

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.plantInstanceEditHeaderFragmentContainerView, headerFragment)
                .add(R.id.plantInstanceEditFooterButtonFragmentContainerView, footerButtonFragment)
                .commit();

        // ----------- View Models ------------------

        listenerViewModel = new ViewModelProvider(this).get(ListenerViewModel.class);
        listenerViewModel.setListener(this);

        // ------------ Views --------------
        plantNameEditText = null; // TODO...
        plantTypeTextView = findViewById(R.id.plantInstanceEditTypeDetailValueView);
        plantAgeEditText = findViewById(R.id.plantInstanceEditAgeDetailEditTextNumber);
        plantImageButton = findViewById(R.id.plantInstanceEditImageButtonView);

        if (savedInstanceState == null) {
            throw new RuntimeException("Cannot start PlantInstanceEditActivity without bundle");
        } else if ((plantID = savedInstanceState.getInt(PLANT_ID_KEY)) != 0) {

            // plantID set in if statement
            plantInstance = plantDBInterface.getPlant(plantID);
            plantName = plantInstance.getPlantName();
            plantBreed = plantInstance.getPlantBreed();
            plantAge = plantInstance.getAge();
            plantImageID = plantInstance.getImageID();

        } else if ((plantBreed = (PlantBreed) savedInstanceState.getSerializable(PLANT_BREED_KEY)) != null) {

            plantID = 0;
            plantInstance = null;
            plantName = getString(R.string.default_plant_instance_name_text);
            // plantType set in if statement
            plantAge = Integer.parseInt(getString(R.string.default_plant_instance_age_value));
            plantImageID = plantBreed.getImageID();

        } else {
            throw new RuntimeException("No type or plant ID passed to PlantInstanceEditActivity");
        }

        plantNameEditText.setText(plantName);
        plantTypeTextView.setText(plantBreed.name());
        plantAgeEditText.setText(plantAge);
        plantImageButton.setImageResource(plantImageID);
    }

    @Override
    public void onClick(View view) { // TODO... Handle image button press

        plantName = plantNameEditText.getText().toString();
        // plantType is enforced and cannot be changed from this screen
        plantAge = Integer.parseInt(plantAgeEditText.getText().toString());
        // plantImageID is set when user finished with the picture button screen

        if (plantInstance == null) {
            plantInstance = new Plant(plantName, plantBreed, plantAge, plantImageID);
        } else {
            plantInstance.setPlantName(plantName);
            // plant type is enforced and cannot be changed
            plantInstance.setAge(plantAge);
            plantInstance.setImageID(plantImageID);
        }

        Intent goToMainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(goToMainActivityIntent);
    }
}