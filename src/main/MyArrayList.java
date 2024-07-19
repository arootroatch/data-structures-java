package main;

import java.util.Arrays;
import java.util.Objects;
//import jdk.internal.util.ArraysSupport;

public class MyArrayList implements MyList<Integer> {

    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
    }

    public MyArrayList(int capacity) {
        array = new Object[capacity];
    }

    public void add(int i) {
        int oldCapacity = array.length;
        if (size == oldCapacity) {
            int newCapacity = oldCapacity + 1;
            array = Arrays.copyOf(array, newCapacity);
        }
        int index = size;
        array[index] = i;
        size++;
    }

    public void add(int i, int index) {
        array[index] = i;
        size++;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {

    }

    public int get(int index) {
        Objects.checkIndex(index, size);
        return (int) array[index];
    }
}