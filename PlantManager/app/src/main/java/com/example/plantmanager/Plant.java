package com.example.plantmanager;

import androidx.room.*;

import com.example.plantmanager.enums.*;


@Entity (tableName = "plants")
public class Plant {

    @PrimaryKey (autoGenerate = true)
    private int plantID;

    @ColumnInfo(name = "plant_name")
    private String plantName;

    @ColumnInfo(name = "age")
    private int age;

    @ColumnInfo(name = "image_id")
    private int imageID;

    //Foreign key

    @ColumnInfo(name = "plant_breed")
    private PlantBreed plantBreed;

    //Attributes linked to FK

//    @ColumnInfo(name = "plant_type")
//    private PlantTypes plantTypes;
//
//    @ColumnInfo(name = "water_amount")
//    private WaterLevel waterAmount;
//
//    @ColumnInfo(name = "sunlight_amount")
//    private SunlightLevel sunlightAmount;

    public Plant(PlantBreed plantBreed) {
        setPlantBreed(plantBreed);
    }

    public Plant(){

    }

    public Plant(String plantName, int age, int imageID, PlantBreed plantBreed) {
        this.plantName = plantName;
        this.age = age;
        this.imageID = imageID;
        this.plantBreed = plantBreed;
//        setPlantBreedInfo();
    }

    Notification sendWaterReminder(int timer){
        Notification waterReminder = new Notification(plantName + "Reminder", "Don't forget to water your " + plantName);
        return waterReminder;
    }

    public int getPlantID() {
        return plantID;
    }

//    public WaterLevel getWaterAmount() {
//        return waterAmount;
//    }
//
//    public SunlightLevel getSunlightAmount() {
//        return sunlightAmount;
//    }

    public int getAge() {
        return age;
    }

    public String getPlantName() {
        return plantName;
    }

//    public PlantTypes getPlantTypes() {
//        return plantTypes;
//    }

    public PlantBreed getPlantBreed() {
        return plantBreed;
    }

    public int getImageID() {
        return imageID;
    }

    public void setPlantID(int plantID){
        this.plantID = plantID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setPlantBreed(PlantBreed plantBreed) {
        this.plantBreed = plantBreed;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

//    public void setPlantBreedInfo(){
//        this.plantTypes = getPlantBreed().getPlantType();
//        this.sunlightAmount = getPlantBreed().getSunlightLevel();
//        this.waterAmount = getPlantBreed().getWaterLevel();
//    }
}
