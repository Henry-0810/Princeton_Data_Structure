package Stacks_and_Queue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int head, tail, n = 0;
    private Item[] arr;

    // construct an empty randomized queue
    public RandomizedQueue() {
        head = 0;
        tail = 0;
        arr = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Item is null");
        if (isEmpty()) {
            arr[n++] = item;
            head = tail;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    arr[n++] = item;
                    tail = n;
                    break;
                }
            }
        }
        if (n == arr.length) resize(2 * arr.length);
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        int randNum = StdRandom.uniformInt(0, n);
        Item item = arr[randNum];
        for (int i = randNum; i < arr.length; i++) {
            if (arr[i] != null) {
                arr[i] = arr[i + 1];
                if (arr[i + 1] == null) arr[i] = null;
            }
        }
        n--;
        if (n > 0 && n == arr.length / 4) resize(arr.length / 2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return arr[StdRandom.uniformInt(0, n)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomArrayIterator();
    }

    private class RandomArrayIterator implements Iterator<Item> {
        private int currentIndex = 0;
        private Item[] shuffledArray;

        public RandomArrayIterator() {
            shuffledArray = (Item[]) new Object[n];
            System.arraycopy(arr, 0, shuffledArray, 0, n);
            StdRandom.shuffle(shuffledArray);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("No more elements");
            return shuffledArray[currentIndex++];
        }

    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(arr, 0, copy, 0, n);
        arr = copy;
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        rq.enqueue(6);
        rq.enqueue(7);
        int size = rq.size(); // Get the queue's size
        StdOut.println("Queue size before dequeue: " + size);

        Iterator<Integer> iterator = rq.iterator();
        while (iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
        }
        StdOut.println(); // Print a new line after iterator finishes

        int sample = rq.sample(); // Sample an element
        StdOut.println("Sampled element: " + sample);

        int dequeued = rq.dequeue(); // Dequeue an element
        StdOut.println("Dequeued element: " + dequeued);

        size = rq.size(); // Get the queue's size
        StdOut.println("Queue size after dequeue: " + size);

        Iterator<Integer> iterator2 = rq.iterator();
        while (iterator2.hasNext()) {
            StdOut.print(iterator2.next() + " ");
        }
    }
}
