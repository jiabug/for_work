package Knowledge_Based_Java;

public class e6 {

	public static void main(String[] args) {
		new e6();
		//int[] a = new int[3];
		e6 e = new e6();
		System.out.println(e.toString());
		System.out.println("##########################");
	    String str1 = "hello";
	    String str2 = "hello";
	    System.out.println(str1 == str2);
	    
	    System.out.println("##########################");
	    StringBuffer str3 = new StringBuffer("abc");
	    StringBuffer str4 = new StringBuffer("abc");
	    System.out.println(str3 == str4);
	    System.out.println(str3.equals(str4));
	    
	    System.out.println("##########################");
	    String str5 = new String("hello");
	    String str6 = new String("hello");
	    System.out.println(str5 == str6);
	    System.out.println(str5.equals(str6));
	    
	    System.out.println("##########################");
	    
		System.gc();
	}
	public void finalize() throws Throwable{
		//super.finalize();  
		System.out.println("finalize method was called!");
	}

}
