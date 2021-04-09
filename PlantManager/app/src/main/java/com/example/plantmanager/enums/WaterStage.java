package com.example.plantmanager.enums;

public enum WaterStage {
    NO_WATER(0),
    LOW_WATER(1),
    MEDIUM_WATER(2),
    HIGH_WATER(3),
    FULL_WATER(4);


    private final int imageID;

    WaterStage(int imageID) {
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }
}
