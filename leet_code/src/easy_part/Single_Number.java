package easy_part;

/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Single_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = new int[]{5,1,3,2,2,3,4,5,1};
		Single_Number sn = new Single_Number();
		System.out.println(sn.singleNumber(a));

	}

	public int singleNumber(int[] A) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int i = 0; i < A.length; i++) {
            rst ^= A[i];
            System.out.println(rst);
        }
        return rst;
    }
}
