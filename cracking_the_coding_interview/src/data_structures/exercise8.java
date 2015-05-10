package data_structures;
/*
 * Assume you have a method isSubstring which checks if one word is a substring of 
 * another. Given two strings, s1 and s2, write code to check if s2 is a rotation of
 * s1 using only one call to isSubstring(e.g.,"waterbottle" is a rotation of
 * "erbottlewat").
 */
public class exercise8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isRotation(String s1, String s2){
		int len = s1.length();
		if (s2.length() == len && len > 0){
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}

}
