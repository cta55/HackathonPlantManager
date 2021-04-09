package com.example.plantmanager.fragments;

import android.view.View;

import androidx.lifecycle.ViewModel;

public class ListenerViewModel extends ViewModel {

    private final View.OnClickListener listener;

    public ListenerViewModel(View.OnClickListener listener) {
        this.listener = listener;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

}
