package easy_part;

class ListNode{
	int val;
	ListNode next;
	ListNode(int v){
		val = v;
	}
}
public class Reverse_single_link {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverseList(ListNode head){
		ListNode before = null;
		ListNode current = head;
		while(current != null){
			ListNode  temp = current.next;
			current.next = before;
			before = current;
			current = temp;
		}
		return before;
	}

}
