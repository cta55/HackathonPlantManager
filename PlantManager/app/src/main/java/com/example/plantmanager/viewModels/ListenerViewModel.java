package com.example.plantmanager.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListenerViewModel extends ViewModel {

    private final MutableLiveData<View.OnClickListener> listenerMutableLiveData;

    public ListenerViewModel() {
        listenerMutableLiveData = new MutableLiveData<>();
    }

    public void setListener(View.OnClickListener listener) {
        listenerMutableLiveData.setValue(listener);
    }
    public View.OnClickListener getListener(int plantID) {
        return listenerMutableLiveData.getValue();
    }

}
