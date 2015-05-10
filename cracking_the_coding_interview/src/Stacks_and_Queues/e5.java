package Stacks_and_Queues;
/*
 * Implement a Myqueue class which implements a queue using two stacks.
 */
public class e5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Myqueue{
	Stack stacknew;
	Stack stackold;
	
	public Myqueue(){
		stacknew = new Stack();
		stackold = new Stack();
	}
	
	public void add(int item){
		stacknew.push(item);
	}
	
	public void shift(){
		if (stackold.isEmpty()){
			while(!stacknew.isEmpty()){
				stackold.push(stacknew.pop());
			}
		}
	}
	
	public int peek(){
		shift();
		return stacknew.peek();
	}
	
	public int remove(){
		shift();
		return stacknew.pop();
	}
}





