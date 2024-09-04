package main;

public class QuickSort {
  public static MyList sort(MyList list) {
    if (list.size() < 2) return list;
    return quickSort(list);
  }

  private static MyList quickSort(MyList list) {
    int m = list.size() / 2, pivot = list.get(m);
    MyList less = newList(list);
    MyList greater = newList(list);


    partition(list, less, pivot, greater);
    return join(sort(less), pivot, sort(greater));
  }

  private static MyList newList(MyList list) {
    if (list instanceof MyLinkedList)
      return new MyLinkedList();
    else return new MyArrayList();
  }

  private static void partition(MyList list, MyList less, int pivot, MyList greater) {
    for (int i = 0; list.size() > 0; ) {
      if (list.get(i) < pivot) {
        less.add(list.get(i));
        list.remove(i);
      } else if (list.get(i) > pivot) {
        greater.add(list.get(i));
        list.remove(i);
      } else list.remove(i);
    }
  }

  private static MyList join(MyList less, int pivot, MyList greater) {
    if (less instanceof MyLinkedList)
      return joinLinkedList((MyLinkedList) less, pivot, (MyLinkedList) greater);
    else return joinArrayList((MyArrayList) less, pivot, (MyArrayList) greater);
  }

  private static MyList joinLinkedList(MyLinkedList less, int pivot, MyLinkedList greater) {
    MyLinkedList joined = new MyLinkedList();
    MyLinkedList.Node<Integer> pivotNode;
    if ((less.size() == 0) && (greater.size() == 0)) {
      pivotNode = new MyLinkedList.Node<>(null, pivot, null);
      joined.first = pivotNode;
      joined.last = pivotNode;
      return joined;
    } else if (less.size() == 0) {
      pivotNode = new MyLinkedList.Node<>(null, pivot, greater.first);
      joined.first = pivotNode;
      joined.last = greater.last;
      greater.first.prev = pivotNode;
    } else if (greater.size() == 0) {
      pivotNode = new MyLinkedList.Node<>(less.last, pivot, null);
      joined.last = pivotNode;
      joined.first = less.first;
      less.last.next = pivotNode;
    } else {
      pivotNode = new MyLinkedList.Node<>(less.last, pivot, greater.first);
      joined.first = less.first;
      less.last.next = pivotNode;
      greater.first.prev = pivotNode;
      joined.last = greater.last;
    }
    joined.size = less.size() + greater.size() + 1;
    return joined;
  }

  private static MyArrayList joinArrayList(MyArrayList less, int pivot, MyArrayList greater) {
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
