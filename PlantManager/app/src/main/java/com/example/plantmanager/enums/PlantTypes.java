package com.example.plantmanager.enums;

public enum PlantTypes {
    BRYOPHYTE ("Bryophyte"),
    PTERIDOPHYTE ("Pteridophyte"),
    GYMNOSPERM ("Gymnosperm"),
    ANGIOSPERM ("Angiosperm");

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

