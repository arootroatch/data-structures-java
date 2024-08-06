package mainTest;

import main.MyArrayList;
import main.MyLinkedList;
import main.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static main.QuickSort.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static utils.Add.addNDec;
import static utils.Add.addNRandom;
import static utils.MeasureTimeTaken.measureTimeTaken;

public class QuickSortTest {
  MyList<Integer> arr;
  MyList<Integer> arrResult;
  MyList<Integer> list;
  MyList<Integer> listResult;

  @BeforeEach
  void setup() {
    list = new MyLinkedList();
    listResult = new MyLinkedList();
    arr = new MyArrayList();
    arrResult = new MyArrayList();
  }

  @Test
  void emptyArr() {
    arrResult = sort(arr);
    assertEquals(0, arrResult.size());
  }

  @Test
  void emptyList() {
    listResult = sort(list);
    assertEquals(0, listResult.size());
  }

  @Test
  void arrOne() {
    arr.add(0);
    arrResult = sort(arr);
    assertEquals(1, arrResult.size());
    assertEquals(0, arrResult.get(0));
  }

  @Test
  void listOne() {
    list.add(0);
    listResult = sort(list);
    assertEquals(1, listResult.size());
    assertEquals(0, listResult.get(0));
  }

  @Test
  void arrTwo() {
    addNDec(arr, 2);
    arrResult = sort(arr);
    assertEquals(2, arrResult.size());
    assertEquals(0, arrResult.get(0));
    assertEquals(1, arrResult.get(1));
  }

  @Test
  void listTwo() {
    addNDec(list, 2);
    listResult = sort(list);
    assertEquals(2, listResult.size());
    assertEquals(0, listResult.get(0));
    assertEquals(1, listResult.get(1));
  }

  @Test
  void arrThree() {
    addNDec(arr, 3);
    arrResult = sort(arr);
    assertEquals(3, arrResult.size());
    assertEquals(0, arrResult.get(0));
    assertEquals(1, arrResult.get(1));
    assertEquals(2, arrResult.get(2));
  }


  @Test
  void listThree() {
    addNDec(list, 3);
    listResult = sort(list);
    assertEquals(3, listResult.size());
    assertEquals(0, listResult.get(0));
    assertEquals(1, listResult.get(1));
    assertEquals(2, listResult.get(2));
    assertInstanceOf(MyLinkedList.class, listResult);
  }

  @Test
  void arrTen() {
    addNDec(arr, 10);
    arrResult = sort(arr);
    assertEquals(10, arrResult.size());
    assertEquals(0, arrResult.get(0));
    assertEquals(1, arrResult.get(1));
    assertEquals(2, arrResult.get(2));
    assertEquals(3, arrResult.get(3));
    assertEquals(4, arrResult.get(4));
    assertEquals(5, arrResult.get(5));
    assertEquals(6, arrResult.get(6));
    assertEquals(7, arrResult.get(7));
    assertEquals(8, arrResult.get(8));
    assertEquals(9, arrResult.get(9));
  }

  @Test
  void listTen() {
    addNDec(list, 10);
    listResult = sort(list);
    assertEquals(10, listResult.size());
    assertEquals(0, listResult.get(0));
    assertEquals(1, listResult.get(1));
    assertEquals(2, listResult.get(2));
    assertEquals(3, listResult.get(3));
    assertEquals(4, listResult.get(4));
    assertEquals(5, listResult.get(5));
    assertEquals(6, listResult.get(6));
    assertEquals(7, listResult.get(7));
    assertEquals(8, listResult.get(8));
    assertEquals(9, listResult.get(9));
  }

  @Test
  void measureTimeArr() {
    addNRandom(arr, 10000);
    measureTimeTaken("Sorting an array of 10,000 random numbers", () -> sort(arr));
    // 92 - 400  ms
  }

  @Test
  void measureTimeList() {
    addNRandom(list, 10000);
    measureTimeTaken("Sorting a list of 10,000 random numbers", () -> sort(list));
    // 383 - 663 ms
  }
}
