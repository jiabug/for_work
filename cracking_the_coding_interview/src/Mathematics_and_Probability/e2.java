package Mathematics_and_Probability;

public class e2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1234567890;
		long b = 1234567890132L;//if we do not add L, it will be false because it is int by default.
		System.out.println("Double.MAX_EXPONENT:"+Double.MAX_EXPONENT);
		System.out.println("Double.MAX_VALUE:"+Double.MAX_VALUE);
		
		
		//i++ or ++i is same for the for loop
		System.out.println("i++:");
		for (int i = 0; i < 3; i++){
			System.out.println(i);
		}
		System.out.println("++i:");
		for (int i = 0; i < 3; ++i){
			System.out.println(i);
		}
	}

}