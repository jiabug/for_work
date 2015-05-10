package Linked_Lists;

import java.util.Stack;

/*
 * Implement a function to check if a linked list is a palindrome.
 */
public class e7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean isPalindrome(Node n){
		Node slow = n;
		Node fast = n;
		
		Stack <Integer> stack = new Stack <Integer>();
		
		while (fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast != null){
			slow = slow.next;
		}
		while (slow != null){
			int temp = stack.pop();
			if (slow.data != temp){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	/*
	 * recursive method
	 */
	public class Result{
		public Node node;
		public boolean result;
		public Result(Node n, boolean r){
			n = node;
			r = result;
		}
		
		Result isPalindromeRecurse(Node head, int length){
			if (head == null || length == 0){
				return new Result(null, true);
			} else if (length == 1){
				return new Result(head.next, true);
			} else if (length == 2){
				return new Result(head.next.next, head.data == head.next.data);
			}
			Result res = isPalindromeRecurse(head.next, length - 2);
			if (res.result == false || res.node == null){/*if one pair does not match, this will return
				                  false all the time until jump out the recursive.
				                 according to the line 68, if res.node.next is the last node , it 
				                  will be null. so we should consider this situation, return true 
				                  and null*/
				return res;
			} else {
				res.result = head.data == res.node.data;
				res.node = res.node.next;
				return res;
			}
		}
		
		boolean isPalindrome(Node head){
			Result r = isPalindromRecurse(head, listSize(head));
			return r.result;
		}
	}
}
