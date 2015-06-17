package Mathematics_and_Probability;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Design an algorithm to find the kth number such that the only prime factors are 3, 5 and 7.
 */
public class e7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(1);
		q.offer(2);
		q.remove(1);//just remove one of the mins in one time
		System.out.println(q.contains(1));
		q.remove(1);
		System.out.println(q.contains(1));
		
		
		
		//think more about the edge numbers.......
		for (int i = 1; i < 5; i++) {
            System.out.println(i + " : " + getKthMagicNnumber(i));
        }
		
		for (int i = 1; i < 5; i++) {
            System.out.println(i + " : " + getkthMagicNumber(i));
        }

	}
	public static int removeMin(Queue<Integer> q){
		int min = q.peek();
		for (Integer temp:q){
			if (temp < min){
				min = temp;
			}
		}
		while (q.contains(min)){
			q.remove(min);//just remove one of the mins in one time
		}
		return min;
	}
	public static void addProducts(Queue<Integer> q, int k){
		q.add(k * 3);
		q.add(k * 5);
		q.add(k * 7);
	}
	public static int getKthMagicNnumber(int k){
		if (k < 0){
			return 0;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		int val = 1;
		int count = 1;
		addProducts(q, val);
		while (count < k){
			val = removeMin(q);
			addProducts(q, val);
			count++;
		}
		return val;	
	}
	
	//a better method
	public static int getkthMagicNumber(int k){
		if (k < 0){
			return 0;
		}
		int val = 0;
		
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		q3.add(1);// if k == 1, we need to return a smallest number among 1, max_value, max_value
		
		
		for (int i = 1; i <= k; i++){ // i begin with 1 not 0
			int min3 = q3.size() > 0 ? q3.peek() : Integer.MAX_VALUE;
			int min5 = q5.size() > 0 ? q5.peek() : Integer.MAX_VALUE;
			int min7 = q7.size() > 0 ? q7.peek() : Integer.MAX_VALUE;
			
			val = Math.min(min3, Math.min(min5, min7));
			
			if (val == min3){
				q3.remove();//do not forget to remove the smallest number of this queue;
				q3.add(val * 3);
				q5.add(val * 5);
				
			} else if (val == min5){
				q5.remove();
				q5.add(val * 5);
			} else {
				q7.remove();
			}
			q7.add(val * 7);
		}
		return val;
	}

}
