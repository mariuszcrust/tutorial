package schoolbook.chapter03;

public class ArraySel {

    private final long[] a;
    private int nElems;

    public ArraySel(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");

        System.out.println("");
    }

    public void selectionSort() {
        int out, in, min;

        for (out = 0; out < nElems - 1; out++) {
            min = out;

            for (in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
                swap(out, min);
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArraySel arr; // reference to array
        arr = new ArraySel(maxSize); // create the array

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

        arr.display(); // display items

        arr.selectionSort(); // selection-sort them

        arr.display(); // display them again

    }

}
