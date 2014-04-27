package chapter21;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class Example {

    public static void sort(Comparable[] a) {

    }

    private static boolean less(Comparable v, Comparable a) {
        return v.compareTo(a) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }

        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        System.out.println(isSorted(a));
        show(a);
    }
}
