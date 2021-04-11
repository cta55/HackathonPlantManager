package com.example.plantmanager.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;

public class MultiListenerViewModel extends ListenerViewModel {

    private final MutableLiveData<Map<Integer, View.OnClickListener>> listenerData;

    public MultiListenerViewModel() {
        listenerData = new MutableLiveData<>();
        listenerData.setValue(new HashMap<Integer, View.OnClickListener>());
    }

    public void addMap(Map<Integer, View.OnClickListener> map) {
        listenerData.getValue().putAll(map);
    }

    @Override
    public View.OnClickListener getListener(int plantID) {
        // Map<Integer, View.OnClickListener> testMap = listenerData.getValue();
        return listenerData.getValue().get(plantID);
    }



}
