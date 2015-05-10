package Trees_and_Graphs;

import java.util.LinkedList;

import leetcode.path_sum.TreeNode;
import Linked_Lists.Node;

/*
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class e2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public enum State{
	Unvisited, Visiting, Visited;
}
public boolean isRoute(Graph g, Node start, Node end){
	if (start == end){
		return true;
	}
	LinkedList <Node> p = new LinkedList<Node>();
	for (Node u : g.getNodes()){
		u.state = State.Unvisited;
	}
	start.state = State.Visiting;
	p.add(start);
	while (!p.isEmpty()){
		Node n = p.removeFirst();
		if (n != null){
		    for (Node n1 : n.getAdjacent()){
		    	if (n1.state == State.Unvisited){
		    	    if (n1 == end){
		    		    return true;
		    	    } else {
		    		    n1.state = State.Visiting;
		    		    p.addLast(n1);
		    	    }
		    	}
		    }
		    n.state = State.Visited;
		}
	}
	return true;
}
}
