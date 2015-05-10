package Trees_and_Graphs;
/*
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to
 * T2. That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class e8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean containsTree(TreeNode T1, TreeNode T2){
		if (T2 == null){
			return true;
		}
		return subTree(T1, T2);
	}
	
	public boolean subTree(TreeNode T1, TreeNode T2){
		if (T1 == null){
			return false;
		}
		if (T1.data == T2.data){
			if (matchTree(T1, T2)){
				return true;
			}
		}
		return subTree(T1.left(), T2) || subTree(T1.right(), T2);
	}
	
	public boolean matchTree(TreeNode T1, TreeNode T2){
		if (T1 == null && T2 == null){
			return true;
		}
		if (T1 == null || T2 == null){
			return false;
		}
		if (T1.data != T2.data){
			return false;
		}
		return matchTree(T1.left(), T2.left()) && matchTree(T1.right(), T2.right());
	}

}
