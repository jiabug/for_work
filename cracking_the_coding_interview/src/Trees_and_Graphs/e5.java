package Trees_and_Graphs;
/*
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class e5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * In-order Traversal -- 1
	 */
	public static int index = 0;
    public static void copyBST(TreeNode root, int[]array){
    	if (root == null){
    		return;
    	}
    	
    	copyBST(root.left, array);
    	array[index] = root.val;
    	index++;
    	copyBST(root.right, array);
    }
    public static boolean checkBST(TreeNode root){
    	int []arr = new int[root.size];
    	copyBST(root, arr);
    	for (int i = 0; i < root.size - 1; i++){
    		if(arr[i] >= arr[i+1]){
    			return false;
    		}
    	}
    	return true;
    }
    /*
	 * In-order Traversal -- 2
	 */
    public static Integer Last_print = null;
    public static boolean checkBST_1(TreeNode root){
    	if (root == null){
    		return true;
    	}
    	
    	if(!checkBST_1(root.left)){
    		return false;
    	}
    	
    	if(Last_print != null && Last_print >= root.val){
    		return false;
    	}
    	
    	Last_print = root.val;
    	
    	if(!checkBST(root.right)){
    		return false;
    	}
    	
    	return true;
    }
    /*
     * The Min / Max Solution
     */
    boolean checkBST_2(TreeNode n){
    	return checkBST_3(n, null, null);
    }
    boolean checkBST_3(TreeNode n, Integer min, Integer max){
    	if (n == null){
    		return true;
    	}
    	if((min != null && n.val < min) || (max != null && n.val >= max)){
    		return false;
    	}
    	if(!checkBST_3(n.left, min, n.val) || !checkBST_3(n.right, n.val, max)){
    		return false;
    	}
    	return true;
    }

}
