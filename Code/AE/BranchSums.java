import java.util.*;

class BranchSums {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  // O(n)::O(n)
  public static List<Integer> branchSums(BinaryTree root) {
		List<Integer> sums = new ArrayList<Integer>();
    helper(root, sums, 0);
    return sums;
  }
	
	public static void helper(BinaryTree root, List<Integer> sums, Integer runningSum) {
		if (root == null) 
			return;
		
		Integer newRunningSum = runningSum + root.value;
		if (root.left == null && root.right == null) {
			sums.add(newRunningSum);
		}
		
		helper(root.left, sums, newRunningSum);
		helper(root.right, sums, newRunningSum);
	}
