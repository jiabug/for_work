package Linked_Lists;
/*
 * You have two numbers represented by a linked list, where each node contains a single digit. The
 * digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 */
public class e5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Node addLists(Node l1, Node l2, int carry){
		if (l1 == null && l2 == null && carry == 0 ){
			return null;
		}
		
		Node result = new Node();
		int value = carry;
		if (l1 != null){
			value += l1.data;
		}
		if (l2 != null){
			value += l2.data;
		}
		
		result.data = value % 10;
		if (l1 != null || l2 != null){
		    Node more = addLists(l1 == null ? null : l1.next,
				                 l2 == null ? null : l2.next,
				                  value >= 10 ? 1 : 0);
		    result.setNext(more);
		}
		return result;
	}
	
	public class PartialSum{
		public Node n= null;
		public int carry = 0;
	}
	
	Node addLists(Node l1, Node l2){
		int length1 = length(l1);
		int length2 = length(l2);
		
		if (length1 > length2){
			padList(l2, length1 - length2);
		} else {
			padList(l1, length2 - length1);
		}
		
		PartialSum  sum = addHelper(l1, l2);
		
		if (sum.carry > 0){
			Node node = insertBefore(sum.n, sum.carry);
			return node;
		} else {
			return sum.n;
		}
		
	}
	
	PartialSum addHelper(Node l1, Node l2){
		if (l1 == null && l2 == null){
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = new PartialSum();
		sum = addHelper(l1.next, l2.next);
		int value = l1.data + l2.data + sum.carry;
		sum.carry = value / 10;
		Node node = insertBefore(sum.n, value % 10);
		sum.n = node;
		return sum;
		
	}
	
	void padList(Node l, int padding){
		for (int i = 0; i < padding; i++){
			Node n = new Node(0, null, null);
			l.pre = n;
			n.next = l;
			l = n;
		}
	}
	
	Node insertBefore(Node n, int digit){
		Node node = new Node(0, null ,null);
		node.data = digit;
		n.pre = node;
		node.next = n;
		return node;
	}
	
	int length(Node n){
		int i = 0;
		while (n != null){
			n = n.next;
			i++;
		}
		return i;
	}

}
