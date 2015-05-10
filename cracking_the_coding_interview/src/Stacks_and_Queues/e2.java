package Stacks_and_Queues;
/*
 * How would you design a stack which, in addition to push and pop, also has a function min which 
 * returns the minimum element? Push, pop and min should all operate in O(1) time.
 */
public class e2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class StackWithMin extends Stack <NodeWithMin>{
	public void push(int value){
		int newMin = Math.min(value, Min());
		super.push(new NodeWithMin(value, newMin));
	}
	public int Min(){
		if (this.isEmpty()){
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}
}
class NodeWithMin{
	public int value;
	public int min;
	public NodeWithMin(int v, int m){
		v = value;
		m = min;
	}
}

class StackWithMin2 extends Stack <Integer>{
	Stack <Integer> s2;
	public StackWithMin2(){
		s2 = new Stack <Integer> ();
	}
	public void push(int item){
		if (node == null){
			node.data = item;
		}
		if (item <= min()){
			s2.push(item);
		}
		super.push(item);
	}
	public Integer pop(){
		int value = super.pop();
		if (value == min()){
			value =s2.pop();
		}
		return value;
	}
	public int min(){
		if (s2.isEmpty()){
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}
