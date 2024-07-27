package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static test.MeasureTimeTaken.measureTimeTaken;

class HashMapComparisonTest {
    HashMap<String, Integer> map;
    HashMap<Integer, Integer> mapInt;
    ArrayList<Integer> arr;
    LinkedList<Integer> list;

    @BeforeEach
    void setup(){
        map = new HashMap<>();
        arr = new ArrayList<>();
        list = new LinkedList<>();
        mapInt = new HashMap<>();
    }

    @Test
    void numericKeys() {
        addNKeys(mapInt, 10);

        System.out.println(map);
    }

    @Test
    void stringKeys(){
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);

        System.out.println(map);
    }

    @Test
    void timeRetrieval10() {
        addNItems(arr, 10);
        addNItems(list, 10);
        addNKeys(mapInt, 10);
        System.out.println("10 Items");
        measureTimeTaken("HashMap -- Retrieving one item", () -> map.get("5"));
        measureTimeTaken("Array -- Retrieving one item", () -> arr.get(5));
        measureTimeTaken("Linked List -- Retrieving one item", () -> list.get(5));
        System.out.println();
    }

    @Test
    void timeRetrieval1000000(){
        addNItems(arr, 1000000);
        addNItems(list, 1000000);
        addNKeys(mapInt, 1000000);
        System.out.println("1000000 Items");
        measureTimeTaken("HashMap -- Retrieving one item", () -> map.get("500000"));
        measureTimeTaken("Array -- Retrieving one item", () -> arr.get(500000));
        measureTimeTaken("Linked List -- Retrieving one item", () -> list.get(500000));
        System.out.println();
    }

    @Test
    void timeAdding10(){
        measureTimeTaken("HashMap -- Adding 10 items", () -> addNKeys(mapInt, 10));
        measureTimeTaken("Array -- Adding 10 items", () -> addNItems(arr, 10));
        measureTimeTaken("Linked List -- Adding 10 items", () -> addNItems(list, 10));
    }

    @Test
    void timeAdding100(){
        measureTimeTaken("HashMap -- Adding 100 items", () -> addNKeys(mapInt, 100));
        measureTimeTaken("Array -- Adding 100 items", () -> addNItems(arr, 100));
        measureTimeTaken("Linked List -- Adding 100 items", () -> addNItems(list, 100));
    }

    @Test
    void timeAdding1000000(){
        measureTimeTaken("HashMap -- Adding 1,000,000 items", () -> addNKeys(mapInt, 1000000));
        measureTimeTaken("Array -- Adding 1,000,000 items", () -> addNItems(arr, 1000000));
        measureTimeTaken("Linked List -- Adding 1,000,000 items", () -> addNItems(list, 1000000));
    }

    void addNItems(List<Integer> list, int n) {
        for (int i = 0; i<n; i++){
            list.add(i);
        }
    }

    void addNKeys(HashMap<Integer, Integer>map, int n){
        for (int i = 0; i < n; i++) {
            map.put(i, i);
        }
    }


}
