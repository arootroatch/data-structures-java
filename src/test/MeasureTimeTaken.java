package test;

import main.MyList;

public class MeasureTimeTaken {
  public static void measureTimeTaken(String message, Runnable function) {
    long startTime, endTime;
    double executionTime;
    startTime = System.nanoTime();
    function.run();
    endTime = System.nanoTime();
    executionTime = (double) (endTime - startTime) / 1000000;
    System.out.println(message + " takes " + executionTime + "ms");
  }

  public static void add1000ToEnd(MyList<Integer> list) {
    for (int i = 0; i < 1000; i++) {
      list.add(i);
    }
  }

  public static void add1000ToMiddleInc(MyList<Integer> list) {
    int index = 5;
    for (int i = 0; i < 1000; i++) {
      list.add(i, index);
      index++;
    }
  }

  public static void add1000ToMiddleStatic(MyList<Integer> list) {
    for (int i = 0; i < 1000; i++) {
      list.add(i, 5);
    }
  }

  public static void add1000ToBeginning(MyList<Integer> list) {
    for (int i = 0; i < 1000; i++) {
      list.add(i, 0);
    }
  }
}
