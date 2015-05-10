package easy_part;

public class Reverse_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 96461;
		Reverse_Integer r = new Reverse_Integer();
	    System.out.print(r.reverse(num));
		
	}
	public int reverseBad(int x) {
        String s = Integer.toString(x);
        char [] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        char temp;

        if (x < 0){
            i++;
        }
        while (i < j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return Integer.parseInt(new String(arr));
    }
	public int reverse(int x) {//x doesn't overflow. but its reverse overflow. 
		//Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
		//so the above method already overflows in parseInt.
        long rst = 0;
        while(x != 0){
            rst = rst * 10 + x % 10;
            x = x / 10;
        }
        if (rst >= Integer.MAX_VALUE || rst <= Integer.MIN_VALUE){
        	return 0;
        } else {
            return (int)rst;
        }
    }

}
