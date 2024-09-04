package main;

import static utils.Convert.convertToList;

public class QuickSort {
  public static MyList sort(MyList list) {
    if (list.size() < 2) return list;
    MyList sorted = quickSort(list);
    return convertToList(list, sorted);
  }

  private static MyList quickSort(MyList list){
    int m = list.size() / 2, pivot = list.get(m);
    MyList less = newList(list);
    MyList greater = newList(list);

    partition(list, less, pivot, greater);
    return join(sort(less), pivot, sort(greater));
  }

  private static MyList newList(MyList list){
    if (list instanceof MyLinkedList)
      return new MyLinkedList();
    else return new MyArrayList();
  }

  private static void partition(MyList list, MyList less, int pivot, MyList greater){
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) < pivot)
        less.add(list.get(i));
      else if (list.get(i) > pivot)
        greater.add(list.get(i));
    }
  }

  private static MyList join(MyList less, int pivot, MyList greater) {
    // TODO add joining for lists

    MyList joined = newList(less);
    for (int i = 0; i < less.size(); i++) {
      joined.add(less.get(i));
    }
    joined.add(pivot);
    for (int i = 0; i < greater.size(); i++) {
      joined.add(greater.get(i));
    }
    return joined;
  }
}
