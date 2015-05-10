package Stacks_and_Queues;

/*
 * Write a program to sort a stack in ascending order (with biggest items on top). You may use at most
 * one additional stack to hold items, but you may not copy the elements into any other data structure 
 * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class e6 {
	public static void main(String [] args){
		Stack s1 = new Stack();
		s1.push(20);
		s1.push(3);
		s1.push(42);
		s1.push(10);
		s1.push(100);
		s1.push(50);
		Stack s2 = new Stack();
		e6 e = new e6();
		s2 = e.sort1(s1);
		while(!s2.isEmpty()){
			System.out.println(s2.pop());
		}
	}
	public Stack sort(Stack s1){
		Stack s2 = new Stack();
		while (!s1.isEmpty()){
			int tmp1 = s1.pop();
			if (s2.isEmpty()){
				s2.push(tmp1);
			} else {
				int tmp2 = s2.peek();
				while(tmp1 <= tmp2 && !s2.isEmpty()){//because i have estimate the s2.isEmpty()
					tmp2 = s2.pop();
					s1.push(tmp2);
				}
				s2.push(tmp1);
			}
		}
		return s2;
	}
	
	public Stack sort1(Stack s1){
		Stack s2 = new Stack();
		while (!s1.isEmpty()){
			int tmp = s1.pop();
			while (!s2.isEmpty() && s2.peek() >= tmp){// the sequence of these two formula can not be reversed
				s1.push(s2.pop());
			}
			s2.push(tmp);
		}
		return s2;
	}
}



