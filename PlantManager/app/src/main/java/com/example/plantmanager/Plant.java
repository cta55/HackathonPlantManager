package com.example.plantmanager;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.plantmanager.enums.*;


@Entity (tableName = "plants")
public class Plant {

    @PrimaryKey (autoGenerate = true)
    private int plantID;
    private String plantName;
    private int age;
    private String description;
    private int imageID;

    //Foreign key
    private PlantBreed plantBreed;

    //Attributes linked to FK
    private PlantTypes plantTypes;
    private WaterLevel waterAmount;
    private SunlightLevel sunlightAmount;

    public Plant(PlantBreed plantBreed) {
        setPlantBreed(plantBreed);
    }

    public Plant(int plantID, String plantName, int age, String description, int imageID, PlantBreed plantBreed, PlantTypes plantTypes, WaterLevel waterAmount, SunlightLevel sunlightAmount) {
        this.plantID = plantID;
        this.plantName = plantName;
        this.age = age;
        this.description = description;
        this.imageID = imageID;
        this.plantBreed = plantBreed;
        this.plantTypes = plantTypes;
        this.waterAmount = waterAmount;
        this.sunlightAmount = sunlightAmount;
    }

    Notification sendWaterReminder(int timer){
        Notification waterReminder = new Notification(plantName + "Reminder", "Don't forget to water your " + plantName);
        return waterReminder;
    }

    public int getPlantID() {
        return plantID;
    }

    public WaterLevel getWaterAmount() {
        return waterAmount;
    }

    public SunlightLevel getSunlightAmount() {
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

    public int getImageID() {
        return imageID;
    }

    public void setPlantID(int plantID){
        this.plantID = plantID;
    }

    public void setWaterAmount(WaterLevel waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void setSunlightAmount(SunlightLevel sunlightAmount) {
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

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
