package Trees_and_Graphs;
/*
 * Write an algorithm to find the 'next' node(i.e., in-order successor) of a given node in a binary
 * search tree. You may assume that each node has a link to its parent.
 */
public class e6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode inorderSucc(TreeNode n){
		if (n == null){
			return null;
		}
		
		if (n.right != null){
			return leftmost(n.right);
		} else {
			TreeNode q = n;
			TreeNode x = n.parent;
			while (q != null && x.left != q){
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	
	public TreeNode leftmost(TreeNode n){
		if (n == null){
			return null;
		}
		while (n.left !== null){
			n = n.left;
		}
		return n;
	}
}
