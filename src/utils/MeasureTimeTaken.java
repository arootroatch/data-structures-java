package utils;

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
}
