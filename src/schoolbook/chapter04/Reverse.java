package schoolbook.chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackXChar {

    private final int maxSize;
    private final char[] stackArray;
    private int top;

    public StackXChar(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}

class Reverser {
    private final String input;
    private String output;

    public Reverser(String in) {
        this.input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackXChar theStack = new StackXChar(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.push(ch);
        }

        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output = output + ch;
        }

        return output;
    }
}

public class Reverse {

    public static void main(String[] args) throws IOException {
        String input, output;

        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();

            input = getString();
            if (input.equals(" "))
                break;

            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("Reversed: " + output);
        }
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
