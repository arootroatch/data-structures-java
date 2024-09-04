package mainTest;

import main.MyArrayList;
import main.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Add.*;
import static utils.MeasureTimeTaken.*;

class MyArrayListTest {
  MyArrayList array;
  MyArrayList arrayTwo;

  @BeforeEach
  void setup() {
    array = new MyArrayList();
    arrayTwo = new MyArrayList();
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
  void removeOne() {
    array.add(1);
    assertEquals(1, array.get(0));
    assertEquals(1, array.size());
    array.remove(0);
    assertEquals(0, array.size());
    assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));
  }

  @Test
  void removeLast() {
    addNInc(array, 10);
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
  void removeMiddle() {
    addNInc(array, 10);
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

  @Test
  void removeFirst() {
    addNInc(array, 10);
    array.remove(0);
    assertEquals(9, array.size());
    assertEquals(1, array.get(0));
    assertEquals(2, array.get(1));
    assertEquals(3, array.get(2));
    assertEquals(4, array.get(3));
    assertEquals(5, array.get(4));
    assertEquals(6, array.get(5));
    assertEquals(7, array.get(6));
    assertEquals(8, array.get(7));
    assertEquals(9, array.get(8));
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
  void partition() {
    addNInc(array, 10);
    MyArrayList[] parted = array.partition();

    assertEquals(0, parted[0].get(0));
    assertEquals(1, parted[0].get(1));
    assertEquals(2, parted[0].get(2));
    assertEquals(3, parted[0].get(3));
    assertEquals(4, parted[0].get(4));
    assertEquals(5, parted[1].get(0));
    assertEquals(6, parted[1].get(1));
    assertEquals(7, parted[1].get(2));
    assertEquals(8, parted[1].get(3));
    assertEquals(9, parted[1].get(4));
  }


  @Test
  void timeAddingElements() {
    measureTimeTaken("Adding 1000 elements to end", () -> add1000ToEnd(array)); // 2.2 ms before capacity increase
    measureTimeTaken("Adding 1000 elements to middle (incrementing index)", () -> add1000ToMiddleInc(array)); // 3.8ms
    measureTimeTaken("Adding 1000 elements to middle (static index)", () -> add1000ToMiddleStatic(array)); // 5.9 ms
    measureTimeTaken("Adding 1000 elements to beginning", () -> add1000ToBeginning(array)); // 1.7ms
  }

  @Test
  void equality(){
    addNDec(array, 10);
    addNDec(arrayTwo, 10);
    assertTrue(array.equals(arrayTwo));
  }
}
