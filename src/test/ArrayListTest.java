package test;

import main.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static test.MeasureTimeTaken.measureTimeTaken;

class MyArrayListTest {
    MyArrayList array;

    @BeforeEach
    void setup() {
        array = new MyArrayList();
    }

    @Test
    void constructor() {
        assertEquals(0, array.size());
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));
        MyArrayList arrayCap = new MyArrayList(2);
        assertEquals(0, arrayCap.size());
        assertThrows(IndexOutOfBoundsException.class, () -> arrayCap.get(0));
    }

    @Test
    void add() {
        array.add(0);
        assertEquals(1, array.size());
        assertEquals(0, array.get(0));
        array.add(5);
        assertEquals(2, array.size());
        assertEquals(5, array.get(1));
        assertEquals(0, array.get(0));
    }

    @Test
    void addWhenFull() {
        MyArrayList array = new MyArrayList(1);
        array.add(1);
        array.add(2);
        assertEquals(2, array.get(1));
        assertEquals(2, array.size());

    }

    @Test
    void addAtIndex() {
        array.add(1, 0);
        assertEquals(1, array.size());
        assertEquals(1, array.get(0));
        array.add(0, 0);
        assertEquals(2, array.size());
        assertEquals(0, array.get(0));
        assertEquals(1, array.get(1));
        array.add(2, 1);
        assertEquals(3, array.size());
        assertEquals(0, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(1, array.get(2));
    }

    @Test
    void addAtIndexWhenFull() {
        MyArrayList array = new MyArrayList(1);
        array.add(1, 0);
        array.add(0, 0);
        assertEquals(2, array.size());
        assertEquals(0, array.get(0));
        assertEquals(1, array.get(1));
    }

    @Test
    void addAtIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(1, 1));
    }

    @Test
    void remove() {
        array.add(1);
        assertEquals(1, array.get(0));
        assertEquals(1, array.size());
        array.remove(0);
        assertEquals(0, array.size());
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));
    }

    @Test
    void removeThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(0));
    }

    @Test
    void get() {
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));
        array.add(1);
        assertEquals(1, array.get(0));
    }

    @Test
    void timeAddingElements() {
        measureTimeTaken("Adding 1000 elements to end", () -> add1000ToEnd(array));
        measureTimeTaken("Adding 1000 elements to middle (incrementing index)", () -> add1000ToMiddleInc(array));
        measureTimeTaken("Adding 1000 elements to middle (static index)", () -> add1000ToMiddleStatic(array));
        measureTimeTaken("Adding 1000 elements to beginning", () -> add1000ToBeginning(array));
    }

    void add1000ToEnd(MyArrayList arr) {
        for (int i = 0; i < 1000; i++) {
            arr.add(i);
        }
    }

    void add1000ToMiddleInc(MyArrayList arr) {
        int index = 5;
        for (int i = 0; i < 1000; i++) {
            arr.add(i, index);
        }
    }

    void add1000ToMiddleStatic(MyArrayList arr) {
        for (int i = 0; i < 1000; i++) {
            arr.add(i, 5);
        }
    }

    void add1000ToBeginning(MyArrayList arr) {
        for (int i = 0; i < 1000; i++) {
            arr.add(i, 0);
        }
    }

}