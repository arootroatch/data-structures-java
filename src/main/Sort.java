package main;

public class Sort {
  public static MyList<Integer> bubble(MyList<Integer> list) {
    boolean swapped;
    MyList<Integer> temp = list;

    if (list instanceof MyLinkedList){
      temp = new MyArrayList();
      for (int i = 0; i < list.size(); i++){
        temp.add(list.get(i));
      }
    }

    if (temp.size() > 1) {
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

    if (list instanceof  MyLinkedList){
      MyLinkedList sorted = new MyLinkedList();
      for (int i = 0; i < temp.size(); i++){
        sorted.add(temp.get(i));
      }
      return sorted;
    } else return temp;
  }
}
