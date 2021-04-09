package com.example.plantmanager;
import androidx.room.*;

import com.example.plantmanager.enums.PlantTypes;

import java.util.*;

@Dao
public interface PlantDBInterface {
    @Query("SELECT * FROM plants")
    List<Plant> getAll();

    @Query("SELECT * FROM plants WHERE plantID = (:plantID)")
    List<Plant> getPlant(int plantID);

//    @Query("SELECT * FROM plants WHERE plantID = (:plantTypes)")
//    List<Plant> getPlantByType(PlantTypes plantTypes);

    @Insert
    void insertPlant(Plant plant);

    @Update
    void updatePlant(Plant plant);

    @Delete
    void delete(Plant plant);
}






