package com.example.plantmanager.layouts;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.plantmanager.Plant;
import com.example.plantmanager.R;
import com.example.plantmanager.layouts.fragments.FooterButtonFragment;
import com.example.plantmanager.layouts.fragments.HeaderFragment;
import com.example.plantmanager.layouts.fragments.PlantInstancePictureFragment;
import com.example.plantmanager.viewModels.ListenerViewModel;
import com.example.plantmanager.viewModels.PlantInstanceViewModel;

public class PlantInstanceActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String PLANT_ID_KEY = "plant_id";

    private HeaderFragment plantInstanceHeaderFragment;
    private PlantInstancePictureFragment plantInstancePictureFragment;
    private FooterButtonFragment plantInstanceFooterButtonFragment;

    private ViewModelProvider viewModelProvider = new ViewModelProvider(this);
    private ListenerViewModel listenerViewModel;
    private PlantInstanceViewModel plantInstanceViewModel;

    private Plant plantInstance;
    private int plantID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_instance);

        plantID = savedInstanceState.getInt(PLANT_ID_KEY);
        // plantInstance = GET INSTANCE SOMEHOW TODO...

        plantInstanceHeaderFragment = HeaderFragment.newHeader(plantInstance.getPlantName());
        plantInstanceFooterButtonFragment = FooterButtonFragment.newFooter(
                getString(R.string.plant_instance_activity_footer_button_fragment_text)
        );
        plantInstancePictureFragment = PlantInstancePictureFragment.newPlantInstancePicture(
                plantID
        );

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.plantInstanceHeaderFragmentContainerView, plantInstanceHeaderFragment)
                .add(R.id.plantInstancePictureFragmentContainerView, plantInstancePictureFragment)
                .add(R.id.plantInstanceFooterButtonFragmentContainerView, plantInstanceFooterButtonFragment)
                .commit();


        listenerViewModel = viewModelProvider.get(ListenerViewModel.class);
        listenerViewModel.setListener(this);

        plantInstanceViewModel = viewModelProvider.get(PlantInstanceViewModel.class);
        plantInstanceViewModel.addPlantInstance(plantID, plantInstance);
    }

    @Override
    public void onClick(View v) {
        // TODO...
    }
}
