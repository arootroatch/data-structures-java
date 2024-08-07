package main;

import static utils.Convert.convertToList;

// TODO - Use only the MyList interface
public class MergeSort {
  public static MyList<Integer> sort(MyList<Integer> list) {
    MyList<Integer> sorted = mergeSort(list);
    return convertToList(list, sorted);
  }

  private static MyList<Integer> mergeSort(MyList<Integer> list) {
    if (list.size() < 2) return list;

    int m = list.size() / 2;
    MyArrayList left = partition(list, 0, m);
    MyArrayList right = partition(list, m, list.size());

    return merge(mergeSort(left), mergeSort(right));
  }

  private static MyArrayList merge(MyList<Integer> left, MyList<Integer> right) {
    MyArrayList sorted = new MyArrayList();
    int totalSize = left.size() + right.size();

    while (sorted.size() < totalSize) {
      if (right.size() == 0) {
        while (left.size() > 0) {
          sorted.add(left.get(0));
          left.remove(0);
        }
      } else if (left.size() == 0) {
        while (right.size() > 0) {
          sorted.add(right.get(0));
          right.remove(0);
        }
      } else if (left.get(0) < right.get(0)) {
        sorted.add(left.get(0));
        left.remove(0);
      } else {
        sorted.add(right.get(0));
        right.remove(0);
      }
    }

    return sorted;
  }

  private static MyArrayList partition(MyList<Integer> list, int start, int end){
    MyArrayList temp = new MyArrayList();
    for (int i = start; i < end; i++) {
      temp.add(list.get(i));
    }
    return temp;
  }
}
