package com.example.plantmanager.enums;

import com.example.plantmanager.R;

public enum WaterLevel {
    NO_WATER(R.drawable.water_empty_foreground),
    LOW_WATER(R.drawable.water_half_empty_foreground),
    MEDIUM_WATER(R.drawable.water_half_foreground),
    HIGH_WATER(R.drawable.water_half_full_foreground),
    FULL_WATER(R.drawable.water_full_foreground);


    private final int imageID;

    WaterLevel(int imageID) {
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }
}
