package utils;

import main.MyList;

public class Add {
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

  public static void addNDec(MyList<Integer> list, Integer n) {
    for (int i = n - 1; i >= 0; i--) {
      list.add(i);
    }
  }

  public static void addNInc(MyList<Integer> list, Integer n){
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
  }

  public static void addNRandom(MyList<Integer> list, Integer n) {
    for (int i = 0; i < n; i++) {
      int r = (int) (Math.floor(Math.random() * n));
      list.add(r);
    }
  }
}
