package MTU_DataStructure.Lab6;

public class TestBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insertIterative(1);
        bst.insertIterative(2);
        bst.insertIterative(3);
        bst.insertIterative(9);
        bst.insertIterative(5);
        bst.insertIterative(10);
        bst.insertIterative(18);
        bst.insertIterative(12);
        bst.print();
    }
}
