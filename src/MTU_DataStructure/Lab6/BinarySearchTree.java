package MTU_DataStructure.Lab6;

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        public E  data;
        public Node left;
        public Node right;
    }
    private Node root;

    public BinarySearchTree(){
        root = null;
    }

    public Node newNode(E element){
        Node newnode = new Node();
        newnode.data = element;
        newnode.left = null;
        newnode.right = null;
        return newnode;
    }
    public void insert(E element){
        Node newNode = newNode(element);
        if (root == null)
            root = newNode;
        else insertSub(newNode, root);
    }

    private void insertSub(Node newNode, Node node) {
        int result = newNode.data.compareTo(node.data);
        // duplicates go to the right
        if (result >= 0) {
            //go right
            if (node.right == null) {
                node.right = newNode;
            } else {
                insertSub(newNode, node.right);
            }
        } else {
            // go left
            if (node.left == null) {
                node.left = newNode;
            } else {
                insertSub(newNode, node.left);
            }
        }
    }

    public void insertIterative(E element){
        Node newNode = newNode(element);

        Node current = root;
        Node insertSpot = null;

        while(current != null){
            insertSpot = current;
            int result = element.compareTo(current.data);
            if(result < 0){
                current = current.left;
            }
            else{
                current=current.right;
            }
        }

        if(insertSpot == null) insertSpot = newNode;
        if(element.compareTo(insertSpot.data) < 0) insertSpot.left = newNode;
        else{insertSpot.right = newNode;}

    }


    public void print(){
        if (root != null)
            printSub(root);
    }

    private void printSub(Node node) {
        //inorder traversal
        if (node != null){
            printSub(node.left);
            System.out.println(node.data);
            printSub(node.right);
        }
    }

    public boolean contains(E element){
        Node current = root;
        while(current != null){
            int result = element.compareTo(current.data);
            if(result < 0) current = current.left;
            else if(result > 0) current = current.right;
            else return true;
        }

        return false;
    }

    public boolean isEmpty(){
        return root == null;
    }
}
