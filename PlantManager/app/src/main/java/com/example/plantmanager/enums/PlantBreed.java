package com.example.plantmanager.enums;

import com.example.plantmanager.R;

public enum PlantBreed {
    MONSTERA ("Monstera", R.string.monsteraDesc, PlantTypes.ARACEAE, SunlightLevel.MEDIUM_SUNLIGHT, WaterLevel.MEDIUM_WATER, R.drawable.monstera_foreground),
    DEVILS_IVY ("Devil's Ivy", R.string.devilsIvyDesc, PlantTypes.ARACEAE, SunlightLevel.LOW_SUNLIGHT, WaterLevel.LOW_WATER, R.drawable.devils_ivy_foreground),
    BLUE_MYRTLE_CACTUS ("Blue Myrtle Cactus", R.string.blueMyrtleCactusDesc, PlantTypes.CACTACEAE, SunlightLevel.HIGH_SUNLIGHT, WaterLevel.NO_WATER, R.drawable.blue_myrtle_cactus_foreground),
    PEACE_LILY ("Peace Lily", R.string.peaceLilyDesc,  PlantTypes.ARACEAE, SunlightLevel.HIGH_SUNLIGHT, WaterLevel.MEDIUM_WATER, R.drawable.peace_lily_foreground),
    SPIDER_PLANT("Spider Plant", R.string.spiderPlantDesc, PlantTypes.ASPARAGACEAE, SunlightLevel.MEDIUM_SUNLIGHT, WaterLevel.MEDIUM_WATER, R.drawable.spider_plant_foreground);


    private final String name;

    //Description is stored as an int, referencing res/values/strings.xml
    private final int descriptionID;
    private final PlantTypes plantType;
    private final SunlightLevel sunlightLevel;
    private final WaterLevel waterLevel;
    private final int imageID;

    PlantBreed(String name, int desc, PlantTypes type, SunlightLevel sun, WaterLevel water, int imageID) {
        this.name = name;
        this.descriptionID = desc;
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

    public int getDescriptionID() {
        return descriptionID;
    }

    //Descriptions
}








