package Trees_and_Graphs;
/*
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE:This is not necessarily a binary search tree.
 */
public class e7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean covers(TreeNode root, TreeNode p){
		if (root == null){
			return false;
		}
		if (root == p){
			return true;
		}
		
		return covers(root.left(), p) || covers(root.right(), p);
	}
     ////////////////////////  method  1 ////////////////////////
	public TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if (root == null){
			return null;
		}
		if (root == p || root == q){
			return root;
		}
		
		boolean is_p_left = covers(root.left(), p);
		boolean is_q_left = covers(root.left(), q);
		
		if (is_p_left != is_q_left){
			return root;
		}
		
		TreeNode child = is_p_left ? root.left():root.right();
		commonAncestorHelper(child,p,q);
	}
	
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if (!covers(root, p) || !covers(root, q)){
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}
	
	////////////////////////    Bad method   ////////////////////////
	public TreeNode commonAncestorBad(TreeNode root, TreeNode p, TreeNode q){
		if (root == null){
			return null;
		}
		if (root == q && root ==p){
			return root;
		}
		
		TreeNode x = commonAncestorBad(root.left(), p, q);
		if (x != null && x != q && x != p){
			return x;
		}
		
		TreeNode y = commonAncestorBad(root.right(), p, q);
		if (y != null && y != p && y != q){
			return y;
		}
		
		if (x != null & y != null){
			return root;
		} else if (root == q ||root == p){
			return root;
		} else{
			return x == null? y: x;
		}
	}
	
   ////////////////////////good method   ////////////////////////
	public class result{
		public TreeNode node;
		public boolean isAncestor;
		public result(TreeNode n, boolean is){
			node = n;
			isAncestor = is;
		}
	}
	
	public result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if (root == null){
			return new result(null, false);
		}
		if (root == q && root == p){
			return new result(root, true);
		}
		
		result rx = commonAncestorHelper(root.right(), p ,q);
		if(rx.isAncestor){
			return rx;
		}
		result ry = commnonAncestorHelper(root.left(), p ,q);
		if(ry.isAncestor){
			return ry;
		}
		if (rx.node != null && ry.node != null){
			return new result(root, true);
		} else if(root == q || root == p){
			boolean isAnc = rx.node != null || ry.node != null ? true : false;
			return new result(root, isAnc);
		} else {
			TreeNode temp = rx.node != null ? rx.node: ry.node;
			return new result(temp, false);
		}
	}
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		result r = commonAncestor(root, p, q);
		if(r.isAncestor){
			return r.node;
		}
		return null;
	}
	
}
