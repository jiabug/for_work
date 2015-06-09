package Mathematics_and_Probability;
/*
 * Write methods to implement the multiply, subtract, and divide operations for integers. Use only the add operator.
 */
public class e4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Subtract:" + minus(-5,3));
		System.out.println("Multiplication:" + multiply(-5,-3));
		System.out.println("Division:" + divide(-77,-3));
	}
	
	//Minus
	public static int negate(int a){
		int neg = 0;
		int b = a < 0 ? 1 : -1;
		while (a != 0){
			a += b;
			neg += b;
		}
		return neg;
	}
	public static int minus(int a, int b){
		return a + negate(b);
	}
	public static int minus_my(int a, int b){
		int value;
		if (a >= 0){
			value = 1;
			while (a != b){
				b += value;
			}
		} else {
			value = -1;
			while (a != b){
				b += value;
			}
		}
		return value;
	}
	
	//Multiplication
	public static int multiply(int a, int b){
		if (a < b){
			return multiply(b, a);//algorithm is faster if b < a. the times of summation will be less.
		}
		int sum = 0;
		for (int i = abs(b); i > 0; i--){// consider whether we need to add the equal operator or not.
			sum += a;
		}
		if (b < 0){
			sum = negate(sum);
		}
		return sum;
	}
	public static int abs(int a){
		if (a < 0){
			a = negate(a);
		}
		return a;
	}
	
	//Division
	public static int divide(int a, int b)
	      throws java.lang.ArithmeticException {
		if (b == 0){
			throw new java.lang.ArithmeticException("error!");
		}
		int abs_a = abs(a);
		int abs_b = abs(b);
		
		int product = 0;
		while (abs_a >= abs_b){
			abs_a = minus(abs_a, abs_b);
			product = product + 1;
		}
		if ((a > 0 && b > 0) || (a < 0 && b < 0)){
			return product;
		} else {
			return negate(product);
		}
	}

}

/*
 *In tackling this problem, you should be aware of the following:
 *A logical approach of going back to what exactly multiplication and division do comes in handy. Remember that.
 *  All (good) interview problems can be approached in a logical, methodical way!
 *The interviewer is looking for this sort of logical work_your_way-through-it approach.
 *This is a great problem to demonstrate your ability to write clean code -- specifically, to show your ability to 
 *  reuse code. For example, if you were writing this solution and did not put negate in its own method, you should
 *  move it into its own method once you see that you will use it multiple times.
 *Be careful about making assumptions while coding. Do not assume that the numbers are all positive or that a is 
 *  bigger than b. 
 */

