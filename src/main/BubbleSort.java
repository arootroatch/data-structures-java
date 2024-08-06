package main;

import static utils.Convert.convertToArray;
import static utils.Convert.convertToList;

public class BubbleSort {

  public static MyList<Integer> sort(MyList<Integer> list) {
    if (list.size() < 2) return list;
    MyList<Integer> temp = convertToArray(list);
    bubbleSort(temp);
    return convertToList(list, temp);
  }

  private static void bubbleSort(MyList<Integer> temp) {
    boolean swapped;
    do {
      int start = 0;
      swapped = false;
      for (int i = start; i < temp.size() - 1; i++) {
        if (temp.get(i) > temp.get(i + 1)) {
          int elem = temp.get(i + 1);
          temp.remove(i + 1);
          temp.add(elem, i);
          swapped = true;
        }
      }
    } while (swapped);
  }
}
