package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * Given a binary tree, design an algorithm which creates linked list of all the nodes at each depth(e.g.
 * ,if you have a tree with depth D, you'll have D linked lists).
 */
public class e4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Implement this using depth first search
	 */
	public void createLevelLinkedlist(ArrayList<LinkedList<TreeNode>> lists, TreeNode root, int level){
		if (root == null){
			return;
		}
		LinkedList<TreeNode> list = null;
		if (lists.size() == level){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedlist(lists, root.leftChild(), level + 1);
		createLevelLinkedlist(lists, root.rightChild(), level + 1);
	}
	
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedlist(lists, root, 0);
		return lists;
	}
	/*
	 * Implement this using breath first search
	 */
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList_bfs(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = null;
		if (root != null){
			current.add(root);
		}
		while(!current.isEmpty()){
			lists.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>;
			for (TreeNode parent: parents){
				if (parent.leftChild() != null){
					current.add(parent.leftChild());
				}
				if (parent.rightChild() != null){
					current.add(parent.rightChild());
				}
			}
		}
		return lists;
	}

}




