package schoolbook.chapter03;

public class ArrayBub {

    private final long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public void bubbleSort() {
        int out, in;

        for (out = nElems - 1; out > 1; out--)
            for (in = 0; in < out; in++)
                if (a[in] > a[in + 1])
                    swap(in, in + 1);
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);

        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        arr.bubbleSort();

        arr.display();

    }

}
