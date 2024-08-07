package main;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList implements MyList<Integer> {
  private Object[] array;
  private int size;

  public MyArrayList() {
    array = new Object[10];
  }

  public MyArrayList(int capacity) {
    array = new Object[capacity];
  }


  public void add(int i) {
    growIfFull();
    int index = size;
    array[index] = i;
    size++;
  }

  public void add(int i, int index) {
    if (index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    growIfFull();
    if (size > 0) System.arraycopy(array, index, array, index + 1, size - index);
    array[index] = i;
    size++;
  }

  private void growIfFull() {
    int oldCapacity = array.length;
// TODO - increase capacity by more than 1.

    if (size == oldCapacity) {
      int newCapacity = oldCapacity + 1;
      array = Arrays.copyOf(array, newCapacity);
    }
  }

  public int size() {
    return size;
  }

  public void remove(int index) {
    if (index == size - 1) {
      System.arraycopy(array, 0, array, 0, size - 1);
    } else
      System.arraycopy(array, index + 1, array, index, size - (index + 1));
    size--;
  }

  public int get(int index) {
    Objects.checkIndex(index, size);
    return (int) array[index];
  }

  public String toString() {
    if (size == 0) return "[ ]";

    String str = "[ ";
    for (Object o : array) {
      str = str.concat(o.toString().concat(" "));
    }
    str = str.concat("]");
    return str;
  }

 public boolean equals(MyArrayList arr){
    boolean equals = true;
    if (arr.size() != size){
      equals = false;
    }

    for (int i = 0; i < size; i++){
      int n = (int) array[i];
      if (n != arr.get(i)){
        equals = false;
        break;
      }
    }
    return equals;
  }

}