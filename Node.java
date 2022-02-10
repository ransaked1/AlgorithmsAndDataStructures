public class Node {

	int data;
	Node nextNode;

	public Node(int data) {
		this.data = data;
		this.nextNode = null;
	}

	public void print() {
		System.out.print(data + " ");
	}

	public void setNextNode(Node node) {
		this.nextNode = node;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public int getData() {
		return data;
	}
}