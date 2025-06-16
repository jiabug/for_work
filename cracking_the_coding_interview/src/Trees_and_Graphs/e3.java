package Trees_and_Graphs;

/*
 * Given a sorted(increasing order) array with unique integer elements, write an algorithm to create a
 * binary search tree with minimal height.
 */
public class e3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
        public TreeNode BinaryST(int arr[], int start, int end){
                if (start > end){
                        return null;
                }
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = BinaryST(arr, start, mid-1);
		n.right = BinaryST(arr, mid+1, end);
		return n;
		
	}
	public TreeNode BinaryST(int array[]){
		return BinaryST(array, 0, array.length-1);
	}
}
