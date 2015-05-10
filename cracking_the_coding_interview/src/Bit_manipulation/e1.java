package Bit_manipulation;

/*
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to
 * insert M into N such that M starts at bit j and ends at bit i. You can assume that the bits j
 * through i have enough space to fit all of M. That is, if M = 10011, you can assume that there
 * are at least 5 bits between j and i. You would not, for example, have j=3 and i=2, because M could
 * not fully fit between bit 3 and bit 2.
 */
public class e1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		e1 function = new e1();
		System.out.println(Integer.toBinaryString(function.updatebits(19, 1024, 2, 6)));
		System.out.println(function.updatebits(19, 1024, 2, 6));
		System.out.println(Integer.toBinaryString(function.updatebits_my(19, 1024, 2, 6)));
		System.out.println(function.updatebits_my(19, 1024, 2, 6));

	}
	public int updatebits(int M, int N, int i, int j){
		int allones = ~0;
		// think about the j+1 and i does not add 1;
		int leftpart = allones << (j + 1);
		int rightpart = ((1<<i)-1);
		int mask = leftpart | rightpart;
		return (M<<i) | (N & mask);
	}
	
	public int updatebits_my(int M, int N, int i, int j){
		introduction intr = new introduction();
		for (int k=i+1; k<j; k++){
			N = intr.clearBit(N, k);
		}
		return N | (M<<i);
	}

}
