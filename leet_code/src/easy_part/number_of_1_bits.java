package easy_part;

/*
 * The Hamming weight of a string is the number of symbols that are different from the zero-symbol of
 *  the alphabet used. It is thus equivalent to the Hamming distance from the all-zero string of the 
 *  same length. For the most typical case, a string of bits, this is the number of 1's in the string.
 *   In this binary case, it is also called the population count, popcount or sideways sum.
 */
public class number_of_1_bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		number_of_1_bits n = new number_of_1_bits();
		System.out.println(n.hammingWeight(8));
		System.out.println(n.hammingWeight_1(8));
		System.out.println(n.hammingWeight_2(8));
		System.out.println(11/2);

	}
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
        	if (s.charAt(i) == '1'){
        		sum++;
        	}
        }
        return sum;
    }
    
    public int hammingWeight_1(int n) {
        int sum = 0;
        while (n != 0){
        	if (n % 2 != 0){
        		sum ++;
        	}
        	n /= 2;//similar >> whole bits move right one bit. if the mode 2 is 0, it implies that the bit is 0
        }
        return sum;
    }
    
    public int hammingWeight_2(int n) {
        int sum = 0;
        while (n != 0){//the difference of the last bits
        	n = n & (n-1);
        	sum++;
        }
        return sum;
    }

}
