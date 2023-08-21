package Stacks_and_Queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Stacks_and_Queue.Permutation <number of strings>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        RandomizedQueue<String> rds = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            rds.enqueue(StdIn.readString());
        }

        for (int i = 0; i < n; i++) {
            StdOut.println(rds.sample() + " ");
        }
    }
}