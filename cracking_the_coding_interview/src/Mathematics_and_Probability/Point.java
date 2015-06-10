package Mathematics_and_Probability;

public class Point {
	public double x;
	public double y;
	public Point (double xx, double yy){
		x = xx;
		y = yy;
	}
	public boolean isequal(Point p){
		return p.x == this.x && p.y == this.y;
	}
}
