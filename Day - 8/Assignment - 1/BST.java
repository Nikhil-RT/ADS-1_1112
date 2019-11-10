class Node<Key, Value> {
	Node left;
	Node right;
	Key key;
	Value value;
	int size;
	Node(Key key1,Value value1, int size1) {
		key = key1;
		value = value1;
		size = size1;
	}
}

class BST<Key extends Comparable<Key>, Value> {
	Node<Key, Value> root;
	BST(){
	}
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	private Node put(Node node1, Key key, Value value) {
		if(root == null) {
			return new Node(key, value, 1);
		}
		int cmp = key.compareTo((Key)node1.key);
		if(cmp < 0) {
			node1.left = put(node1.left, key, value);
		}
		else if(cmp > 0) {
			node1.right = put(node1.right, key, value);
		}
		else {
			node1.value = value;
		}
		return node1;
	}
}