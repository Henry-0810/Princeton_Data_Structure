package MTU_DataStructure.Lab6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(9);
        bst.insert(5);
        bst.insert(10);
        bst.insert(18);
        bst.insert(12);
    }

    @Test
    public void testContains() {
        //test true contains
        boolean expected = true;
        assertEquals(expected, bst.contains(2));
        //test false contains
        expected = false;
        assertEquals(expected, bst.contains(4));
        //test true contains
        expected = true;
        assertEquals(expected, bst.contains(2));
    }

}