package schoolbook.chapter05;

public class LinkList {

    private Link first;

    public void LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }

        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        while (current.iData != key) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first)
            first = first.next;
        else
            previous.next = current.next;

        return current;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while (current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkList theList = new LinkList(); // make list

        theList.insertFirst(22, 2.99); // insert 4 items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList(); // display list

        Link f = theList.find(44); // find item
        if (f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can’t find link");

        Link d = theList.delete(66); // delete item
        if (d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can’t delete link");

        theList.displayList(); // display list

    }

}
