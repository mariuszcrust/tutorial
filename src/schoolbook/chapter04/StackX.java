package schoolbook.chapter04;

public class StackX {

    private final int maxSize;
    private final long[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long j) {
        stackArray[++top] = j;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        StackX theStack = new StackX(10); // make new stack
        theStack.push(20); // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty()) // until it’s empty,
        { // delete item from stack
            long value = theStack.pop();
            System.out.print(value); // display it
            System.out.print(" ");
        } // end while
        System.out.println("");

    }
}
