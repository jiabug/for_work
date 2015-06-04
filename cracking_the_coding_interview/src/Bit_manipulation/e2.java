package Bit_manipulation;

/*
 * Given a real number between o and 1(e.g., 0.72) that is passed in as a double, print the binary
 * representation. If the number cannot be represented accurately in binary with at most 32
 * characters, print "ERROR."
 */

public class e2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		e2 printb = new e2();
		System.out.println(printb.printBinary(0.5));
		System.out.println(printb.printBinary2(0.55));
	}
	public String printBinary(double num){
		if (num >= 1 || num <= 0){
			return "ERROR!";
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while(num > 0){
			if(binary.length() >= 32){
				return "ERROR!";
			}
			num = num * 2;
			if(num >= 1){
				binary.append(1);
				num = num - 1;
			} else {
				binary.append(0);
			}
		}
		return binary.toString();
	}
	
	public String printBinary2(double num){
		if (num >= 1 || num <= 0){
			return "ERROR!";
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
	    double mask = 0.5;
		while(num > 0){
			if (binary.length() >= 32){
				return "ERROR!";
			}
			
		    if (num >= mask){
		    	binary.append(1);
		    	num = num - mask;
		    } else{
		    	binary.append(0);
		    }
		    mask /= 2;
		}
		return binary.toString();
	}

}

