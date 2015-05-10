package data_structures;
/*
 * write a method to replace all spaces in a string with'%20'. You may assume that
 * the string sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string.(Note:if
 * implementing in Java, please use a character array so that you can perform 
 * this operating in place.)
 * EXAMPLE
 * Input:"Mr John Smith    ",13
 * Output:"Mr%20John%20Smith"
 * 
 * 
 * I also implement this using c in vim
 * the code in the book is C++
 */
public class exercise4 {

	public static void main(String[] args) {
		String str = "jia kang ze ";
		int length = str.length();
		exercise4 e = new exercise4();
		
		System.out.println(e.replaceSpaces(str, length));
		System.out.println(length);
	}
	
	public String replaceSpaces(String Str, int length){
		char []str1 = Str.toCharArray();

		int spacecount=0, newlength;
		for (int i = 0; i < length; i++){
			if(str1[i] == ' '){
				spacecount++;
			}
		}
		newlength = length + spacecount*2;
		char []str = new char[newlength];
		for (int i = length - 1; i >= 0; i--){
			if(str1[i] == ' '){
				str[newlength-1] = '0';
				str[newlength-2] = '2';
				str[newlength-3] = '%';
				newlength -= 3;
			}else{
				str[newlength-1] = str1[i];
				newlength--;
			}
		}
		return new String(str);
	}

}
