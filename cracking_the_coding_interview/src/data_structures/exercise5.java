package data_structures;
/*
 * Implement a method to perform basic string compression using the counts of repeated
 * characters. For example, the string aabcccccaaa would become a2b1c5a3. If the 
 * "compressed" string would not become smaller than the original string, your method
 * should return the original string. You can assume the string has only upper 
 * and lower letters(a-z).
 */
public class exercise5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabcccccaaa";
		String str1 = "abc";
		exercise5 e = new exercise5();
		System.out.println(e.compressBad(str));
		System.out.println(e.compressBad(str1));
		System.out.println(e.compressBetter(str));
		System.out.println(e.compressBetter(str1));
		System.out.println(e.compressAlternate(str));
		System.out.println(e.compressAlternate(str1));
	}
	
	public String compressBad(String str){
		String temp = "";
		int count = 1;
		char c = str.charAt(0);
		for (int i = 1; i < str.length(); i++){
			if (str.charAt(i) == c){
				count++;
			} else {
				temp = temp + c + count;
				c = str.charAt(i);
				count = 1;
			}
		}
		temp = temp + c + count;
		if (str.length() < temp.length()){
			return str;
		} else {
			return temp;
		}
	}
	
	public String compressBetter(String str){
		if(countCompression(str) >= str.length()){
			return str;
		}
		StringBuffer strb = new StringBuffer();
		int count = 1;
		char c = str.charAt(0);
		for (int i = 1; i < str.length(); i++){//i begins with 1 not 0.
			if (c == str.charAt(i)){
				count++;
			}else{
				strb.append(c);
				strb.append(count);
				c = str.charAt(i);
				count = 1;
			}
		}
		strb.append(c);
		strb.append(count);
		return strb.toString();
	}
	
	public int countCompression(String str){
		if (str == null || str.isEmpty()){
			return 0;
		}
		int size = 0;
		int count=1;//count  may have two digits.
		char c = str.charAt(0);
		for (int i = 1; i < str.length(); i++){
			if(c == str.charAt(i)){
				count++;
			}else{
				size += 1 + String.valueOf(count).length();
				c = str.charAt(i);
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	public String compressAlternate(String str){
		int size = countCompression(str);
		if (size >= str.length()){
			return str;
		}
		
		int count = 1;
		char c = str.charAt(0);
		char []array = new char[size];
		int index = 0;
		for (int i = 1; i < str.length(); i++){
			if(c == str.charAt(i)){
				count++;
			}else{
				index = setChar(array, index, count, c);
				c = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(array, index, count, c);
		//return new String(array);
		return String.valueOf(array);
	}
	
	public int setChar(char[] array, int index, int count, char c){
		array[index] = c;
		index++;
		String s = String.valueOf(count);
		char [] countlength = new char[s.length()];
		countlength = s.toCharArray();
		for (char ch:countlength){
			array[index] = ch;
			index++;
		}
		return index;
	}

}
