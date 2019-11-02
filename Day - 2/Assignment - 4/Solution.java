class Node {
    int value;
    Node next;
    Node prev;
    Node(int val) {
        this.value = val;
    }
}

class circularDouble {
    Node head;
    Node tail;

    public void add (int val) {
        Node node = new Node (val);

        if(head == null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void formCircle() {
        tail.next = head;
        head.prev = tail;
    }
}

class Solution {
	public static String Josephus(int a, int b) {
		// fill you code Here
		circularDouble cdll = new circularDouble();
		// we have head = null
		//       tail = null
		for(int i = 0; i < a; i++){
			cdll.add(i);
		}

		cdll.formCircle();
		int pos = 1;
		Node temp = cdll.head;
		int eliminated = 0;
		String toReturn = "";
		while(eliminated != a){
			temp = temp.next;
			pos++;
			if(pos == b) {
				pos = 1;
				toReturn = toReturn + temp.value + " ";
				Node prevNode = temp.prev;
				Node nextNode = temp.next;

				prevNode.next = nextNode;
				nextNode.prev = prevNode;

				eliminated++;
				temp = temp.next;
			}
		}
		return toReturn.trim();
		
	}
}