public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(4);

        System.out.println("printing linked listAllElements : ");
        linkedList.listAllElements();

        System.out.println("Remove tailing element");
        linkedList.removeTailElement();
        System.out.println("After Remove tailing element");
        linkedList.listAllElements();

        System.out.println("adding one more element");
        linkedList.add(5);
        linkedList.listAllElements();
        System.out.println("remove all elements which are greater than 2");
        linkedList.removeAllGreater(2);
        linkedList.listAllElements();
    }
}

/**
 * Node to manage functions
 */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head;

    /**
     * all element in linked listAllElements
     *
     * @param data
     */
    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    /**
     * remove all elements which are greater than data argument
     * @param data
     */
    public void removeAllGreater(int data) {
        Boolean isFirst = false;
        if (head == null)
            return;


        if (head.data > data) {
            if (head.next == null) {
                head = null;
                return;
            } else {
                isFirst = true;
            }
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data > data) {
                if (current.next.next == null) {
                    current.next = null;
                    break;
                }
                current.next = current.next.next;

            }
            current = current.next;
        }

        if (isFirst)
            head = head.next;
        return;
    }

    /**
     * remove last added element
     */
    public void removeTailElement() {

        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.next == null) {
                current.next = null;
                return;
            }
            current = current.next;
        }
    }

    /**
     * list out all elements
     */
    public void listAllElements() {
        if (head == null)
            return;
        Node current = head;
        System.out.println("node : " + current.data);
        while (current.next != null) {
            current = current.next;
            System.out.println("node : " + current.data);
        }
    }


}