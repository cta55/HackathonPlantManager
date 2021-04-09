package com.example.plantmanager;

import androidx.room.*;
import com.example.plantmanager.enums.*;

public class TypeConverters {


    //PlantType Converters
    @TypeConverter
    public static PlantTypes stringToPlantType(String databaseValue) {
        return databaseValue == null ? null : PlantTypes.valueOf(databaseValue);
    }

    @TypeConverter
    public static String plantBreedToString(PlantTypes plantType) {
        return plantType == null ? null : plantType.toString();
    }

    //PlantBreed Converters
    @TypeConverter
    public static PlantBreed stringToPlantBreed(String databaseValue) {
        return databaseValue == null ? null : PlantBreed.valueOf(databaseValue);
    }

    @TypeConverter
    public static String plantBreedToString(PlantBreed plantBreed) {
        return plantBreed == null ? null : plantBreed.toString();
    }

    //WaterStage Converters
    @TypeConverter
    public static WaterLevel stringToWaterStage(String databaseValue) {
        return databaseValue == null ? null : WaterLevel.valueOf(databaseValue);
    }

    @TypeConverter
    public static String waterStageToString(WaterLevel waterLevel) {
        return waterLevel == null ? null : waterLevel.toString();
    }

    //SunlightLevel Converters
    @TypeConverter
    public static SunlightLevel stringToSunlightLevel(String databaseValue) {
        return databaseValue == null ? null : SunlightLevel.valueOf(databaseValue);
    }

    @TypeConverter
    public static String sunlightLevelToString(SunlightLevel sunlightLevel) {
        return sunlightLevel == null ? null : sunlightLevel.toString();
    }
}
