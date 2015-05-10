package easy_part;

public class Excel_sheet_column_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Excel_sheet_column_number a = new Excel_sheet_column_number();
		System.out.println(a.titleToNumber("AAAA"));
		System.out.println(a.titleToNumber_Better("AAAA"));

	}

	public int titleToNumber(String s) {
        char [] arr = s.toCharArray();
        int sum = 0;
        for (int i = arr.length-1; i >= 0; i--){
        	int exp = 1;
        	for (int j = 0; j < i; j++){
        		exp *= 26;
        	}
        	sum += (arr[arr.length - i - 1] - 64) * exp;
        }
        return sum;
    }
	
	public int titleToNumber_Better(String s){
		int sum = 0;
		for (int i = 0; i < s.length(); i++){
			sum = sum * 26 + (s.charAt(i) - '@');
		}
		return sum;
	}
}
