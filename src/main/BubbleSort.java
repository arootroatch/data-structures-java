package main;

public class BubbleSort {

  public static MyList sort(MyList list) {
    if (list.size() < 2) return list;
    bubbleSort(list);
    return list;
  }

  private static void bubbleSort(MyList temp) {
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
