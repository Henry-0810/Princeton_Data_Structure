package Stacks_and_Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int numOfElements;

    private class Node {
        Item item;
        Node next;
    }

    // construct an empty deque
    public Deque() {
        numOfElements = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return numOfElements;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Item is null");

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;

        if (isEmpty()) {
            last = newNode;
        }

        first = newNode;
        numOfElements++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Item is null");

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        numOfElements++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Stacks_and_Queue.Deque is empty");
        Item oldFirstItem = first.item;
        first = first.next;
        numOfElements--;
        return oldFirstItem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Stacks_and_Queue.Deque is empty");
        if (first.next == null) {
            return removeFirst();
        }
        Item oldLastItem = last.item;
        Node secLastNode = first;
        while (secLastNode.next.next != null) {
            secLastNode = secLastNode.next;
        }
        secLastNode.next = null;
        last = secLastNode;
        numOfElements--;
        return oldLastItem;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("No more items");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Function not supported");
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> dequeNums = new Deque<>();
        dequeNums.addFirst(1);
        dequeNums.addFirst(3);
        dequeNums.addFirst(4);
        StdOut.print(dequeNums.removeLast());
        StdOut.print(dequeNums.removeLast());
        Iterator<Integer> i = dequeNums.iterator();
        while (i.hasNext()) {
            StdOut.print(i.next());
        }
    }
}