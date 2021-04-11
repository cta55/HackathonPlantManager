package com.example.plantmanager.layouts;

import android.os.Bundle;

import com.example.plantmanager.Plant;
import com.example.plantmanager.PlantDB;
import com.example.plantmanager.PlantDBInterface;
import com.example.plantmanager.layouts.fragments.FooterButtonFragment;
import com.example.plantmanager.layouts.fragments.HeaderFragment;
import com.example.plantmanager.layouts.fragments.PlantInstancePictureFragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.plantmanager.R;

import java.util.ArrayList;
import java.util.List;

public class MyPlantsActivity extends AppCompatActivity {

    HeaderFragment headerFragment;
    FooterButtonFragment footerButtonFragment;
    List<PlantInstancePictureFragment> plantInstancePictureFragments;
    List<Plant> myPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plants);

        myPlants = PlantDB.getInstance(this).plantDBInterface().getAll();
        setupFragments();



    }

    private void setupFragments() {
        headerFragment = HeaderFragment.newHeader(getString(R.string.my_plants_header_text));
        footerButtonFragment = FooterButtonFragment.newFooter(getString(R.string.my_plants_footer_button_text));
        for (Plant plant: myPlants) {
            plantInstancePictureFragments.add(PlantInstancePictureFragment.newPlantInstancePicture(plant.getPlantID()));
        }
    }
}