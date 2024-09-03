package main;

// TODO - Use only the MyList interface
public class MergeSort {
  public static MyList sort(MyList list) {
    return mergeSort(list);
  }

  private static MyList mergeSort(MyList list) {
    if (list.size() < 2) return list;

    int m = list.size() / 2;
//    MyList left = partition(list, 0, m);
//    MyList right = partition(list, m, list.size());

    return list;

//    return merge(mergeSort(left), mergeSort(right));
  }

  private static MyList merge(MyList left, MyList right) {
    MyList sorted = new MyArrayList();
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

}
