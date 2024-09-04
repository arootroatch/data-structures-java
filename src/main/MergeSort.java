package main;

public class MergeSort {
  public static MyList sort(MyList list) {
    return mergeSort(list);
  }

  private static MyList mergeSort(MyList list) {
    if (list.size() < 2) return list;

    MyList[] parted = list.partition();
    MyList left = parted[0];
    MyList right = parted[1];
    return merge(mergeSort(left), mergeSort(right));
  }

  private static MyList merge(MyList left, MyList right) {
    MyList sorted = newList(left);
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

  private static MyList newList(MyList list){
    if (list instanceof MyLinkedList)
      return new MyLinkedList();
    else return new MyArrayList();
  }
}
