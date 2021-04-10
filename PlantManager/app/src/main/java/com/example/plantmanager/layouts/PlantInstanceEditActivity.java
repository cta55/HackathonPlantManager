package com.example.plantmanager.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.plantmanager.Plant;
import com.example.plantmanager.R;
import com.example.plantmanager.enums.PlantTypes;
import com.example.plantmanager.layouts.fragments.FooterButtonFragment;
import com.example.plantmanager.layouts.fragments.HeaderFragment;

public class PlantInstanceEditActivity extends AppCompatActivity {

    private static final String PLANT_TYPE_KEY = "plant_type";
    private static final String PLANT_ID_KEY = "plant_id";

    private HeaderFragment headerFragment;
    private FooterButtonFragment footerButtonFragment;

    private EditText plantNameEditText;
    private TextView plantTypeTextView;
    private EditText plantAgeEditText;
    private ImageButton plantImageButton;

    private int plantID;
    private PlantTypes plantType;

    private Plant plantInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_instance_edit);

        // ---------- Fragments -------------------------
        headerFragment = HeaderFragment.newHeader(getString(R.string.plant_instance_edit_activity_header_text));
        footerButtonFragment = FooterButtonFragment.newFooter(getString(R.string.plant_instance_edit_activity_footer_button_fragment_text));

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.plantInstanceEditHeaderFragmentContainerView, headerFragment)
                .add(R.id.plantInstanceEditFooterButtonFragmentContainerView, footerButtonFragment)
                .commit();

        // ------------ Views --------------
        plantNameEditText = null; // TODO...
        plantTypeTextView = findViewById(R.id.plantInstanceEditTypeDetailValueView);
        plantAgeEditText = findViewById(R.id.plantInstanceEditAgeDetailEditTextNumber);
        plantImageButton = findViewById(R.id.plantInstanceEditImageButtonView);

        if (savedInstanceState == null) {
            throw new RuntimeException("Cannot start PlantInstanceEditActivity without bundle");
        } else if ((plantID = savedInstanceState.getInt(PLANT_ID_KEY)) != 0) {
            plantInstance = null; // TODO.... get from database
            plantType = plantInstance.getPlantTypes();

            plantNameEditText.setText(plantInstance.getPlantName());
            plantAgeEditText.setText(plantInstance.getAge());
            plantImageButton.setImageResource(plantInstance.getImageID());
        } else if ((plantType = (PlantTypes) savedInstanceState.getSerializable(PLANT_TYPE_KEY)) != null) {
            plantInstance = null; // TODO...
            plantNameEditText.setText(getString(R.string.plant_instance_edit_activity_header_text));
            plantImageButton.setImageResource(plantType.getImageID());
        }

        plantTypeTextView.setText(plantType.name());
    }
}