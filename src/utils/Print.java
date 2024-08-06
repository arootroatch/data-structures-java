package utils;

import main.MyList;

public class Print {
  public static void printArray(MyList<Integer> arr) {
    int n = arr.size();
    for (int i = 0; i < n; ++i)
      System.out.print(arr.get(i) + " ");
    System.out.println();
  }
}
