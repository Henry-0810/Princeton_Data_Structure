package MTU_DataStructure.Lab1;

import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        // Q1.1
        LinkedList<String> names = new LinkedList<>();
        names.add("Kay");
        names.add("Jay");
        names.add("May");
        names.addLast("Fay");

        // Q1.2
        ListIterator<String> listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            String name = listIterator.next();
            if(name.equals("May")) listIterator.add("Ray");
        }

        // Q1.3
        listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            String name = listIterator.next();
            if(name.equals("Jay")) listIterator.remove();
        }

        // Q1.4
        System.out.println("Name List: ");
        listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        // Q1.5
        names.add("Kay");

        System.out.println();
        System.out.println("Updated Name list: ");
        listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        // Q2
        Set<String> set = new HashSet<>();
        set.add("Kay");
        set.add("Jay");
        set.add("May");
        set.add("Fay");

        Iterator<String> i = set.iterator();
        System.out.println("Hash Set: ");
        while(i.hasNext()){
            System.out.print(i.next() + " ");
        }

        set = new TreeSet<>();
        set.add("Kay");
        set.add("Jay");
        set.add("May");
        set.add("Fay");

        System.out.println();
        i = set.iterator();
        System.out.println("Tree Set: ");
        while(i.hasNext()){
            System.out.print(i.next() + " ");
        }

        // Conclusion: Tree Set would output a sorted order of names and both set won't accept duplicated names
    }
}
