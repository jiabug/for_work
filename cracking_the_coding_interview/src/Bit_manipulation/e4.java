package Bit_manipulation;
/*
 * Explain what the following code does: ((n & (n-1)) == 0).
 */
public class e4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++){
			if((i & (i-1)) == 0){
			    System.out.println(i);
			}
		}
		//to check if n is a power of 2(or if n is 0)
	}

}
