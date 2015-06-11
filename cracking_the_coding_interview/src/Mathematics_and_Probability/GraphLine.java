package Mathematics_and_Probability;

public class GraphLine {
	public static double epsilon = 0.0001;
	public double slope, intercept;
	private boolean infinite_slope = false;
	
	public GraphLine (Point p1, Point p2){
		if (Math.abs(p1.x - p2.x) <= epsilon){
			infinite_slope = true;
			intercept = p1.x;
		} else {
			slope = (p1.y - p2.y) / (p1.x - p2.x);
			intercept = p1.y - p1.x * slope;
		}
	}
	
	public static double floorToNearEpsilon(double d){
		int r = (int) (d / epsilon);
		return ((double) r) * epsilon;
	}
	
	public boolean isEquivalent(double a, double b){
		return Math.abs(a - b) <= epsilon;
	}
	
	public boolean isEquivalent(Object o){
		GraphLine l = (GraphLine) o;
		
		if (isEquivalent(l.slope, slope) && isEquivalent(l.intercept, intercept)
				&& infinite_slope == l.infinite_slope){
			return true;
		}
		return false;
	}

}
