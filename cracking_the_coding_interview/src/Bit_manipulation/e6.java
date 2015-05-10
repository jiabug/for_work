package Bit_manipulation;
/*
 * Write a program to swap odd and even bits in an integer with as few instruction as possible.
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 */
public class e6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		e6 e = new e6();
		System.out.println(e.swapOddEvenBits(5));
	}
	public int swapOddEvenBits(int num){
		return ((num & 0xaaaaaaaa)>>1) | ((num & 0x55555555)<<1);
	}

}
