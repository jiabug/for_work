package Trees_and_Graphs;

import java.util.Stack;

public class Tree_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void PreOrderWithoutRecursion(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (!s.isEmpty() || root != null){
			if(root != null){
				System.out.println(root.val);
				s.push(root);
				root = root.left;
			} else {
				root = s.pop();
				root = root.right;
			}
		}
	}
	
	public void InOrderWithoutRecursion(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (!s.isEmpty() || root != null){
			if (root != null){
				s.push(root);
				root = root.left;
			} else {
				root = s.pop();
				System.out.println(root.val);
				root = root.right;
			}
		}
	}

}
