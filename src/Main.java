public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkedList linkedList = new LinkedList();
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(3);

//        linkedList.removeTail();
//        linkedList.removeAllGreater(2);
        linkedList.list();
    }
}


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head;

    public void append(int data) {
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

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void removeAllGreater(int data) {
        if (head == null)
            return;


        if (head.data > data) {
            if (head.next == null) {
                head = null;
                return;
            } else {
                head = head.next;
            }
        }

        Node current = head;
        while (current.next != null) {
            if (current.data > data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return;
    }


    public void removeTail() {

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

    public void list() {
        if (head == null)
            return;
        Node current = head;
        System.out.println("node : " + current.data);
        while (current.next != null) {
            current = current.next;
            System.out.println("node : " + current.data);
        }
    }

    public void deleteAt(int data) {
        if (head == null)
            return;

        if (head.data == data) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }


}