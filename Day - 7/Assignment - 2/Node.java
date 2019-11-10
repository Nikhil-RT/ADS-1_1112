// It is a node class
public class Node<Key extends Comparable<Key>, Value> {
	Key key;
	Value value;
	Node next = null;

	public Node(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
}