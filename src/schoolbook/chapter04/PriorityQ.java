package schoolbook.chapter04;

public class PriorityQ {

    private final int maxSize;
    private final long[] queArray;
    private int nItems;

    public PriorityQ(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j = 0;

        if (nItems == 0)
            queArray[nItems++] = item;
        else
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queArray[j])
                    queArray[j + 1] = queArray[j];
                else {
                    System.out.println("break na :" + j + " gdy item: " + item);
                    break;
                }
            }

        queArray[j + 1] = item;
        nItems++;
    }

    public long remove() // remove minimum item
    {
        return queArray[--nItems];
    }

    public long peekMin() // peek at minimum item
    {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() // true if queue is empty
    {
        return (nItems == 0);
    }

    public boolean isFull() // true if queue is full
    {
        return (nItems == maxSize);
    }

    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityQ(10);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        while (!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.print(item + " "); // 10, 20, 30, 40, 50
        } // end while
        System.out.println("");

    }

}
