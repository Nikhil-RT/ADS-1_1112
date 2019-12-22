import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {

    Node root; 
    //Node class
    class Node {
        Node left,right;
        Key key;
        Value value;

        Node (Key key, Value value) {
            this.key = key;
            this.value = value;
        }    
    }


    public void put(Key key, Value value) {
        root = put(root,key,value);
    }

    private Node put(Node x, Key key, Value value) {
        //Initially it don't have Node so creating a new Node
        if (x == null) {
            return new Node(key,value);
        }
        //Inorder to compare we use compareTo method
        int compare = key.compareTo(x.key);
        //If lesser it goes left
        if (compare < 0) {
            x.left = put(x.left,key, value);
        }
        //If greater it goes right 
        else if (compare > 0) {
            x.right = put(x.right,key,value);
        }
        //If in case, the key matches given key, it updates the value
        else if (compare == 0) {
            x.value = value;        
        }
        return x;
    }

    public Value get(Key key) {
        Node x = root;
        //Iterating loop to check entire key
        while (x != null) {

            //compareTo method to compare the key
            int compare = key.compareTo(x.key);
            //If greater, it goes to the right 
            if (compare > 0) {
                x = x.right; 
            }
            //If lesser it goes left
            else if (compare < 0) {
                x = x.left;
            }
            //If found, it will return the value
            else if (compare == 0) {
                return x.value;
            }
        }//If key is not found, it will return null
        return null;
    }

    public static void main(String[] args) {

        BST<String,Integer> obj = new BST<String,Integer>();
        obj.put("N", 1);
        obj.put("I", 2);
        obj.put("K", 3);
        obj.put("H", 4);
        obj.put("I", 5);
        obj.put("L", 6);
        System.out.println("Array Elements : ");
        System.out.println(obj.get("I"));
        System.out.println(obj.get("L"));
        System.out.println(obj.get("P"));

    }
}
