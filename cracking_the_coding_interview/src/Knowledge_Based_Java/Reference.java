package Knowledge_Based_Java;

public class Reference {

	public static void main(String[] args) {
		//对于参数传递，如果是简单数据类型，那么它传递的是值拷贝，对于类的实例它传递的是类的引用。
		//需要注意的是，这条规则只适用于参数传递。
		System.out.println("####################");
		int x= 0;
		change(x);//传值
		System.out.println("x:" + x);
		
		
		System.out.println("####################");
		StringBuffer s = new StringBuffer("hello");
		change_str1(s);//传引用
		System.out.println("s:" + s);
		
		System.out.println("####################");
		//new 方法并没有改变sb指向内存的内容，而是在内从中开辟了一块新的空间存放串"hi"，同时sb指向了这块空间。
		StringBuffer str = new StringBuffer("hello");
		change_str2(str);
		System.out.println("str:" + str);
		
		
		System.out.println("####################");
		int i = 0;
		int j = 1;
		swapValue(i, j);
		System.out.println("i:" + i);
		System.out.println("j:" + j);
		
		System.out.println("####################");
		StringBuffer s1 = new StringBuffer("I am a ");
		StringBuffer s2 = s1;
		s1.append("student.");
		s1 = s2;
		System.out.println("s1:" + s1);
		
		System.out.println("####################");
		//对于函数调用，最终效果是什么完全看函数内部的实现。
		//比较标准的做法是如果会改变引用的内容，则使用void作为方法返回值，而不会改变引用内容的则在返回值中返回新的值
		String s3 = "abcdefbres";
		System.out.println("s3.replace:" + s3.replaceAll("b","B"));
		System.out.println("s3:" + s3);
		
		System.out.println("####################");
		int a;
		int b;
		StringBuffer c;
		StringBuffer d;
		a = 0;
		b = a;
		c = new StringBuffer("This is c");
		d = c;

		a = 2;
		c.append("!!");

		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
		
		System.out.println("####################");
		StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("Before change, sb = " + sb);
        changeData(sb);
        System.out.println("After changeData(n), sb = " + sb);
		
	}
	public static void change(int i){
		i++;
	}
	
	public static void change_str1(StringBuffer str){
		str.append(" world!");
	}
	
	public static void change_str2(StringBuffer str){
		str = new StringBuffer("hi");
		str.append(" world!");
	}
	
	public static void swapValue(int i, int j){
		int t;
		t = i;
		i = j;
		j = t;
	}
	
	public static void changeData(StringBuffer strBuf) {

        StringBuffer sb2 = new StringBuffer("Hi ");

        strBuf = sb2;

        sb2.append("World!");

 }

}
