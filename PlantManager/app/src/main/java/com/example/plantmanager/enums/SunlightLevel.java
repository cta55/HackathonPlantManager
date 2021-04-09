package com.example.plantmanager.enums;

import com.example.plantmanager.R;

/**
 * Basic enum for possible values of sunlight that a plant may need. Each level comes linked with
 * an image from the resources mipmap folder.
 */
public enum SunlightLevel {
    NO_SUNLIGHT(R.mipmap.ic_no_sunlight),
    LOW_SUNLIGHT(R.mipmap.ic_low_sunlight),
    MEDIUM_SUNLIGHT(R.mipmap.ic_medium_sunlight),
    HIGH_SUNLIGHT(R.mipmap.ic_high_sunlight),
    FULL_SUNLIGHT(R.mipmap.ic_full_sunlight);

    private final int imageID;

    SunlightLevel(int imageID) {
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }
}
