package Bit_manipulation;

import java.util.ArrayList;
import java.util.Random;

/*
 * An array A contains all the integers from 0 to n, except for one number which is missing. In this
 * problem, we cannot access an entire integer in A with a single operation. The elements of A are 
 * represented in binary, and the only operation we can use to access them is "fetch the jth bit of
 * A[i]." which takes constant time. Write code to find the missing integer. Can you do it in O(n) time?
 */
public class e7_better {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		e7_better e = new e7_better();
		Random rand = new Random(); 
        int n = rand.nextInt(300000) + 1;
        int missing = rand.nextInt(n+1);
        ArrayList<BitInteger> array = initialize(n, missing);
        System.out.println("The array contains all numbers but one from 0 to " + n + ", except for " + missing);
        
        int result = e.findMissing(array);
        if (result != missing) {
            System.out.println("Error in the algorithm!\n" + "The missing number is " + missing + ", but the algorithm reported " + result);
        } else {
            System.out.println("The missing number is " + result);
        }
	}
	
	public int findMissing(ArrayList<BitInteger> array){
		return findMissing(array,0);
	}
	
	public int findMissing(ArrayList<BitInteger> input, int column){
		if(column >= BitInteger.INTEGER_SIZE ){
			return 0;
		}
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size() / 2);
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input.size() / 2);
		
		//when we convert int to string, the significant bits do not show in string.
		for(BitInteger s:input){
			//reverse the direction of index.    do not forget minus 1
			if(s.fetch(BitInteger.INTEGER_SIZE - column - 1) == 1){
				oneBits.add(s);
			} else {
				zeroBits.add(s);
			}
		}
		if(oneBits.size() >= zeroBits.size()){
			int v = findMissing(zeroBits, column + 1);
			return (v << 1) | 0;
		} else {
			int v = findMissing(oneBits, column + 1);
			return (v << 1) | 1;
		}
	}
	public static ArrayList<BitInteger> initialize(int n, int missing) {
        BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();
        ArrayList<BitInteger> array = new ArrayList<BitInteger>();
        
        for (int i = 1; i <= n; i++) {
                array.add(new BitInteger(i == missing ? 0 : i));
        }

        // Shuffle the array once.
        for (int i = 0; i < n; i++){
            int rand = i + (int) (Math.random() * (n-i));
            array.get(i).swapValues(array.get(rand));
        }
        
        return array;
    }
}
