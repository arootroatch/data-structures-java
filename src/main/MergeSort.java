package main;

public class MergeSort {
  public static MyList<Integer> sort(MyList<Integer> list) {
    MyList<Integer> sorted = mergeSort(list);

    if (list instanceof MyLinkedList){
      MyLinkedList sortedList = new MyLinkedList();
      for (int i = 0; i < sorted.size(); i++){
        sortedList.add(i);
      }
      return sortedList;
    } else return sorted;
  }

  static MyList<Integer> mergeSort(MyList<Integer> list) {
    if (list.size() < 2) return list;

    if (list.size() == 2) {
      if (list.get(0) > list.get(1)) {
        int elem = list.get(1);
        list.remove(1);
        list.add(elem, 0);
      }
      return list;
    }

    int m = list.size() / 2;
    MyArrayList left = new MyArrayList();
    MyArrayList right = new MyArrayList();

    for (int i = 0; i < m; i++) {
      left.add(list.get(i));
    }

    for (int i = m; i < list.size(); i++) {
      right.add(list.get(i));
    }

    return merge(mergeSort(left), mergeSort(right));
  }

  static MyArrayList merge(MyList<Integer> left, MyList<Integer> right) {
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

  static void printArray(MyList<Integer> arr) {
    int n = arr.size();
    for (int i = 0; i < n; ++i)
      System.out.print(arr.get(i) + " ");
    System.out.println();
  }
}
