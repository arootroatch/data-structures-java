package mainTest;


import main.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static utils.Add.*;
import static utils.MeasureTimeTaken.*;

public class MyLinkedListTest {
    MyLinkedList list;
    MyLinkedList listTwo;

    @BeforeEach
    void setup() {
        list = new MyLinkedList();
        listTwo = new MyLinkedList();
        listTwo.add(0);
        listTwo.add(1);
        listTwo.add(2);
    }

    @Test
    void add() {
        list.add(1);
        assertEquals(1, list.get(0));
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    void addAtIndex() {
        list.add(0);
        list.add(2);
        list.add(1, 1);
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void addFirst() {
        listTwo.add(10, 0);
        assertEquals(10, listTwo.get(0));
        assertEquals(0, listTwo.get(1));
        assertEquals(1, listTwo.get(2));
        assertEquals(2, listTwo.get(3));
        assertEquals(4, listTwo.size());
    }

    @Test
    void addLast() {
        listTwo.add(10, 3);
        assertEquals(10, listTwo.get(3));
        assertEquals(4, listTwo.size());
    }


    @Test
    void addAtIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 1));
    }

    @Test
    void remove() {
        listTwo.remove(1);
        assertEquals(2, listTwo.size());
        assertEquals(2, listTwo.get(1));
    }

    @Test
    void removeFirst() {
        listTwo.remove(0);
        assertEquals(2, listTwo.size());
        assertEquals(1, listTwo.get(0));
        assertEquals(2, listTwo.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> listTwo.get(2));
    }

    @Test
    void removeLast() {
        listTwo.remove(2);
        assertEquals(2, listTwo.size());
        assertEquals(0, listTwo.get(0));
        assertEquals(1, listTwo.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> listTwo.get(2));
    }

    @Test
    void removeThrowException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void get() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void timeAddingElements() {
        measureTimeTaken("Adding 1000 elements to end", () -> add1000ToEnd(list));
        measureTimeTaken("Adding 1000 elements to middle (incrementing index)", () -> add1000ToMiddleInc(list));
        measureTimeTaken("Adding 1000 elements to middle (static index)", () -> add1000ToMiddleStatic(list));
        measureTimeTaken("Adding 1000 elements to beginning", () -> add1000ToBeginning(list));
    }
}
