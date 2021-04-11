package com.example.plantmanager;
import androidx.room.*;

import com.example.plantmanager.enums.PlantTypes;

import java.lang.annotation.Annotation;
import java.util.List;

@Dao
public interface PlantDBInterface {

    // PLANT DB QUERIES
    @Query("SELECT * FROM plants")
    List<Plant> getAll();

    @Query("SELECT * FROM plants WHERE plantID = (:plantID)")
    Plant getPlant(int plantID);

//    @Query("SELECT * FROM plants WHERE plantTypes = (:plantTypes)")
//    List<Plant> getPlantByType(PlantTypes plantTypes);

    @Insert
    long insertPlant(Plant plant);

    @Update
    void updatePlant(Plant plant);

    @Delete
    void delete(Plant plant);

}






