/**
 * 
 */
/**
 * @author jiakangze
 *
 */
package Stacks_and_Queues;
import Linked_Lists.Node;

class Stack{
	Node top;
	int pop(){
		if (top != null){
		    int item = top.data;
		    top = top.next;
		    return item;
		}
		return 0;
	}
	
	void push(int item){
		Node n = new Node(item);
		n.next = top;
		top = n;
	}
	
	int peek(){
		return top.data;
	}
	
	boolean isEmpty(){
		if (top == null){
			return true;
		} else {
			return false;
		}
	}
}

class Queue{
	Node first, last;
	
	void enqueue(int item){
		if (first == null){
			last = new Node(item);
			first = last;
		} else {
			Node n = new Node(item);
			last.next = n;
			last = n;
		}
	}
	int dequeue(){
		if (first != null){
			int item = first.data;
			first = first.next;
			if (first == null){
				last = null;// empty queue
			}
			return item;
		}
		return 0;
	}
	
}

