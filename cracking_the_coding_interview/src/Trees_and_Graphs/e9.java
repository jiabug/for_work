package Trees_and_Graphs;
/*
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths
 * which sum to a given value. The path does not need to start or end at the root or a leaf, but it must
 * go in a straight line down.
 */
public class e9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	void findsum(TreeNode node, int sum, int[] path, int level){
		if (node == null){
			return;
		}
		path[level] = node.data;
		int t = 0;
		for (int i = level; i >=0; i--){
			t += path[i];
			if(t == sum){
				print(path, i, level);
			}
		}
		findsum(node.left(), sum, path, level+1);
		findsum(node.right(), sum, path, level+1);
		
		path[level] = Integer.MIN_VALUE;
	}
	
	void findsum(TreeNode node, int sum){
		int depth = getdepth(node);
		int [] path = new int[depth];
		findsum(node, sum, path, 0);
	}
	
	void print(int []path, int start, int end){
		for (int i = start; i <= end; i++){
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
	
	int getdepth(TreeNode node){
		if (node == null){
			return 0;
		} else {
			return 1 + Math.max(getdepth(node.left()), getdepth(node.right()));
		}
	}
}
