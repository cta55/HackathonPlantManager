package com.example.plantmanager.dummy;

import com.example.plantmanager.enums.PlantBreed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;


public class PlantTypeObject {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<PlantBreed> ITEMS = asList(PlantBreed.values());

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, PlantBreed> ITEM_MAP = new HashMap<String, PlantBreed>();

    static {
        // Add some sample items.
        for (int i = 1; i < ITEMS.size(); i++) {
            addItem(ITEMS.get(i), Integer.toString(ITEMS.get(i).getImageID()));
        }
    }

    private static void addItem(PlantBreed item, String id) {
        ITEM_MAP.put(id, item);
    }

}