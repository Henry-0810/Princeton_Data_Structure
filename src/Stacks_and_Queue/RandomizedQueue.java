package Stacks_and_Queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int head, tail, N = 0;
    private Item[] arr;

    // construct an empty randomized queue
    public RandomizedQueue(){
        head = 0;
        tail = 0;
        arr = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return N + 1;
    }

    // add the item
    public void enqueue(Item item){
        if(item == null) throw new IllegalArgumentException("Item is null");
        if(N == arr.length) resize(2*arr.length);
        if(isEmpty()){
            arr[N++] = item;
            head = tail;
        }
        else{
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == null){
                    arr[N++] = item;
                    tail = N;
                    break;
                }
            }
        }
    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        int randNum = StdRandom.uniformInt(0,N+1);
        Item item = arr[randNum];
        //writing head and tail algo
        if(N > 0 && N == arr.length/4) resize(arr.length/2);
        return null;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        return null;}

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
return null;
    }

    private void resize(int capacity){
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(arr, 0, copy, 0, N);
        arr = copy;
    }
    // unit testing (required)
    public static void main(String[] args){}

}
