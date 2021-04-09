package com.example.plantmanager;

public class PlantDBInterface {
}

//
//@Database (entities = Plants.class, exportSchema = false, version = 1)
//public abstract class PlantsDatabase extends RoomDatabase {
//    private static final String DB_NAME = "plants_db";
//    private static PlantsDatabase instance;
//
//    public static synchronized PlantsDatabase getInstance(Context context){
//        if (instance == null){
//            instance = Room.databaseBuilder(context.getApplicationContext(), PlantsDatabase.class, DB_NAME).fallbacktoDestructiveMigration().build();
//
//        }
//        return instance;
//    }
//    public abstract PlantsDAO plantsDAO();
//}

//@Dao
//
//public interface PersonDao {
//    @Query("select plant")
//    List<Plant> getPlantList();
//    @insert
//    void insertPlant(Plant plant);
//    @update
//    void updatePlant(Plant plant);
//    @delete
//    void deletePlant(Plant plant);
//}