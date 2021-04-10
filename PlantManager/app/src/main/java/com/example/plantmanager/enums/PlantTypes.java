package com.example.plantmanager.enums;

public enum PlantTypes {
    BRYOPHYTE ("Bryophyte", 0), // TODO... put actual images here
    PTERIDOPHYTE ("Pteridophyte", 1),
    GYMNOSPERM ("Gymnosperm", 2),
    ANGIOSPERM ("Angiosperm", 3);

    private final String name;
    private final int imageID;

    PlantTypes(String s, int imageID) {
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

