package ss9.Bai_tap;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: "+ capacity);
        } else {
            elements = new Object[capacity];
        }
    }

    public void add(int index,E element){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Error at index = " + index + ", size = " + size);
        } else {
            if (size == elements.length) {
                ensureCapacity();
            }
            else {
                size++;
                for (int i = size; i > index; i--) {
                    elements[i] = elements[i-1];
                }
                elements[index]= element;
            }
        }
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
        return true;
    }

    public void remove(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Error at index = " + index);
        } else {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i+1];
            }
            size--;
        }
    }

    public int size() {
        return size;
    }

    public void display(){
        if(this.size == 0 ){
            System.out.println("Nothing to display");
        } else {
            System.out.println("The element are: ");
            for (int i = 0; i < this.size; i++) {
                System.out.println(elements[i]);
            }
        }
    }

    public MyList<E> clone() {
        MyList copyArray = new MyList();
        copyArray.elements = Arrays.copyOf(this.elements, this.size);
        copyArray.size = this.size;
        return copyArray;
    }

    public boolean contains(E element){
        return indexOf(element) >= 0;
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (element.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void ensureCapacity(int minCapacity) {
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        this.size = 0;
    }
}
