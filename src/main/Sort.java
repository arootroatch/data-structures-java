package main;

public class Sort {
    public static MyList<Integer> bubble(MyList<Integer> list) {
        boolean swapped;
        boolean unbroken = true;

        if (list.size() > 1) {
            while (unbroken) {
                int start = 0;
                swapped = false;
                for (int i = start; i < list.size() - 1; i++) {
                    if (list.get(i) > list.get(i + 1)) {
                        int elem = list.get(i + 1);
                        list.remove(i + 1);
                        list.add(elem, i);
                        swapped = true;
                    }
                }
                if (!swapped) {
                    unbroken = false;
                    break;
                }
            }
        }
        return list;
    }
}
