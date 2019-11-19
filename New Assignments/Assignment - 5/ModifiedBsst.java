import java.util.*;
/**
 * In the Ordered insertions. 
 * Modifying BinarySearchST so that inserting a key that is
 * Larger than all keys in the table takes constant time. 
 * @param <Key> It is the generic
 * @param <Value> It is generic
 * We use Symbol Table
 * @author Nikhil Ravi Teja
 */
class BSST<Key extends Comparable<Key>, Value> {

    Key[] keys;     //Declaring Key 
    Value[] values; //Declaring Value
    int n = 0;      //Declaring size
    
    //Constructor
    public BSST() {
        this.keys=(Key[]) new Comparable[20];
        this.values=(Value[]) new Comparable[20];
        this.n = 0;
    }

    //Method for Size
    public int size() {
        return n;
    }

    //Method for Isempty
    public boolean isEmpty() {
        return size() == 0;
    }

    //Put Method
    public void put(Key key, Value value) {

        // If the key is null, throws exception
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        // If the value is null, it returns nothing
        if (value == null) {
            // delete(key);
            return;
        }
        int i = rank(key);
        // If key is already in the table
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        // Inserting a new key-value pair
        if (n == keys.length) { //resize(2*keys.length);
        }
        else {
            for (int j = n; j > i; j--) {            
               keys[j] = keys[j - 1];
               values[j] = values[j - 1];
            }

           keys[i] = key;
           values[i] = value;
           n++;
        }

    }    
    
    public Value get(Key key) {
        // If the key is null, it throws exception
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        // If it is empty it returns null
        if (isEmpty()) {
            return null;
        }
        //It get the rank of key
        int i = rank(key);
        //if same key then,
        if (i < n && keys[i].compareTo(key) == 0) {
        // If found, then it will return value
        return values[i];
        } //if Not null
        return null;
    } 
    
    // Function for rank method
    public int rank(Key key) {
        //If key is null, throw exception.
        if (key == null) {
            throw new IllegalArgumentException(" rank() is null");
        }
        int low = 0;
        int high = n-1;
        
        while (low <= high) {
            int mid = low + (high-low)/2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0) {
                high = mid - 1;
            }
            else if (cmp > 0) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return low;
    }
}

class ModifiedBsst {
    public static void main(String[] args) {

        BSST<String,Integer> Mbsst = new BSST<String,Integer>();
            Mbsst.put("N",1);
            Mbsst.put("I",2);
            Mbsst.put("k",3);
            Mbsst.put("H",4);
            Mbsst.put("I",5);
            Mbsst.put("L",6);
            Mbsst.put("R",7);
            Mbsst.put("A",8);
            Mbsst.put("V",9);
            Mbsst.put("I",10);
            Mbsst.put("T",11);
            Mbsst.put("E",12);
            Mbsst.put("J",13);
            Mbsst.put("A",14);

        System.out.println();    
        System.out.println("=============================================================================================");
        System.out.println("Keys : "+Arrays.toString(Mbsst.keys));
        System.out.println("=============================================================================================");
        System.out.println("Values : "+Arrays.toString(Mbsst.values));
        System.out.println("=============================================================================================");
        System.out.println("Value of given key : "+ Mbsst.get("A"));
        System.out.println("======================================");
        System.out.println();

    }
}
