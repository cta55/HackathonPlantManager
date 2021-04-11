package com.example.plantmanager.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantmanager.layouts.fragments.PlantInstancePictureFragment;

import java.util.ArrayList;
import java.util.List;

public class PlantImageFragmentViewModel extends ViewModel {

    private final MutableLiveData<List<PlantInstancePictureFragment>> data;

    public PlantImageFragmentViewModel() {
        data = new MutableLiveData<>();
        data.setValue(new ArrayList<PlantInstancePictureFragment>());
    }

    public void setList(List<PlantInstancePictureFragment> list) {
        data.getValue().addAll(list);
    }

    public List<PlantInstancePictureFragment> getList() {
        return data.getValue();
    }

}
