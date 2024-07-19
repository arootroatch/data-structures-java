package test;

import main.MyArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyArrayListTest {

    @Test
    void constructor() {
        MyArrayList array = new MyArrayList();
        assertEquals(0, array.size());
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));
        MyArrayList arrayCap = new MyArrayList(2);
        assertEquals(0, arrayCap.size());
        assertThrows(IndexOutOfBoundsException.class, () -> arrayCap.get(0));
//        ArrayList<Integer> test = new ArrayList<>();
//        test.add(5, 5);
//        System.out.println(test.size());
    }

    @Test
    void add() {
        MyArrayList array = new MyArrayList();
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
        MyArrayList array = new MyArrayList();
        array.add(1, 0);
        assertEquals(1, array.size());
        assertEquals(1, array.get(0));
        array.add(0, 0);
        assertEquals(2, array.size());
        assertEquals(0, array.get(0));
        assertEquals(1, array.get(1));
    }

    @Test
    void get() {
        MyArrayList array = new MyArrayList();
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));
        array.add(1);
        assertEquals(1, array.get(0));

    }

}