package test;

import main.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static test.MeasureTimeTaken.*;

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
    void removeLast(){
        for (int i = 0; i < 10; i++){
            array.add(i);
        }
        array.remove(9);
        assertEquals(9, array.size());
        assertEquals(0, array.get(0));
        assertEquals(1, array.get(1));
        assertEquals(2, array.get(2));
        assertEquals(3, array.get(3));
        assertEquals(4, array.get(4));
        assertEquals(5, array.get(5));
        assertEquals(6, array.get(6));
        assertEquals(7, array.get(7));
        assertEquals(8, array.get(8));
    }

    @Test
    void removeMiddle(){
        for (int i = 0; i < 10; i++){
            array.add(i);
        }
        array.remove(1);
        assertEquals(9, array.size());
        assertEquals(0, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(3, array.get(2));
        assertEquals(4, array.get(3));
        assertEquals(5, array.get(4));
        assertEquals(6, array.get(5));
        assertEquals(7, array.get(6));
        assertEquals(8, array.get(7));
        assertEquals(9, array.get(8));

    }

    // [0 1 2 3 4 5 6 7 8 9]

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
}