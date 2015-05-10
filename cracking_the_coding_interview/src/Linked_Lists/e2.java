package Linked_Lists;

public class e2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//method 1
	public int nthLast(Node n, int k){
		if (n == null){
			return 0;
		}
		
		int i = nthLast(n.next, k) + 1;
		if (i == k){
			System.out.println(n.data);
		}
		return i;
	}
	//method 2
	public class IntWrapper{
		public int value = 0;
	}
	
	Node nthLast2(Node head, int k, IntWrapper i){
		if (head == null){
			return null;
		}
		
		Node n = nthLast2(head.next, k, i);
		i.value = i.value + 1;
		if (i.value == k){
			return head;
		}
		return n;
	}
	//method 3
	Node nthLast3(Node head, int k){
		if (head == null || k <= 0){
			return null;
		}
		int p2 = 1;
		Node n = head;
		while (p2 < k){
			n = n.next;
			if (n == null){
				return null;
			}
			p2++;
		}
		while(n != null){
			n = n.next;
			head = head.next;
		}
		return head;
	}

}
