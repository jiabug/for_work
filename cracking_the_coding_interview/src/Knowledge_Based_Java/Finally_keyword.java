package Knowledge_Based_Java;
/*
 * the finally keyword is used in association with a try / catch block and guarantees that a section of code will be executed, even if an exception is thrown. The finally block will be
 * executed after the try and catch blocks, but before control transfers back to its origin.
 */
public class Finally_keyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bar();

	}
	public static String lem(){
		System.out.println("lem");
		return "return from lem";
	}
	
	public static String foo(){
		int x = 0;
		int y = 6;
		try {
			System.out.println("start try");
			int b = y / x;
			System.out.println("end try");
			return "returned from try";
		} catch (Exception ex) {
			System.out.println("catch");
			return lem() + "| return from catch";
		} finally {
			System.out.println("finally");
		}
	}
	
	public static void bar(){
		System.out.println("start bar");
		String v = foo();
		System.out.println(v);
		System.out.println("end bar");
		
	}

}
