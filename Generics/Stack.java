import java.util.*;

import javax.print.attribute.Size2DSyntax;

import jdk.nashorn.internal.runtime.PrototypeObject;

public class Stack<E>{

    private Node first = null;
    int size;

    private class Node {
        E item;
        Node next;
    }

    public int size() {
        return size;
    }

    public boolean isempty() {
        return first == null;
    }

    public void push(E item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public E pop() {
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }
}

class stacktest {
    public static void main(String[] args) {
        Stack<Integer> object = new Stack<Integer>();
        object.push(1);
        object.push(2);
        // System.out.println(object.pop());
        Integer b = object.pop();
        boolean b1 = object.isempty();
        int c = object.size();
        System.out.println(b); 
        System.out.println(b1);
        System.out.println(c);
    }
}