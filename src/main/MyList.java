package main;

public interface MyList<T> {
    void add(int i);
    void add(int i, int index);
    int size();
    void remove(int index);
    int get(int index);
}
