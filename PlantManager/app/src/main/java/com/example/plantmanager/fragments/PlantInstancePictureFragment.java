package com.example.plantmanager.fragments;

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

public class PlantInstancePictureFragment extends Fragment {

    private static final String PLANT_INSTANCE_ID_KEY = "plant_instance_id";

    private PlantInstanceViewModel plantViewModel;

    private int plantInstanceID;
    private Plant plantInstance;

    private ImageButton plantPictureButton;
    private ImageView plantWaterImageView;
    private ImageView plantSunlightImageView;
    private TextView plantNameTextView;


    private PlantInstancePictureFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PlantInstancePictureFragment newPlantInstancePicture(int plantInstanceID) {
        PlantInstancePictureFragment fragment = new PlantInstancePictureFragment();
        Bundle args = new Bundle();
        args.putInt(PLANT_INSTANCE_ID_KEY, plantInstanceID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            plantInstanceID = getArguments().getInt(PLANT_INSTANCE_ID_KEY);
        } else {
            throw new RuntimeException("No plant ID passed to Plant Instance Picture Fragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_plant_instance_picture, container, false);
        plantPictureButton = root.findViewById(R.id.plantInstancePictureButton);
        plantWaterImageView = root.findViewById(R.id.plantInstanceWaterImageView);
        plantSunlightImageView = root.findViewById(R.id.plantInstanceSunlightImageView);
        plantNameTextView = root.findViewById(R.id.plantInstanceNameTextView);
        return root;
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        plantViewModel = new ViewModelProvider(requireActivity()).get(PlantInstanceViewModel.class);
        plantInstance = plantViewModel.getPlantInstance(plantInstanceID);
    }
}