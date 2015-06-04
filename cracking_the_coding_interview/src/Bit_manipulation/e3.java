package Bit_manipulation;
/*
 * Given a positive integer. print the next smallest and the next largest number that have the same
 * number of 1 bits in their binary representation.
 */
public class e3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		e3 e = new e3();
		System.out.println("basic,next_smallest: " + e.next_smallest(13948));
		System.out.println("better,next_smallest:" + e.next_smallest_better(13948));
		System.out.println("arith, next_smallest:" + e.next_smallest_arith(13948));
		System.out.println("basic, pre_largest: " + e.pre_largest(Integer.parseInt("10011110000011",2)));
		System.out.println("better, pre_largest:" + e.pre_largest_better(Integer.parseInt("10011110000011",2)));
		System.out.println("arith, pre_largest: " + e.pre_largest_arith(Integer.parseInt("10011110000011",2)));	
	}
		
	//Brute force approach
	public String next_smallest(int num){
		int getCount = countBit(num);
		int getNewCount = 0;
		while(getCount != getNewCount){
			num++;
			getNewCount = countBit(num);
		}
		return Integer.toBinaryString(num);
	}
	public String pre_largest(int num){
		int getCount = countBit(num);
		int getNewCount = 0;
		while(getCount != getNewCount){
			num--;
			getNewCount = countBit(num);
		}
		return Integer.toBinaryString(num);
	}
	public int countBit(int num){
		String s = Integer.toBinaryString(num);
		int count = 0;
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == '1'){// can not use "" which means string
				count++;
			}
		}
		return count;
	}
	
	//Bit manipulation approach for get next number
	public String next_smallest_better(int num){
		introduction intro = new introduction();
		int origin = num;
		int c0 = 0;
		int c1 = 0;
		
		while(((origin & 1) == 0) && origin != 0){
			c0++;
			origin >>= 1;
		}
		while((origin & 1) == 1){
			c1++;
			origin >>= 1;
		}
		if(c0 + c1 == 31 || c0 + c1 == 0){
			return "Error!";
		}
		int p = c0 + c1;
		num = intro.setBit(num, p);
		num = intro.clearBit_2(num, p-1);
		num = num | ((1<<(c1-1))-1);
		return Integer.toBinaryString(num);
	}
	public String pre_largest_better(int num){
		introduction intro = new introduction();
		int origin = num;
		int c0 = 0;
		int c1 = 0;
		
		while((origin & 1) == 1){
			c1++;
			origin >>= 1;
		}
		if(origin == 0){
			return "Error!";
		}
		while(((origin & 1) == 0) && origin != 0){
			c0++;
			origin >>= 1;
		}
		
		int p = c0 + c1;
		num = intro.clearBit(num, p);
		num = intro.clearBit_2(num, p-1);
		num = (((1<<(c1+1))-1)<<(c0-1)) | num;
		return Integer.toBinaryString(num);
	}
	
	//arithmetic approach
	public String next_smallest_arith(int num){
		int origin = num;
		int c0 = 0;
		int c1 = 0;
		
		while((origin & 1) == 0 && origin != 0){
			c0++;
			origin >>= 1;
		}
		
		while((origin & 1) == 1){
			c1++;
			origin >>= 1;
		}
		
		if((c0 + c1) == 31 || (c0 + c1) == 0){ 
			return "Error!";
		}
		
		return Integer.toBinaryString(num + (1<<c0) + (1 << (c1-1)) - 1);
	}
	
	public String pre_largest_arith(int num){
		int origin = num;
		int c0 = 0;
		int c1 = 0;
		
		while((origin & 1) == 1){
			c1++;
			origin >>= 1;
		}
		
		if(origin == 0){
			return "Errßor!";
		}
		
		while((origin & 1) == 0){
			c0++;
			origin >>= 1;
		}
		
		return Integer.toBinaryString(num - (1<<c1) - (1<<(c0-1)) + 1);
	}
}
