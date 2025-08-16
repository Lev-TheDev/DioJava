package edu.lev.collections;

import java.util.HashMap;
import java.util.Map;

public class MapGenerics {

    public static void main(String[] args) {
        Map<String, Integer> mapGenerics = new HashMap<>();
        mapGenerics.put("João", 18);
        mapGenerics.put("Maria", 20);

        // iterate over the map
        for (Map.Entry<String, Integer> entry : mapGenerics.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("Key: %s | Value: %d%n", key, value);
        }
    }
}
