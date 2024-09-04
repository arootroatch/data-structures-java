package main;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList implements MyList {
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
    if (size == oldCapacity) {
      int newCapacity = oldCapacity == 1 ? 5 : oldCapacity + (oldCapacity / 2);
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

  public MyArrayList[] partition() {
    MyArrayList[] temp = new MyArrayList[2];
    MyArrayList left = new MyArrayList();
    MyArrayList right = new MyArrayList();
    int m = this.size / 2;

    for (int i = 0; i < m; i++) {
      left.add(this.get(i));
    }
    for (int i = m; i < this.size; i++) {
      right.add(this.get(i));
    }

    temp[0] = left;
    temp[1] = right;

    return temp;
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

  public boolean equals(MyArrayList arr) {
    boolean equals = arr.size() == size;

    for (int i = 0; i < size; i++) {
      int n = (int) array[i];
      if (n != arr.get(i)) {
        equals = false;
        break;
      }
    }
    return equals;
  }

}