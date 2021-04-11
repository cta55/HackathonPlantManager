package com.example.plantmanager.layouts;

import android.content.Intent;
import android.os.Bundle;

import com.example.plantmanager.Plant;
import com.example.plantmanager.PlantDB;
import com.example.plantmanager.PlantDBInterface;
import com.example.plantmanager.layouts.fragments.FooterButtonFragment;
import com.example.plantmanager.layouts.fragments.HeaderFragment;
import com.example.plantmanager.layouts.fragments.PlantInstancePictureFragment;
import com.example.plantmanager.layouts.plantInstance.PlantInstanceViewActivity;
import com.example.plantmanager.viewModels.ListenerViewModel;
import com.example.plantmanager.viewModels.MultiListenerViewModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;

import com.example.plantmanager.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPlantsActivity extends AppCompatActivity{
    protected ViewModelProvider viewModelProvider;
    protected MultiListenerViewModel listenerViewModel;

    HeaderFragment headerFragment;
    FooterButtonFragment footerButtonFragment;
    List<PlantInstancePictureFragment> plantInstancePictureFragments;
    List<Plant> myPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plants);

        myPlants = PlantDB.getInstance(this).plantDBInterface().getAll();
        plantInstancePictureFragments = new ArrayList<>();
        setupFragments();
        setupViewModels();


    }

    private void setupFragments() {
        headerFragment = HeaderFragment.newHeader(getString(R.string.my_plants_header_text));
        footerButtonFragment = FooterButtonFragment.newFooter(getString(R.string.my_plants_footer_button_text));
        for (Plant plant: myPlants) {
            plantInstancePictureFragments.add(PlantInstancePictureFragment.newPlantInstancePicture(plant.getPlantID()));
        }
    }

    private void setupViewModels() {
        viewModelProvider = new ViewModelProvider(this);
        listenerViewModel = viewModelProvider.get(MultiListenerViewModel.class);

        Map<Integer, View.OnClickListener> map = new HashMap<>();

        map.put(0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSearch = new Intent(v.getContext(), PlantTypeListActivity.class);
                startActivity(goToSearch);
            }
        });

        for (final Plant plant: myPlants) {
            map.put(plant.getPlantID(), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goToPlant = new Intent(v.getContext(), PlantInstanceViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt(getString(R.string.plant_id_key), plant.getPlantID());
                    goToPlant.putExtra(getString(R.string.plant_instance_bundle_key), bundle);
                    startActivity(goToPlant);
                }
            });
        }
        listenerViewModel.addMap(map);
    }


}