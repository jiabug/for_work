package Mathematics_and_Probability;

import java.math.BigDecimal;

public class Sieve_of_Eratosthenes {
	public boolean[] findprime(int max){
		boolean [] array = new boolean[max+1];
		
		for (int i = 2; i <= max; i++){ //set all flags to true other than 0 and 1
			array[i] = true;
		}
		
		int prime = 2;
		
		while (prime <= Math.sqrt(max)){
			crossoff(prime,array);
			prime = nextprime(prime, array);
			
			if(prime >= array.length){
				break;
			}
		}
		return array;
	}
	
	public void crossoff(int prime, boolean []array){
		for(int i = prime*prime; i < array.length; i+=prime){ //can not = array.length, because the length is max+1
			                                                  //same with line 32
			array[i] = false;
		}
	}
	public int nextprime(int prime, boolean []array){
		int next = prime + 1;
		while (next < array.length && !array[next]){
			next++;
		}
		return next;
	}
	
	public static void main(String [] args) {
		boolean [] flags = new boolean[3];
		for (boolean f : flags){
			System.out.println(f);
		}
		
		double d = 0.000002e3;
		System.out.println(1.0/3.0);
		Double d1 = new Double("123.2");
		System.out.println(d1.doubleValue());
		System.out.println(Double.valueOf(d));
		
	}
	
	public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
}































