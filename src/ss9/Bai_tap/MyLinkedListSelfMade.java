package ss9.Bai_tap;

public class MyLinkedListSelfMade<E> {
    private Node head;
    private int numNodes;

    public MyLinkedListSelfMade(Object data) {
        head = new Node(data);
        numNodes++;
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public void addLast(Object data){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next  = new Node(data);
        numNodes++;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        numNodes--;
    }

    public void remove(Object element){
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            temp=temp.next;
            if( temp.getData().equals(element)){
                remove(i+1);
            }
        }
    }

    public boolean contains(E element) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData() == element) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data.equals(element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public E getFirst() {
        Node temp = head;
        return (E) temp.getData();
    }
    public E getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }
    public void clear() {
        Node temp = head;
        head = null;
        while (temp.next != null) {
            temp.next = null;
        }
        numNodes = 0;
    }
    public int size() {
        return numNodes;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    private class Node {
        private Node next;
        private final Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
}
