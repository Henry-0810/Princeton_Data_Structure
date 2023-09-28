package MTU_DataStructure.Lab2;

import org.junit.Test;
import org.junit.Assert;

public class CP3LinkedListTest {
    CP3LinkedList<String> testStrList = new CP3LinkedList<>();
    CP3LinkedList<Integer> testIntList = new CP3LinkedList<>();

    @Test
    public void testGetFirst() {
        testIntList.addFirst(1);
        testIntList.addFirst(2);
        testIntList.addFirst(3);
        Integer expected = 3;
        Assert.assertEquals(expected, testIntList.getFirst());
    }

    @Test
    public void testRemoveFirst() {
        testIntList.addFirst(2);
        testIntList.addFirst(3);
        Integer expected = 3;
        Assert.assertEquals(expected, testIntList.removeFirst());
    }

    @Test
    public void testSize(){
        testIntList.addFirst(1);
        testIntList.addFirst(2);
        testIntList.addFirst(3);
        testIntList.addFirst(4);
        testIntList.removeFirst();
        testIntList.removeFirst();
        //Test many
        int expected = 2;
        Assert.assertEquals(expected, testIntList.size());
        testIntList.removeFirst();
        testIntList.removeFirst();
        //Test empty
        expected = 0;
        Assert.assertEquals(expected, testIntList.size());
    }

    @Test
    public void testContains(){
        testIntList.addFirst(1);
        testIntList.addFirst(2);
        testIntList.addFirst(3);
        testIntList.addFirst(4);
        testIntList.addFirst(5);
        boolean expected = true;
        Assert.assertEquals(expected,testIntList.contains(2));
        //Test last digit
        Assert.assertEquals(expected,testIntList.contains(1));
    }

    @Test
    public void testAddLast() {
        //testAdd
        testIntList.addLast(1);
        testIntList.addLast(2);
        testIntList.addLast(3);
        testIntList.addLast(4);
        Integer expected = 1;
        Assert.assertEquals(expected,testIntList.removeFirst());
        expected = 4;
        Assert.assertEquals(expected,testIntList.removeLast());
    }
}