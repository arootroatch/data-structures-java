package main;

import static utils.Convert.convertToList;

// TODO - Use only the MyList interface
public class QuickSort {
  public static MyList sort(MyList list) {
    if (list.size() < 2) return list;
    MyArrayList sorted = quickSort(list);
    return convertToList(list, sorted);
  }

  private static MyArrayList quickSort(MyList list){
    int m = list.size() / 2, pivot = list.get(m);
    MyArrayList less = new MyArrayList();
    MyArrayList greater = new MyArrayList();

    partition(list, less, pivot, greater);
    return join(sort(less), pivot, sort(greater));
  }

  private static void partition(MyList list, MyArrayList less, int pivot, MyArrayList greater){
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) < pivot)
        less.add(list.get(i));
      else if (list.get(i) > pivot)
        greater.add(list.get(i));
    }
  }

  private static MyArrayList join(MyList less, int pivot, MyList greater) {
    MyArrayList joined = new MyArrayList();
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
