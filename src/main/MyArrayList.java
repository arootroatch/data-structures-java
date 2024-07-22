package main;

import java.util.Arrays;
import java.util.Objects;

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
        growIfFull();
        int index = size;
        array[index] = i;
        size++;
    }

    public void add(int i, int index) {
        if (index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        growIfFull();
        if (size > 0) System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = i;
        size++;
    }

    private void growIfFull() {
        int oldCapacity = array.length;
        if (size == oldCapacity) {
            int newCapacity = oldCapacity + 1;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, size - 1);
        size--;
    }

    public int get(int index) {
        Objects.checkIndex(index, size);
        return (int) array[index];
    }
}