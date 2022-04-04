import java.util.*;

class NodeDepths {
	public static int nodeDepthsIterative(BinaryTree root) {
		// Use a stack of Struct with Node and depth
		// push root to stack
		// while stack has items
		//  pop top element
		//  sumOfDepth += top.depth
		//  For each top.left and top.right push to the stack with depth + 1
		// return sumOfDepth
  }
	
	//O(n)::O(h) average case
  public static int nodeDepthsRecursive(BinaryTree root) {
    return helper(root, 0);
  }

	public static int helper(BinaryTree root, int currentDepth) {
		if(root == null) {
			return 0;
		}
		return currentDepth + helper(root.left, currentDepth + 1) + helper(root.right, currentDepth + 1);
	}
	
  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
