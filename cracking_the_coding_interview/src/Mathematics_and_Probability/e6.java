package Mathematics_and_Probability;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given a two-dimensional graph with points on it, find a line which passes the most number of points.
 */
public class e6 {
	
	public GraphLine findBest(Point [] points){
		GraphLine bestLine = null;
		int bestCount = 0;
		HashMap<Double, ArrayList<GraphLine>> linesBySlope = new HashMap<Double, ArrayList<GraphLine>>();
		
		for (int i = 0; i < points.length; i++)
			for (int j = i + 1; j < points.length; j++){
				GraphLine line = new GraphLine(points[i], points[j]);
				insertLine(linesBySlope, line);
				int count = countEquivalentLines(linesBySlope, line);
				if (count > bestCount){
					bestLine = line;
					bestCount = count;
				}
			}
		return bestLine;
	}
	
	public int countEquivalentLines(ArrayList<GraphLine> lines, GraphLine line){
		if (lines == null){
			return 0;
		}
		int count = 0;
		for (GraphLine l:lines){
			if (l.isEquivalent(line))
				count++;
			}
		return count;
	}
	
	public int countEquivalentLines(HashMap<Double, ArrayList<GraphLine>> linesBySlope, GraphLine line){
		int count = 0;
		double key = GraphLine.floorToNearEpsilon(line.slope);
		count = countEquivalentLines(linesBySlope.get(key), line) + countEquivalentLines(linesBySlope.get(key + GraphLine.epsilon), line)
				+ countEquivalentLines(linesBySlope.get(key - GraphLine.epsilon), line);
		return count;
		
	}
	
	public void insertLine(HashMap<Double, ArrayList<GraphLine>> linesBySlope, GraphLine line){
		ArrayList<GraphLine> lines = null;
		double key = GraphLine.floorToNearEpsilon(line.slope);
		if (!linesBySlope.containsKey(key)){
			lines = new ArrayList<GraphLine>();
			linesBySlope.put(key, lines);
		} else {
			lines = linesBySlope.get(key);
		}
		lines.add(line);
	}

}
