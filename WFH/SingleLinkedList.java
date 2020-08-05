// import javax.swing.text.Position;

// import java.util.List;

public class SingleLinkedList {

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display(ListNode head) {
        ListNode current;
        
        if (head == null) {
            return;
        }
        for (current = head; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
        System.out.println(current);
    }

    public int length(ListNode head) {
        ListNode current = head;
        if (head == null) {
            return 0;
        }
        int count = 0;
        while (current!=null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public ListNode addAtStart(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
            return head;
        }    
    }

    public ListNode addAtEnd(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public ListNode addAtPosition(ListNode head, int data, int position) {

        int size = length(head);

        if (position > size + 1 || position < 1) {
            System.out.println("Invalid Position");
            return head;
        }

        ListNode newNode = new ListNode(data);
        if (position == 1) {
            newNode.next = head;
            return newNode;
        }
        else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
            return head;
        }

    }

    public ListNode delFirstNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode delLastNode(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode last = head;
        ListNode previousToLast = null;

        while (last.next != null) {
            previousToLast = last;
            last = last.next;
        }
        previousToLast.next = null;
        return last;
    }

    public ListNode delAtPosition(ListNode head, int position) {
        int size = length(head);
        if (position > size || position < 1) {
            System.out.println("Invalid Position");
            return head;
        }

        if (position == 1) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }
        else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
            current.next = null;
            return current;
        }

    }

    public boolean search(ListNode head, int key) {

        if (head == null) {
            System.out.println("No element found");
        }

        ListNode current = head;
        
        while (current != null) {
            
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int indexData(ListNode head, int key) {

        if (head == null) {
            System.out.println("No Data Available");
        }

        ListNode current = head;
        int count = 1;

        while (current != null) {
            if (current.data == key) {
                return count;
            }
            current = current.next;
            count++;
        }
        return 0;
    }

    public static void main(String[] args) {

        // create a linked list
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(11);
        ListNode third = new ListNode(12);
        //Attach thwm to form a list
        head.next = second;
        second.next = third;

        SingleLinkedList linkedList = new SingleLinkedList();
        // linkedList.display(head);
        // System.out.println();
        System.out.println();
        
        linkedList.addAtEnd(head, 14);
        System.out.println("length of LinkedList : "+linkedList.length(head));

        // linkedList.display(newHead);
        System.out.println();
        linkedList.addAtPosition(head, 13, 4);
        head = linkedList.addAtStart(head, 9);
        // System.out.println("After adding at given Position : " + newHead);
        System.out.println("Linked List data : ");
        linkedList.display(head);
        System.out.println();

        // ListNode first = linkedList.delFirstNode(head);
        // linkedList.delFirstNode(head);

        // System.out.println("First Deleted Node is : " + first.data);
        // linkedList.display(head);

        // ListNode last = linkedList.delLastNode(head);
        // System.out.println("Last Deleted Node is : " + last.data);

        ListNode Delpos = linkedList.delAtPosition(head, 3);
        System.out.println("Node deleted at given position is : "+ Delpos.data);
        System.out.println();
        System.out.println("After deleting, The Linked List Data is :");
        linkedList.display(head);
        // boolean key = linkedList.search(head, 12);
        // System.out.println("If the key is there or not : " + key);

        System.out.println();
        int key = linkedList.indexData(head, 12);
        System.out.println("`0 indicates Key is not there in data` \n The index position of given key is : " + key);
    }
}
