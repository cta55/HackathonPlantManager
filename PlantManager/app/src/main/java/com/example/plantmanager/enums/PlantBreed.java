package com.example.plantmanager.enums;

public enum PlantBreed {
    MONSTERA ("Monstera", PlantTypes.ARACEAE, SunlightLevel.MEDIUM_SUNLIGHT, WaterLevel.MEDIUM_WATER),
    DEVILS_IVY ("Devil's Ivy", PlantTypes.ARACEAE, SunlightLevel.LOW_SUNLIGHT, WaterLevel.LOW_WATER),
    BLUE_MYRTLE_CACTUS ("Blue Myrtle Cactus", PlantTypes.CACTACEAE, SunlightLevel.HIGH_SUNLIGHT, WaterLevel.NO_WATER),
    PEACE_LILY ("Peace Lily", PlantTypes.ARACEAE, SunlightLevel.HIGH_SUNLIGHT, WaterLevel.MEDIUM_WATER),
    SPDIER_PLANT ("Spider Plant", PlantTypes.ASPARAGACEAE, SunlightLevel.MEDIUM_SUNLIGHT, WaterLevel.MEDIUM_WATER);


    private final String name;
    private final PlantTypes plantType;
    private final SunlightLevel sunlightLevel;
    private final WaterLevel waterLevel;

    PlantBreed(String name, PlantTypes type, SunlightLevel sun, WaterLevel water) {
        this.name = name;
        this.plantType = type;
        this.sunlightLevel = sun;
        this.waterLevel = water;
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
}








