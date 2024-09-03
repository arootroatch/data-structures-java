package main;

public class MyLinkedList implements MyList {
  int size = 0;
  Node<Integer> first;
  Node<Integer> last;

  public MyLinkedList() {
  }

  public void add(int i) {
    final Node<Integer> newNode = new Node<>(last, i, null);
    if (last == null) first = newNode;
    else last.next = newNode;
    size++;
    last = newNode;
  }

  public void add(int i, int index) {
    if (index == size) add(i);
    else {
      checkIndex(index);
      final Node<Integer> next = node(index);
      final Node<Integer> prev = node(index).prev;
      final Node<Integer> newNode = new Node<>(prev, i, next);
      next.prev = newNode;

      if (prev == null) first = newNode;
      else prev.next = newNode;
      size++;
    }
  }

  public int size() {
    return size;
  }

  public void remove(int index) {
    checkIndex(index);
    final Node<Integer> nodeToRemove = node(index);
    final Node<Integer> prev = nodeToRemove.prev;
    final Node<Integer> next = nodeToRemove.next;
    if (prev == null) first = next;
    else {
      prev.next = next;
      nodeToRemove.prev = null;
    }

    if (next == null) last = prev;
    else {
      next.prev = prev;
      nodeToRemove.next = null;
    }

    nodeToRemove.item = null;
    size--;
  }

  public int get(int index) {
    checkIndex(index);
    return node(index).item;
  }

  public MyLinkedList[] partition() {
    MyLinkedList[] partitions = new MyLinkedList[2];
    MyLinkedList left = new MyLinkedList();
    MyLinkedList right = new MyLinkedList();

    int m = this.size / 2;
    Node<Integer> leftTail = node(m - 1);
    Node<Integer> rightHead = leftTail.next;
    leftTail.next = null;
    rightHead.prev = null;

    left.first = this.first;
    left.last = leftTail;
    left.size = m;
    right.first = rightHead;
    right.last = this.last;
    right.size = this.size - m;

    partitions[0] = left;
    partitions[1] = right;

    return partitions;
  }

  private static class Node<Integer> {
    Integer item;
    Node<Integer> next;
    Node<Integer> prev;

    Node(Node<Integer> prev, Integer element, Node<Integer> next) {
      this.item = element;
      this.next = next;
      this.prev = prev;
    }
  }

  private Node<Integer> node(int index) {
    Node<Integer> x;
    if (index < (size / 2)) {
      x = first;
      for (int i = 0; i < index; i++)
        x = x.next;
    } else {
      x = last;
      for (int i = size - 1; i > index; i--)
        x = x.prev;
    }
    return x;
  }

  private void checkIndex(int index) {
    if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
  }
}
