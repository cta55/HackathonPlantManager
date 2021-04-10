package com.example.plantmanager;

import android.content.*;
import androidx.room.*;
import androidx.room.TypeConverters;

@Database (entities = {Plant.class}, exportSchema = false, version = 1)
@TypeConverters({com.example.plantmanager.TypeConverters.class})
public abstract class PlantDB extends RoomDatabase{
    private static final String DB_NAME = "plants_db";
    private static PlantDB instance;

    public static synchronized PlantDB getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), PlantDB.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract PlantDBInterface plantDBInterface();
}
