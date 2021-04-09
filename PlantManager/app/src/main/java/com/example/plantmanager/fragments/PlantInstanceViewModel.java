package com.example.plantmanager.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantmanager.NewPlantInstance;
import com.example.plantmanager.Plant;

import java.util.List;
import java.util.Map;

public class PlantInstanceViewModel extends ViewModel {

    private final MutableLiveData<Map<Integer, Plant>> plantInstanceMapLiveData;

    public PlantInstanceViewModel(Map<Integer, Plant> plantInstanceMap) {
        this.plantInstanceMapLiveData = new MutableLiveData<Map<Integer, Plant>>();
        plantInstanceMapLiveData.setValue(plantInstanceMap);
    }

    public Plant getPlantInstance(int plantInstanceID) {
        return plantInstanceMapLiveData.getValue().get(plantInstanceID);
    }

}




