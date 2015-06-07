package Mathematics_and_Probability;

import java.math.BigDecimal;

public class e1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float x = 1.1f;
		float y = 2.222f;
		double xx = 3.564;
		double yy = 5.12;
		double x1 = 3.0;
		double y1 = 2.9;
		double x2 = 0.1111;
		BigDecimal b1 = new BigDecimal(Double.toString(xx));
		BigDecimal b2 = new BigDecimal(Double.toString(yy));
		System.out.println(x + y);
		System.out.println(xx + yy);
		System.out.println(b1.add(b2).doubleValue() + 1.0);
		System.out.println(x1-y1);
		System.out.println(x2);

	}

}
