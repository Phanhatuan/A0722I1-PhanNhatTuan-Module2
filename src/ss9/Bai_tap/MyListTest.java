package ss9.Bai_tap;

import java.util.LinkedList;

public class MyListTest {
    public static void main(String[] args) {
        MyLinkedListSelfMade<Integer> a = new MyLinkedListSelfMade<Integer>(0);
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.printList();
        System.out.println();
        a.remove(0);
        a.printList();
    }
}
