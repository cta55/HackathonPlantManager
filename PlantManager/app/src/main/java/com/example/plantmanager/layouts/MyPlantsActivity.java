package com.example.plantmanager.layouts;

import android.content.Intent;
import android.os.Bundle;

import com.example.plantmanager.Plant;
import com.example.plantmanager.PlantDB;
import com.example.plantmanager.layouts.fragments.FooterButtonFragment;
import com.example.plantmanager.layouts.fragments.GridSpacingItemDecoration;
import com.example.plantmanager.layouts.fragments.HeaderFragment;
import com.example.plantmanager.layouts.fragments.ItemOffsetDecoration;
import com.example.plantmanager.layouts.fragments.PlantInstancePictureFragment;
import com.example.plantmanager.layouts.fragments.PlantPictureAdapter;
import com.example.plantmanager.layouts.fragments.RecyclerFragment;
import com.example.plantmanager.layouts.plantInstance.PlantInstanceViewActivity;
import com.example.plantmanager.viewModels.MultiListenerViewModel;
import com.example.plantmanager.viewModels.PlantImageFragmentViewModel;
import com.example.plantmanager.viewModels.PlantInstanceViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.plantmanager.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPlantsActivity extends AppCompatActivity{
    protected ViewModelProvider viewModelProvider;
    protected MultiListenerViewModel listenerViewModel;
    private PlantInstanceViewModel plantViewModel;


    private PlantImageFragmentViewModel fragmentViewModel;


    FragmentManager fragmentManager;
    HeaderFragment headerFragment;
    FooterButtonFragment footerButtonFragment;
    RecyclerFragment recyclerFragment;

    List<PlantInstancePictureFragment> plantInstancePictureFragments;
    List<Plant> myPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plants);
        fragmentManager = getSupportFragmentManager();
        myPlants = PlantDB.getInstance(this).plantDBInterface().getAll();
        plantInstancePictureFragments = new ArrayList<>();
        setupFragments();
        setupViewModels();

        RecyclerView recyclerView = findViewById(R.id.myPlantsRecyclerView);
        recyclerView.setAdapter(new PlantPictureAdapter(plantInstancePictureFragments, fragmentManager));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new ItemOffsetDecoration(this, R.dimen.grid_padding));

        putFragmentsInLayout();


    }

    private void putFragmentsInLayout() {
        fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.myPlantsHeaderFragmentContainerView, headerFragment)
                .add(R.id.myPlantsFooterButtonFragmentContainerView, footerButtonFragment)
                .commit();
    }

    private void setupFragments() {
        headerFragment = HeaderFragment.newHeader(getString(R.string.my_plants_header_text));
        footerButtonFragment = FooterButtonFragment.newFooter(getString(R.string.my_plants_footer_button_text));
        recyclerFragment = new RecyclerFragment();
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

        fragmentViewModel = viewModelProvider.get(PlantImageFragmentViewModel.class);
        fragmentViewModel.setList(plantInstancePictureFragments);

        plantViewModel = viewModelProvider.get(PlantInstanceViewModel.class);


        for (Plant plant: myPlants) {
            plantViewModel.addPlantInstance(plant.getPlantID(), plant);
        }



    }


}