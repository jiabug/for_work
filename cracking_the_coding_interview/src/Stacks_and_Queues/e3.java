package Stacks_and_Queues;

import java.util.ArrayList;

import Linked_Lists.Node;

/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real
 * life, we would likely start a new stack when the previous stack exceeds some threshold. Implement a
 * data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and 
 * should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and 
 * SetOfStacks.pop() should behave identically to single stack(that is, pop() should return the same 
 * values as it would if there were just a single stack).
 * 
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
public class e3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SetOfStacks{
	ArrayList <Stack1> stacks = new ArrayList <Stack1>();
	public int capacity;
	public SetOfStacks(int c){
		c = capacity;
	}
	public Stack1 getLastStack(){
		if (stacks.size() == 0){
			return null;
		}
		return stacks.get(stacks.size() - 1);//array index begin at 0
	}
	
	public void push(int item){
		Stack1 stack = getLastStack();
		if (stack != null && !stack.isFull()){
			stack.push(item);
		} else {
			Stack1 stack_new = new Stack1(capacity);
			stack_new.push(item);
			stacks.add(stack_new);
		}
	}
	
	public int pop(){
		Stack1 stack = getLastStack();
		int value = stack.pop();
		if (stack.size == 0){
			stacks.remove(stacks.size() - 1);
		}
		return value;
	}
	
	public boolean isEmpty(){
		Stack1 last = getLastStack();
		return last == null || last.isEmpty();
	}
	
	public int popAt(int index){
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop){
		Stack1 stack = stacks.get(index);
		int value;
		if (removeTop){
			value = stack.pop();
		} else {
			value = stack.removeBottom();
		}
		if (stack.isEmpty()){
			stacks.remove(index);
		} else if (stacks.size() > index + 1){
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return value;
	}
}
class Stack1{
	private int capacity;
	public Node top, bottom;
	public int size = 0;
	
	public Stack1(int c){
		capacity = c;
	}
	
	public boolean isFull()
	{
		return capacity == size;
	}
	public void join(Node above, Node below){
		if (below != null){
			below.above = above;
		}
		if(above != null){
			above.below = below;
		}
	}
	
	public boolean push(int v){
		if (size >= capacity){
			return false;
		}
		size++;
		Node n = new Node(v);
		if (size == 1){
			bottom = n;
		}
		join(n, top);
		top = n;
		return true;
	}
	
	public int pop(){
		Node t = top;
		top = top.below;
		size--;
		return t.data;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int removeBottom(){
		Node b = bottom;
		bottom = bottom.above;
		if(bottom != null){
			return bottom.below = null;
		}
		size--;
		return b.data;
	}
}












