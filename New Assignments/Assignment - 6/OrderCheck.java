import java.util.*;
/**
 * Taken two keys min and max as arguments and returns true 
 * If all the keys in the tree are between min and max
 * min and max are indeed the smallest and largest keys in the tree,
 * respectively,BST ordering property holds for all keys in the tree.
 * @param <Key> Keys are generic
 * @param <Value> keys are generic
 * 
 * @author Nikhil ravi teja
 * @reference Robert Sedgewick
 */
class BinaryST<Key extends Comparable<Key>, Value> {

    Node root; // declaring root of BST

    // Declaring Node class
    class Node {
        Key key;
        Value value;
        Node left, right;   // The left and right subtree
        int size;           // no. of nodes in a subtree
        
        //Constructor for Node class
        public Node(Key key, Value value, int size) {

            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    //Size method
    public int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }
    //Size with no arg.
    public int size() {
        return size(root);
    }

    //Boolean for ifEmpty
    public boolean isEmpty() {
        return size() == 0;
    }

    //Put method for inserting key and value
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("calling put() with a null key");
        if (value == null) {
            // delete(key);
            return;
        }
        root = put(root, key, value);
        // assert check();
    }

    private Node put(Node x, Key key, Value value) {

        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = put(x.left,  key, value);
        }
        else if (cmp > 0) {
            x.right = put(x.right, key, value);
        }
        else {
            x.value = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    //Min method
    public Key min() {
        // If empty, throws exception
        if (isEmpty()) { 
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        else {  //Else it gives the Min
            return min(root).key;
        }
    } 

    private Node min(Node x) {

        if (x.left == null) { //If next X is null, it returns X
            return x;
        }
        else {
            return min(x.left);
        }
    }
    // Max method
    public Key max() {
        // If empty, it throws an exception
        if (isEmpty()) {
            throw new NoSuchElementException("calls max() with empty symbol table");
        }
        return max(root).key;
    } 

    private Node max(Node x) {
        
        if (x.right == null) { //If next X is null, it returns X
            return x;
        }
        else {
            return max(x.right);
        }
    }

    //Boolean for isOrdered
    public boolean isOrdered() {
        return isOrdered(root, null, null);
    }
    //isOrdered MEthod to check if they are in order or not
    private boolean isOrdered(Node x, Key min, Key max) {

        if (x == null) {  //If x is null, returns true
            return true;
        }
        if (min != null && x.key.compareTo(min) <= 0) { 
            return false;
        }
        if (max != null && x.key.compareTo(max) >= 0) {
            return false;
        }
        return isOrdered(x.left, min, x.key) && isOrdered(x.right, x.key, max);
    } 

} 

public class OrderCheck {
    public static void main(String[] args) {
        
        //Implementing Scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("enter size : ");
        //Entering size
        int size = Integer.parseInt(scan.nextLine());
        System.out.println("=================================================");
        System.out.println("Enter key : ");
        //Entering a key
        String[] keyArr = new String [size];
        // Entering a value 
        int[] valueArr = new int [size];
        // Creating obj to call
        BinaryST<String,Integer> OrderedCheck = new BinaryST<String,Integer>();

        for (int i = 0; i < size; i++) {
            keyArr[i] = scan.nextLine();
            valueArr[i] = Integer.parseInt(scan.nextLine());
        
            for (int j = 0; j < size; j++) {
                OrderedCheck.put(keyArr[i],valueArr[i]);
            }
          
        }
        System.out.println("Min : " + (OrderedCheck.min()));
        System.out.println("Max : " + (OrderedCheck.max()));
        System.out.println(OrderedCheck.isOrdered());
        scan.close();
    }
}
