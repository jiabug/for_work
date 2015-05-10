package Linked_Lists;

public class Node {
	public Node next = null;
	public int data;
	public Node(){}
	public Node(int d){
		data = d;
	}
	
	void appendTotail(int d){
		Node end = new Node(d);
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
	Node deleteNode(Node head, int d){
		Node n = head;
		
		if (head.data == d){
			return head.next;
		}
		
		while(n.next != null){
			if (n.next.data == d){
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		
		return head;
	}

}
