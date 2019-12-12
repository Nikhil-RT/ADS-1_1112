import java.util.*;

public class LinkedList {

    class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    Node temp;

    public LinkedList () {}

    public void addLast(int data) {

        Node newNode = new Node(data); //New Node
       
        //If head is null, new Node is created
        //and pointing to same Node
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        //pointing tail to new Node 
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }

        else {
            temp = newNode;
            head = temp;
        }
    }
    public void deleteFirst() {
        
        //If head is null, return nothing
        if (head == null) {
            System.out.println("Empty");
        }
        //If head and tail are not same, then
        // point head to next to the head
        else {
            if (head != null) {
                head = head.next;
            }
            else { //If list is habing only one Node, it will point to the null
                tail = null;
                head = null;
            }
        }
    }
    public void deleteLast() {
        //delete from last 
        if (head == null) {
            System.out.println("Empty ");
        }
        
        else {
            //If head and tail is not same then 
            if(head != tail) {
                Node current = head;
                //Iterating till last 2nd element 
                while (current.next != tail) {
                    current = current.next; //removing the last
                }
                tail = current;//last 2nd element is tail, removing link of tail
                tail.next = null;//next pointer is null
            }
            else {
                //If list having only one element
                //Both will point null
                head = null;
                tail = null;
            }
        }      
    }
    

    //It will display all the Nodes
    public void display() {
        // current node is pointing to head
        Node current = head;
        //If head is null return empty
        if (head == null){
            return;
        }
        //Iterating by pointing till the last element i.e null
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.addLast(1);
        obj.addLast(2);
        obj.addLast(3);
        obj.deleteLast();
        obj.display();
        obj.addLast(9);
        System.out.println();
        obj.display();
        // obj.display();
        obj.deleteFirst();
        System.out.println();
        obj.display();
        // obj.display();
        obj.addFirst(3);
        obj.addFirst(4);
        System.out.println();
        obj.display();
        obj.deleteFirst();
    }
}