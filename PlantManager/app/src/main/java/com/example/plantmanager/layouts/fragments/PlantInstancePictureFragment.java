package com.example.plantmanager.layouts.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plantmanager.Plant;
import com.example.plantmanager.R;
import com.example.plantmanager.viewModels.ListenerViewModel;
import com.example.plantmanager.viewModels.PlantInstanceViewModel;

/**
 * Fragment that handles the square image buttons that appear on the "my plants" main page.
 * Contains a single large image button that gets it's onClickListener from the ListenerViewModel,
 * Two enum based images representing the plant's status, and the plant's name as text.
 */
public class PlantInstancePictureFragment extends Fragment {

    // Key for plant ID
    private static final String PLANT_INSTANCE_ID_KEY = "plant_instance_id";

    // View models
    private PlantInstanceViewModel plantViewModel;
    private ListenerViewModel listenerViewModel;

    // Plant object that this fragment represents
    private int plantInstanceID;
    private Plant plantInstance;

    // Fragment views
    private ImageButton plantPictureButton;
    private ImageView plantWaterImageView;
    private ImageView plantSunlightImageView;
    private TextView plantNameTextView;


    /**
     * Public constructor needed for Fragment extensions. SHOULDN'T BE USED DIRECTLY!
     */
    public PlantInstancePictureFragment() {}

    /**
     * Static method for generating fragments with a specific plant ID bundled in
     * @param plantInstanceID : The ID of the plant instance
     * @return : A fragment bundled with a plant ID
     */
    public static PlantInstancePictureFragment newPlantInstancePicture(int plantInstanceID) {
        PlantInstancePictureFragment fragment = new PlantInstancePictureFragment();
        Bundle args = new Bundle();
        args.putInt(PLANT_INSTANCE_ID_KEY, plantInstanceID);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Basic View method, gets plant ID from the bundle and saves it to variable
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            plantInstanceID = getArguments().getInt(PLANT_INSTANCE_ID_KEY);
        } else {
            throw new RuntimeException("No plant ID passed to Plant Instance Picture Fragment");
        }
    }

    /**
     * Basic Fragment method, gets fragment views from ID
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_plant_instance_picture, container, false);
        // Getting views
        plantPictureButton = root.findViewById(R.id.plantInstancePictureButton);
        plantWaterImageView = root.findViewById(R.id.plantInstanceWaterImageView);
        plantSunlightImageView = root.findViewById(R.id.plantInstanceSunlightImageView);
        plantNameTextView = root.findViewById(R.id.plantInstanceNameTextView);
        return root;
    }

    /**
     * Basic Fragment method, gets data from View Models and uses it to set up fragment views.
     */
    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Getting the button listener from the Listener view model
        listenerViewModel = new ViewModelProvider(requireActivity()).get(ListenerViewModel.class);
        plantPictureButton.setOnClickListener(listenerViewModel.getListener());

        // Getting the Plant from the Plant view model
        plantViewModel = new ViewModelProvider(requireActivity()).get(PlantInstanceViewModel.class);
        plantInstance = plantViewModel.getPlantInstance(plantInstanceID);

        // Applying data from Plant object
        plantPictureButton.setImageResource(plantInstance.getImageID());
        plantWaterImageView.setImageResource(plantInstance.getWaterAmount().getImageID());
        plantSunlightImageView.setImageResource(plantInstance.getSunlightAmount().getImageID());
        plantNameTextView.setText(plantInstance.getPlantName());
    }
}