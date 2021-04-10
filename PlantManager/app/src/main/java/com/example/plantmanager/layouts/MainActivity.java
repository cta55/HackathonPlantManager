package com.example.plantmanager.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.plantmanager.PlantDB;
import com.example.plantmanager.R;
import com.example.plantmanager.enums.PlantBreed;
import com.example.plantmanager.layouts.plantInstance.PlantInstanceEditActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myPlantsButton = findViewById(R.id.MyPlantsButton);
        Button plantsDatabaseButton = findViewById(R.id.PlantDatabaseButton);

        myPlantsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent testGoToPlantEditorIntent = new Intent(v.getContext(), PlantInstanceEditActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(getString(R.string.plant_breed_key), PlantBreed.BLUE_MYRTLE_CACTUS);
                testGoToPlantEditorIntent.putExtra("testBundle", bundle);
                startActivity(testGoToPlantEditorIntent);



//                Intent myPlantsIntent = new Intent(this, );
//                startActivity(myPlantsIntent);
            }
        });

        plantsDatabaseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent plantsSearchIntent = new Intent(v.getContext(), PlantTypeListActivity.class);
                startActivity(plantsSearchIntent);
            }
        });
    }
}