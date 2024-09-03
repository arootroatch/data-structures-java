package utils;

import main.MyList;

public class Print {
  public static void printArray(MyList arr) {
    for (int i = 0; i < arr.size(); i++)
      System.out.print(arr.get(i) + " ");
    System.out.println();
  }
}
