package com.example.plantmanager.enums;

public enum WaterStage {
    NO_WATER ("No further watering is required"),
    LITTLE_WATER ("Water it a little"),
    LOTS_OF_WATER("Water it a lot");


    private final String name;

    private WaterStage(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
