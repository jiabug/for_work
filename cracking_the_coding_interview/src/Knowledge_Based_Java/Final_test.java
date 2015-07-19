package Knowledge_Based_Java;
/*
 * introduce final type
 * http://www.cnblogs.com/dolphin0520/p/3736238.html
 */
public class Final_test {

	public static void main(String[] args) {

		String a = "hello2";
		final String b = "hello";
		String c = "hello";
		String d = b + 2;
		String e = c + 2;
		System.out.println("a == d: " + (a == d));
		System.out.println("a == \"hello2\": " + (a == "hello2"));
		System.out.println("a == e: " + (a == e));//we use new to set e because of the "+"
		System.out.println("a.equals(e): " + a.equals(e));
		System.out.println("c == b:" + c == b);
		
		
		final String f = getHello();
		String g = f + 2;
		System.out.println("a == g: " + (a == g));
		
		
		System.out.println("######################");
		
		int i = 2;
		final int j = 1;
		int k = 1;
		int result = j + 1;
		int result1 = k + 1;
		System.out.println(i == result);
		System.out.println(i == result1);
		
		
		System.out.println("######################");
		
		final Myclass my = new Myclass();
        my.i ++;
        System.out.println(my.i);
        
        System.out.println("#############the difference between final and static#######");
        
        Myclass1  my1 = new Myclass1();
        Myclass1  my2 = new Myclass1();
        
        System.out.println(my1.i);
        System.out.println(my1.j);
        System.out.println(my2.i);
        System.out.println(my2.j);
        
        
        System.out.println("######################");
        
        Myclass2 my3 = new Myclass2();
        int m = 1;
        my3.changeIntValue(m);
        System.out.println("m: " + m);
        StringBuffer str1 = new StringBuffer("hello");
        my3.changeStringValue1(str1);
        System.out.println(str1);//final doesn't stop change the value of str
        StringBuffer str2 = new StringBuffer("hello");
        my3.changeStringValue2(str2);
        System.out.println(str2);
        
	}
	
	public static String getHello(){
		return "hello";
	}
	
}
class Myclass {
	public int i = 0;
}

class Myclass1{
	public final double i = Math.random();
	public static double j = Math.random();
}

class Myclass2{
	public void changeIntValue(int i){ 
		i ++;
	}
	public void changeStringValue1(final StringBuffer str){
		str.append("world");
	}
	public void changeStringValue2(StringBuffer str){
		StringBuffer s = new StringBuffer("none");
		str = s;
	}
}
