package com.example.plantmanager.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantmanager.NewPlantInstance;
import com.example.plantmanager.Plant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlantInstanceViewModel extends ViewModel {

    private final MutableLiveData<Map<Integer, Plant>> plantInstanceMapLiveData;

    public PlantInstanceViewModel() {
        this.plantInstanceMapLiveData = new MutableLiveData<>();
        plantInstanceMapLiveData.setValue(new HashMap<Integer, Plant>());
    }

    public void addPlantInstance(int plantInstanceID, Plant plantInstance) {
        plantInstanceMapLiveData.getValue().put(plantInstanceID, plantInstance);
    }

    public Plant getPlantInstance(int plantInstanceID) {
        return plantInstanceMapLiveData.getValue().get(plantInstanceID);
    }

}




