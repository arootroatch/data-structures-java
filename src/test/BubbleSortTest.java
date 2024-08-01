package test;

import main.MyArrayList;
import main.MyLinkedList;
import main.MyList;
import main.Sort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.MeasureTimeTaken.measureTimeTaken;

public class BubbleSortTest {
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
    assertEquals(arr, Sort.bubble(arr));
  }

  @Test
  void emptyList() {
    assertEquals(list, Sort.bubble(list));
  }

  @Test
  void arrOne() {
    arr.add(5);
    assertEquals(arr, Sort.bubble(arr));
  }

  @Test
  void listOne() {
    list.add(5);
    assertEquals(list, Sort.bubble(list));
  }

  @Test
  void arrTwo() {
    addNDec(arr, 2);
    arrResult = Sort.bubble(arr);
    assertEquals(0, arrResult.get(0));
    assertEquals(1, arrResult.get(1));
    assertEquals(2, arrResult.size());
  }

  @Test
  void listTwo() {
    addNDec(list, 2);
    listResult = Sort.bubble(list);
    assertEquals(0, listResult.get(0));
    assertEquals(1, listResult.get(1));
    assertEquals(2, listResult.size());
  }

  @Test
  void arrThree() {
    addNDec(arr, 3);
    arrResult = Sort.bubble(arr);
    assertEquals(0, arrResult.get(0));
    assertEquals(1, arrResult.get(1));
    assertEquals(2, arrResult.get(2));
    assertEquals(3, arrResult.size());
  }

  @Test
  void listThree() {
    addNDec(list, 3);
    listResult = Sort.bubble(list);
    assertEquals(0, listResult.get(0));
    assertEquals(1, listResult.get(1));
    assertEquals(2, listResult.get(2));
    assertEquals(3, listResult.size());
  }

  @Test
  void arrFour() {
    addNDec(arr, 4);
    arrResult = Sort.bubble(arr);
    assertEquals(0, arrResult.get(0));
    assertEquals(1, arrResult.get(1));
    assertEquals(2, arrResult.get(2));
    assertEquals(3, arrResult.get(3));
    assertEquals(4, arrResult.size());
  }

  @Test
  void listFour() {
    addNDec(list, 4);
    listResult = Sort.bubble(list);
    assertEquals(0, listResult.get(0));
    assertEquals(1, listResult.get(1));
    assertEquals(2, listResult.get(2));
    assertEquals(3, listResult.get(3));
    assertEquals(4, listResult.size());
  }

  @Test
  void arrFive() {
    addNDec(arr, 5);
    arrResult = Sort.bubble(arr);
    assertEquals(0, arrResult.get(0));
    assertEquals(1, arrResult.get(1));
    assertEquals(2, arrResult.get(2));
    assertEquals(3, arrResult.get(3));
    assertEquals(4, arrResult.get(4));
    assertEquals(5, arrResult.size());
  }

  @Test
  void listFive() {
    addNDec(list, 5);
    listResult = Sort.bubble(list);
    assertEquals(0, listResult.get(0));
    assertEquals(1, listResult.get(1));
    assertEquals(2, listResult.get(2));
    assertEquals(3, listResult.get(3));
    assertEquals(4, listResult.get(4));
    assertEquals(5, listResult.size());
  }

  @Test
  void arrSix() {
    addNDec(arr, 6);
    arrResult = Sort.bubble(arr);
    assertEquals(0, arrResult.get(0));
    assertEquals(1, arrResult.get(1));
    assertEquals(2, arrResult.get(2));
    assertEquals(3, arrResult.get(3));
    assertEquals(4, arrResult.get(4));
    assertEquals(5, arrResult.get(5));
    assertEquals(6, arrResult.size());
  }

  @Test
  void listSix() {
    addNDec(list, 6);
    listResult = Sort.bubble(list);
    assertEquals(0, listResult.get(0));
    assertEquals(1, listResult.get(1));
    assertEquals(2, listResult.get(2));
    assertEquals(3, listResult.get(3));
    assertEquals(4, listResult.get(4));
    assertEquals(5, listResult.get(5));
    assertEquals(6, listResult.size());
  }

  @Test
  void arrTen() {
    addNDec(arr, 10);
    arrResult = Sort.bubble(arr);
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
    assertEquals(10, arrResult.size());
  }

  @Test
  void listTen() {
    addNDec(list, 10);
    listResult = Sort.bubble(list);
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
    assertEquals(10, listResult.size());
  }

  @Test
  void measureTimeArr() {
    addNRandom(arr, 10000);
    measureTimeTaken("Sorting an array of 10,000 random numbers", () -> Sort.bubble(arr));
    // 20 secs
  }

  @Test
  void measureTimeList() {
    addNRandom(list, 10000);
    measureTimeTaken("Sorting a list of 10,000 random numbers", () -> Sort.bubble(list));
    // Before arr conversion
    // 1000 = 2994ms 3secs
    // 2000 = 24 secs
    // After: 10,000 = 19.9 secs
  }

  void addNDec(MyList<Integer> list, Integer n) {
    for (int i = n - 1; i >= 0; i--) {
      list.add(i);
    }
  }

  void addNRandom(MyList<Integer> list, Integer n) {
    for (int i = 0; i < n; i++) {
      int r = (int) (Math.floor(Math.random() * n));
      list.add(r);
    }
  }


}
