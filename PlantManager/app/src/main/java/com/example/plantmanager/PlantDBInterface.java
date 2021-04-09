package com.example.plantmanager;
import androidx.room.*;
import java.util.*;

@Dao
public interface PlantDBInterface {
    @Query("SELECT * FROM plants")
    List<Plant> getAll();

    @Query("SELECT * FROM plants WHERE plantID = (:plantID)")
    List<Plant> getPlant(int plantID);

    @Insert
    void insertPlant(Plant plant);

    @Update
    void updatePlant(Plant... plant);

    @Delete
    void delete(Plant plant);
}






