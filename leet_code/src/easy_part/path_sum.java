package easy_part;

public class path_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	///////     good /////////
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum (root.left, sum - root.val)
            || hasPathSum(root.right, sum - root.val);
    }

	
	 /////// even if this method is so stupid, it is my idea.
	//{1,2} 0
	//{1,2,#,3,#,4,#,5}  6
	//{1} 1
	public class Solution {
		public boolean hasPathSum(TreeNode root, int sum) {
	         if (root == null){
		            return false;
		        } else if (root.left == null && root.right == null){
		            return sum == root.val;
		        } else if (root.val == sum){
		            return false;
		        }
		        int current = root.val;
		        if (root.left == null || root.right == null){
		            TreeNode temp = root.left == null? root.right:root.left;
		            return helper(temp, sum, current);
		        }
		        return helper(root.left, sum, current) || helper(root.right, sum, current);
	    }
	    public boolean helper(TreeNode root, int sum, int current){
		        current = current + root.val;
		    	
		        if (root.left == null && root.right == null){
		            return current == sum;
		        }
		        
		        if (root.left == null || root.right == null){
		            TreeNode temp = root.left == null? root.right:root.left;
		            return helper(temp, sum, current);
		        }
		        if (helper(root.left, sum, current)||helper(root.right, sum, current)){
		            return true;
		        }
		        return false;
		    }
	}
}
