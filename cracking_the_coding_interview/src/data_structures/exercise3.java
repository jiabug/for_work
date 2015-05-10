package data_structures;
/*
 * Given two strings, write a method to decide if one is permutation of the other.
 */
public class exercise3 {

	public static void main(String[] args) {
		exercise3 e = new exercise3();
		String s = "kangze";
		String t = "zekagn";
		System.out.println(e.permutation(s,t));//if we instantiate the e, we can use the
		                                       //non-static function. If we do not instantiate
		                                       // the object e, we should add static in 
		                                       //function sort and permutation.
		System.out.println(e.permutation_1(s,t));
	}
	
	public String sort(String s){
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public boolean permutation(String s, String t){//method 1
		if (s.length() != t.length())
			return false;
		return sort(s).equals(sort(t));
	}
	
	public boolean permutation_1(String s, String t){//method 2
		if (s.length() != t.length()){
			return false;
		}
		
		int []letters = new int[128];
		
		char[] s_array = s.toCharArray();
		for(char c : s_array){// count number of each char in s.
			letters[c]++;
		}
//		for (int j = 0; j < s.length(); j++){
//			int ch = (int)s.charAt(j);
//			letters[ch]++;
//		}
		for (int i = 0; i < t.length(); i++){
			int c = (int)t.charAt(i);
			if(--letters[c] < 0){
				return false;
			}
		}
		return true;
		
	}

}
