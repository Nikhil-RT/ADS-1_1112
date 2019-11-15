import java.util.NoSuchElementException;
/**
 * Queue implementation that uses a circular linked list,
 * which is the same as a linked list except that no links are null 
 * and the value of last.next is first when-ever the list is not empty
 * @author Nikhil Ravi Teja
 */

class Node {
    int data;
    Node next;

    //Node constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class Queue {

    // private Node tail;
    private Node tail;
    private int size; //declaring Size
    
     Queue() {
    //intializing empty queue
       this.tail = null;
        size = 0; // initialising size
    }
    //Checking if list is Empty
    public boolean isEmpty() {
        return size == 0;
    }

    //Size method
    public int size() {
        return size;
    }

    // Returning the item added least recently to the queue
    public boolean peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return size == 0;
    }

    //Adding new data in an New Node or Enqueue
    public void add(int data) { //Enqueue
        //Creating a new node
        Node newNode = new Node(data);
        
        if (size == 0) {
            tail = newNode;
            tail.next = tail;
            size++;
        }
        //the newNode will point to tail.next
        newNode.next = tail.next; 
        //The next node to the tail is pointed to newNode
        tail.next = newNode;
        //The tail is pointed to the newNode
        tail = newNode;
        //Increasing the size
        size++;
    }

    //Deleting the node
    public Node del() { //Dequeue

        if (tail == null) { 
            //throw new NoSuchElementException("Queue underflow");
            size--;
            return null;
        }

        Node newNode = tail.next; //pointing newnode to tail.next
        tail.next = newNode.next; //pointing tail next to newnode next
        size--;
        return newNode;
    }

    public static void main(String[] args) {
        Queue obj = new Queue(); //obj is the object
        obj.add(189);
        obj.add(15);
        obj.add(78);
        obj.add(9);

        System.out.println(obj.del().data);
        System.out.println(obj.del().data);
        System.out.println(obj.size());
    }
}

