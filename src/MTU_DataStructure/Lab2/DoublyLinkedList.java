package MTU_DataStructure.Lab2;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private int listSize = 1;

    private class Node {
        public E data;
        public Node next;
        public Node prev;
    }
    private Node first;
    private Node last;

    /**
     Constructs an empty linked list.
     */
    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }

    /**
     Adds an element to the front of the linked list.
     @param element the element to add
     */
    public void addFirst(E element)
    {
        Node newLink = new Node();
        newLink.data = element;
        newLink.next = first;
        first = newLink;

        if(size() == 1) last = newLink;
    }

    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    public E removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        E element = first.data;
        first = first.next;
        return element;
    }

    public void addLast(E element){
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = null;
        if(size() == 0){
            first = newNode;
        }else{
            last.next = newNode;
        }
        last = newNode;
    }

    public E removeLast(){
        if (first == null)
            throw new NoSuchElementException();
        Node current = first;
        if(current.next == null) return removeFirst();
        // list has at least 2 items
        E oldLastItem = last.data;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
        last = current;
        return oldLastItem;
    }

    public void print(){
        //outputs the data on the list
        Node current = first;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int size(){
        Node current = first;
        if(current == null) return 0;
        while(current.next != null){
            listSize++;
            current = current.next;
        }
        return listSize;
    }

    public boolean contains(E element) {
        Node current = first;
        while(current.next != null){
            if(current.data.equals(element)) return true;
            current = current.next;
        }
        return current.data.equals(element);
    }
}
