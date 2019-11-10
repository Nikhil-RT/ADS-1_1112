class BinarySearchST<Key extends Comparable<Key>, Value> {

     // It Stores the keys in an array.
    private Key[] keys = (Key[]) new Comparable[20];
    //It Stores the values in an array.
    private Value[] values = (Value[]) new Comparable[20];

    // It stores the size of an array
    private int size = 0;

    // It adds the elements in an array

    public void put(final Key key, final Value value) {

        boolean add = false;
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                add = true;
                break;
            }
        }
        if (!add) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
        if (size > 1) {
            insSort();
        }
    }

    // method to sort the arrays in order.

    private void insSort() {
        for (int i = size - 1; i > 0; i--) {
            if (keys[i].compareTo(keys[i - 1]) < 0) {
                Key tempKey = keys[i];
                keys[i] = keys[i - 1];
                keys[i - 1] = tempKey;

                Value tempValue = values[i];
                values[i] = values[i - 1];
                values[i - 1] = tempValue;
            } else {
                break;
            }
        }
    }

    // the method is to know if the key is present in the array.
    
    public boolean contains(final Key key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    // this method to get the value corresponding to the key.
    
    public Value get(final Key key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    // It returns max key

    public Key max() {
        Key max = keys[0];
        for (int i = 1; i < size; i++) {
            if (max.compareTo(keys[i]) < 0) {
                max = keys[i];
            }
        }
        return max;
    }

    // method to return a key equal or less than the key.
    
    public Key floor(final Key key) {
        for (int i = size - 1; i >= 0; i--) {
            if (key.compareTo(keys[i]) >= 0) {
                return keys[i];
            }
        }
        return null;
    }

    // the number of keys less than the given key.
     
    public int rank(final Key key) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (keys[mid].compareTo(key) == 0) {
                return mid;
            } else if (keys[mid].compareTo(key) < 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // It delete the min key in the array

    public void deleteMin() {
        for (int i = 0; i < size; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        keys[size] = null;
        values[size] = null;
        size--;
    }

    // Method to return the iterable of the keys.
    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();

        for (int i = 0; i < size; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }
}