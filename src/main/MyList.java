package main;
import java.net.ServerSocket;

public interface MyList<Integer> {
  void add(int i);

  void add(int i, int index);

  int size();

  void remove(int index);

  int get(int index);
}

// TODO - Add partition
