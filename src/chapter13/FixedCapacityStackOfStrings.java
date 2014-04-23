package chapter13;

import java.util.Iterator;

import edu.princeton.cs.introcs.StdOut;

public class FixedCapacityStackOfStrings<T> implements Iterable<T> {

    private T[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = (T[]) new Object[cap];
    }

    public void push(T item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    public T pop() {
        T item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }

        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];

        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }

        a = temp;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings<String> s = new FixedCapacityStackOfStrings<String>(
                100);

        /*
         * while (!StdIn.isEmpty()) { String item = StdIn.readString(); if
         * (!item.equals("-")) { s.push(item); } else if (item.equals("-")) {
         * StdOut.print(s.pop() + " "); } }
         * 
         * StdOut.println("(" + s.size() + " left on stack)");
         */

        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        s.push("e");

        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
        }
    }

}
