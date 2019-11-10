import java.util.Iterator;
// import java.util.LinkedList;
class SequentialSearchST<Key extends Comparable <Key>,Value > {
    //It stores keys and their values
    private MyLinkedList list = new MyLinkedList();

    //It adds key and value pair to the list in linked list
    public void put(Key key, Value value) {
        list.add(key, value);
    }

    //It returns the value of the given key
    //as the get func returns the value of the key
    public Object get(Key key) {
        Node temp = list.contains(key);
        if (temp != null) {
            return temp.value;
        }
        return null;
    }

    //It returns the iterable of the keys using queue

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        Node current = list.head;
        while (current != null) {
            queue.enqueue((Key) current.key);
            current = current.next;
        }

        return queue;
    }    
}    