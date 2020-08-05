import java.util.*;

public class Solution {
    
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
        
    }
    Node head = null;
    Node tail = null;
    
    private void add(int data) {
        Node newNode = new Node(data);
        
        if(head == null) {
            head = newNode;
            tail = newNode;
        }

        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void del() {

        if(head == null) {
            System.out.println("empty");
        }
        else if (head!= null) {
            head = head.next;
        }
        else {
            head = null;
            tail = null;
        }
    }

    public void iterate() {
        Node present = head;
        while (present != null) {
            System.out.println(present.data);
            present = present.next;
        }
        if (present == null) {
            System.out.println("Empty");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.add(1);
        s.add(2);
        s.add(3);
        s.del();
        s.del();
        s.del();
        s.iterate();
    }
}