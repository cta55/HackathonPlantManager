package com.example.plantmanager.enums;

public enum PlantBreed {
    MONSTERA ("Monstera", 0), // TODO... Add actual images
    DEVILS_IVY ("Devil's Ivy", 1),
    DRAGONS_TAIL ("Dragon's Tail", 2),
    PEACE_LILY ("Peace Lily", 3),
    SPDIER_PLANT ("Spider Plant", 4);

    private final String name;
    private final int imageID;

    PlantBreed(String s, int imageID) {
        name = s;
        this.imageID = imageID;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
    public int getImageID() {
        return imageID;
    }
}








