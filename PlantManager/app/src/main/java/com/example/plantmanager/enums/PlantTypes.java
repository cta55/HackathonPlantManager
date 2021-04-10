package com.example.plantmanager.enums;

public enum PlantTypes {
    ARACEAE ("Araceae", 0), // TODO... put actual images here
    ASPARAGACEAE ("Asparagaceae", 1),
    CACTACEAE ("Cactaceae", 2);


    private final String name;
    private final int imageid;


    PlantTypes(String s, int imageid) {
        this.name = s;
        this.imageid = imageid;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}

