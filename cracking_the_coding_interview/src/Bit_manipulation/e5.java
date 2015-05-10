package Bit_manipulation;
/*
 * Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
 */
public class e5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		e5 e = new e5();
		System.out.println(e.number_bit(29, 15));
		System.out.println(e.number_bit_better(29, 15));

	}
	
	public int number_bit(int a, int b){
		int count = 0;
		for(int i = a^b; i > 0; i >>= 1){
			count += (i & 1);
		}
		return count;
	}
	
	public int number_bit_better(int a, int b){
		int count = 0;
		for (int i = a ^ b; i > 0;i = i&(i-1)){
			count++;
		}
		return count;
	}

}
