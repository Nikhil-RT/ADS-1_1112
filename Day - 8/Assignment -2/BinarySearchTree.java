import java.util.Arrays;
class BinarySearchT<Key extends Comparable <Key>, Value>{

    Key[] keys;         // keys array of type Key
    Value[] values;     // Values array of type Value.
    
    int[] right,left,main; 
    
    /** Keys and values are comparable
     */
    BinarySearchT (int size){

        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
        left  = new int[size];
        main  = new int[size];
        right = new int[size];

        for(int i =0; i < size ; i++){
            left[i] = -1;
            right[i] = -1;
        }
    }
    /**
     * which is a recursive function which calls a size(index).
     */
    public int size(){
        return size(0);
    }    
    /**
     * this is a size(index) which returns the size of the array
     */
    private int size(int index){
        if(index == -1){
            return 0;
        }
        return main[index];
    }
    /**
     * in this method key,value are inserted at the element in a order 
     */
    public void put(Key key, Value value) {

        if(key == null || value == null) throw new IllegalArgumentException();

        if(size()== keys.length){
            System.out.println("Size is full");
         return ;
        }
        put(0,key,value);
    }
    /**
     * in this method key,value are inserted at the element in a sorted (Binary form)
     * Index of the key, value pair and here we insert smaller at left, larger at right.
     * Here we are using compareTo() method
     */
    public int put(int index , Key key , Value value) {

        if ( index == -1 || keys[index] == null){
            int nextIndex = size();
            keys[nextIndex] = key;
            values[nextIndex] = value;
            main[nextIndex] = 1 ;
        return nextIndex ;

        }
        int compare = key.compareTo(keys[index]); 
        if( compare < 0){
            left[index] = put(left[index], key, value);
        }
        else if(compare > 0){
            right[index] = put(right[index], key, value);
        }
        else {
            values[index] = value;
        }
        main[index] = size(left[index]) + 1 +size( right[index]);
        return index;
    }
    /**
     * It returns the value
     */
    public Value get(Key key){
        return get(0,key);
    }
    /**
     * This is the get methods checks the left , right and the main if it
     * is achieved by using compareTo() method so that checks only the left / right array.
     */
    public Value get(int index,Key key){
            if(key == null) throw new IllegalArgumentException("call get() with a null key");
        if(index == -1){
            return null;
        }
        int cmp = key.compareTo(keys[index]);
        if(cmp < 0){
            return get(left[index], key);
        }
        else if(cmp > 0){
            return get(right[index], key);
        }
        else{
            return values[index];
        }
    }
    public String toString() {
        return Arrays.toString(keys) + "\n" + Arrays.toString(left) + "\n" + Arrays.toString(right);
    }

}
/**
 * This is the class where we are implementig the main method. 
 */
class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchT<String, Integer> BST = new BinarySearchT<String, Integer>(11);
        
            BST.put("n",0);
            BST.put("i",1);
            BST.put("k",2);
			BST.put("h",3);
			BST.put("i",0);
			BST.put("l",0);	
			System.out.println(BST.toString());
			System.out.println(BST.get("l"));
    }
}
