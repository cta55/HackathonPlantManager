package com.example.plantmanager.layouts;

import android.os.Bundle;

import com.example.plantmanager.layouts.fragments.HeaderFragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.plantmanager.R;

public class MyPlantsActivity extends AppCompatActivity {

    HeaderFragment headerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plants);





    }
}