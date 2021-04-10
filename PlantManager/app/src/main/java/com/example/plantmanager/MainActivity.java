package com.example.plantmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        PlantDB plantDatabaseOject = Room.databaseBuilder(getApplicationContext(), PlantDB.class, "plant_db").build();
//
//        Plant plant = plantDatabaseOject.getPlant(1);
    }
}