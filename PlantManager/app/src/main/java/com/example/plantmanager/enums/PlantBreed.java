package com.example.plantmanager.enums;

public enum PlantBreed {
    MONSTERA ("Monstera", PlantTypes.ARACEAE, SunlightLevel.MEDIUM_SUNLIGHT, WaterLevel.MEDIUM_WATER, 0),
    DEVILS_IVY ("Devil's Ivy", PlantTypes.ARACEAE, SunlightLevel.LOW_SUNLIGHT, WaterLevel.LOW_WATER, 1),
    BLUE_MYRTLE_CACTUS ("Blue Myrtle Cactus", PlantTypes.CACTACEAE, SunlightLevel.HIGH_SUNLIGHT, WaterLevel.NO_WATER, 2),
    PEACE_LILY ("Peace Lily", PlantTypes.ARACEAE, SunlightLevel.HIGH_SUNLIGHT, WaterLevel.MEDIUM_WATER, 3),
    SPDIER_PLANT ("Spider Plant", PlantTypes.ASPARAGACEAE, SunlightLevel.MEDIUM_SUNLIGHT, WaterLevel.MEDIUM_WATER, 4);


    private final String name;
    private final PlantTypes plantType;
    private final SunlightLevel sunlightLevel;
    private final WaterLevel waterLevel;
    private final int imageID;

    PlantBreed(String name, PlantTypes type, SunlightLevel sun, WaterLevel water, int imageID) {
        this.name = name;
        this.plantType = type;
        this.sunlightLevel = sun;
        this.waterLevel = water;
        this.imageID = imageID;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String getName() {
        return name;
    }

    public PlantTypes getPlantType() {
        return plantType;
    }

    public SunlightLevel getSunlightLevel() {
        return sunlightLevel;
    }

    public WaterLevel getWaterLevel() {
        return waterLevel;
    }
    public int getImageID() {
        return imageID;
    }
}








