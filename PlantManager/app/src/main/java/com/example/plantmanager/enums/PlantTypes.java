package com.example.plantmanager.enums;

public enum PlantTypes {
    ARACEAE ("Araceae", 0), // TODO... put actual images here
    ASPARAGACEAE ("Asparagaceae", 1),
    CACTACEAE ("Cactaceae", 2);


    private final String name;

    PlantTypes(String s) {
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

