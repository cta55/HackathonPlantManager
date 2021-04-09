package com.example.plantmanager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "plants")
public class Plant {

    @PrimaryKey (autoGenerate = true)
    private int plantID;
    private String plantName;
    private int age;
    private String description;

    //Foreign key
    private PlantBreed plantBreed;

    //Attributes linked to FK
    private PlantTypes plantTypes;
    private int waterAmount;
    private int sunlightAmount;

    public Plant(PlantBreed plantBreed) {
        setPlantBreed(plantBreed);

    }

    Notification sendWaterReminder(int waterAmount){
        Notification waterReminder = new Notification("Reminder", "Don't forget to water your " + plantName);
        return waterReminder;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getSunlightAmount() {
        return sunlightAmount;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public String getPlantName() {
        return plantName;
    }

    public PlantTypes getPlantTypes() {
        return plantTypes;
    }

    public PlantBreed getPlantBreed() {
        return plantBreed;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void setSunlightAmount(int sunlightAmount) {
        this.sunlightAmount = sunlightAmount;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setPlantTypes(PlantTypes plantTypes) {
        this.plantTypes = plantTypes;
    }

    public void setPlantBreed(PlantBreed plantBreed) {
        this.plantBreed = plantBreed;
    }

}
