package data_structures;
/*
 * 1.1 Implement an algorithm to determine if a string has all 
 * unique characters. What if you cannot use additional 
 * data structures?
*/
public class exercise1 {

	public static void main(String[] args) {
		exercise1 e = new exercise1();
		String s = "kangzee";
		boolean b1 = e.isUniqueChars(s);
		boolean b2 = e.isUniqueChars_1(s);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(s.charAt(2));//test for the charAt();
	}
	
	public boolean isUniqueChars(String str){
		if(str.length() > 128)
			return false;
		boolean[] char_set = new boolean[128];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public boolean isUniqueChars_1(String str){
		int checker = 0;
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

}
