package schoolbook.chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brackets {

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException {

        String input;

        while (true) {
            System.out.print("Enter string containing delimenetrs: ");

            input = getString();

            if (input.equals(" "))
                break;

            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check(); // check brackets
        }
    }

}

class StackXChar2 {

    private final int maxSize;
    private final char[] stackArray;
    private int top;

    public StackXChar2(int max) {
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

}

class BracketChecker {

    private final String input;

    public BracketChecker(final String input) {
        this.input = input;
    }

    public void check() {
        int stackSize = input.length();
        StackXChar2 theStack = new StackXChar2(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
            case '{':
            case '[':
            case '(':
                theStack.push(ch);
                break;

            case '}':
            case ']':
            case ')':
                if (!theStack.isEmpty()) {

                    char chx = theStack.pop();

                    if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[')
                            || (ch == ')' && chx != '('))
                        System.out.println("Error: " + ch + " at " + j);
                } else
                    System.out.println("Error: " + ch + " at " + j);
                break;

            default:
                break;

            }
        }

        if (!theStack.isEmpty())
            System.out.println("Error: missing right delimiter");
    }
}
