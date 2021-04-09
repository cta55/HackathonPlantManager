package com.example.plantmanager;

import android.media.Image;

import java.util.HashMap;

public class PlantMap {

    private HashMap<Integer, Plant> plantMap = new HashMap();
    private String mapName;
    private String mapDesc;
    private String mapLocation;
    private Image mapImage;

    public PlantMap(String mapName, String mapDesc) {
        setMapName(mapName);
        setMapDesc(mapDesc);
    }

    public HashMap<Integer, Plant> getPlantMap() {
        return plantMap;
    }

    public void addToMap(Plant plantToAdd){
        getPlantMap().put(plantToAdd.getPlantID(), plantToAdd);
    }

    public void removeFromMap(Plant plantToRemove){
        getPlantMap().remove(plantToRemove.getPlantID());
    }

    public Plant getFromMap(int plantID){
        Plant plantToReturn;
        plantToReturn = getPlantMap().get(plantID);

        return plantToReturn;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getMapDesc() {
        return mapDesc;
    }

    public void setMapDesc(String mapDesc) {
        this.mapDesc = mapDesc;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    public Image getMapImage() {
        return mapImage;
    }

    public void setMapImage(Image mapImage) {
        this.mapImage = mapImage;
    }
}
