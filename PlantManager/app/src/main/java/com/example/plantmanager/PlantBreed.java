package com.example.plantmanager;

public enum PlantBreed {
    MONSTERA ("Monstera"),
    DEVILS_IVY ("Devil's Ivy"),
    DRAGONS_TAIL ("Dragon's Tail"),
    PEACE_LILY ("Peace Lily"),
    SPDIER_PLANT ("Spider Plant");

    private final String name;

    private PlantBreed(String s) {
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








