public class LinearProbingHashST<Key extends Comparable<Key>, Value> {

    /**
     * field to store the key-value pairs in an array.
     */
    private Pair[] pair;

    /**
     * field to store the number of elements present in the array.
     */
    private int num;

    LinearProbingHashST() {
        // final int size = 20;
        pair = new Pair[20];
    }

    LinearProbingHashST(final int size) {
        pair = (Pair[]) new Comparable[size];
    }

    /**
     * function to add the given key-value pair to array.
     */
    public void put(final Key key, final Value val) {
        int position = key.hashCode() % pair.length;

        while (pair[position] != null) {
            if (pair[position].key().compareTo(key) == 0) {
                pair[position].chgValue(val);
                return;
            } else {
                if (position == pair.length - 1) {
                    position = 0;
                } else {
                    position = position + 1;
                }
            }
        }
        pair[position] = new Pair(key, val);
    }

    /**
     * function to get the value corresponding to the key specified.
     */
    public Value get(final Key key) {
        int position = key.hashCode() % pair.length;

        while (pair[position] != null) {
            if (pair[position].key().compareTo(key) == 0) {
                return (Value) pair[position].value();
            } else {
                position = position + 1;
            }
        }
        return null;
    }

    /**
     * function to delete the key-value pair from the array.
     */
    public void delete(final Key key) {
        int position = key.hashCode() % pair.length;

        while (pair[position] != null) {
            if (pair[position].key().compareTo(key) == 0) {
                pair[position] = null;
                reHash(position + 1);
            } else {
                position = position + 1;
            }
        }
    }

    /**
     * function to rearrange the key-value pairs after the deletion of a key.
     */
    private void reHash(final int startingPosition) {
        int position = startingPosition;

        while (pair[position] != null) {
            System.out.println("here");
            this.put((Key) pair[position].key(), (Value) pair[position].value());
            position = position + 1;
        }
        pair[position - 1] = null;
    }

    /**
     * function to display all the key value pairs in the array.
     */
    public void display() {
        int position = 0;

        while (position < pair.length) {
            if (pair[position] != null) {
                System.out.println(pair[position].key() + " " + pair[position].value());
            }
            position = position + 1;
        }
    }

    // The main function.
   
    public static void main(final String[] args) {
        LinearProbingHashST<String, Integer> dict = new LinearProbingHashST<String, Integer>();

        dict.put("N", 1);
        dict.put("I", 2);
        dict.put("K", 3);
        dict.put("H", 4);
        dict.put("I", 5);
        dict.put("L", 6);

        dict.display();

        System.out.println("After deletion:");
        dict.delete("H");
        dict.display();
    }
}
