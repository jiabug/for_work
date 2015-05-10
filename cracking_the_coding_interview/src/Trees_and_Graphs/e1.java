package Trees_and_Graphs;

import javax.swing.tree.TreeNode;

/*
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a
 * balanced tree is defined to be a tree such that the heights of the two subtrees of any node never
 * differ by more than one.
 */
public class e1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getHight(TreeNode root){
		if (root == null){
			return 0;
		}
		return Math.max(getHight(root.getChildAt(0)), getHight(root.getChildAt(1))) + 1;
	}
	public static boolean isBalanced(TreeNode root){
		if (root == null){//just left one node, so it is balanced of course.
			return true;
		}
		int diff = getHight(root.getChildAt(0)) - getHight(root.getChildAt(1));
		if (Math.abs(diff) > 1){
			return false;
		} else {
			return isBalanced(root.getChildAt(0)) && isBalanced(root.getChildAt(1));
		}
	}
	
	/*
	 * better method
	 */
	public static int checkHight(TreeNode root){
		if (root == null){
			return 0;
		}
		int leftHight = checkHight(root.getChildAt(0));
		if (leftHight == -1){
			return -1;
		}
		int rightHight = checkHight(root.getChildAt(1));
		if (rightHight == -1){
			return -1;
		}
		int diff = leftHight - rightHight;
		if (Math.abs(diff) > 1){
			return -1;
		} else {
			return Math.max(leftHight, rightHight) + 1;
		}
	}
	
	public static boolean isBalanced_1(TreeNode root){
		if (checkHight(root) == -1){
			return false;
		} else {
			return true;
		}
	}

}








