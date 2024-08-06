package utils;

import main.MyArrayList;
import main.MyLinkedList;
import main.MyList;

public class Convert {
  public static MyList<Integer> convertToList(MyList<Integer>list, MyList<Integer> sorted){
    if (list instanceof MyLinkedList){
      MyLinkedList sortedList = new MyLinkedList();
      for (int i = 0; i < sorted.size(); i++){
        sortedList.add(i);
      }
      return sortedList;
    } else return sorted;
  }

  public static MyList<Integer> convertToArray(MyList<Integer> list) {
    if (list instanceof MyLinkedList) {
      MyArrayList temp = new MyArrayList();
      for (int i = 0; i < list.size(); i++) {
        temp.add(list.get(i));
      }
      return temp;
    } else return list;
  }
}
