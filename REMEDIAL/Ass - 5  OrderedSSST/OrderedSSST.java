import java.util.*;

class OrderedSSST<Key,Value> {
    int n;
    Node first;

    class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderedSSST(){ }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(Key key) {
        if(key == null) throw new NoSuchElementException("It is Empty");
        return get(key) != null;    
    }

    public Value get(Key key) {
        if(key == null) throw new NoSuchElementException("It is Empty");
        for (Node x = first; x!=null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {

        if(key == null) throw new NoSuchElementException("It is Empty");
        if(value == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key,value,first);
        n++;
    }

    public void delete (Key key) {
        if(key == null) throw new NoSuchElementException("It is Empty");
        first = delete (first,key);
    }

    private Node delete(Node x, Key key) {
        if(x == null) {
            return null;
        }
        if(key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public static void main(String[] args) {
        OrderedSSST<String,Integer> obj = new OrderedSSST<String,Integer>();
        obj.put("N",1);
        obj.put("I",2);
        obj.put("K",3);
        obj.put("H",4);
        obj.put("I",5);
        obj.put("L",6);
        System.out.println(obj);
    }

}