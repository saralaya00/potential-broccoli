/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
144. Binary Tree Preorder Traversal
(Root, Left, Right)
  0
_/
0-->0

TreeNode root
root.value
root.left.value
root.right.value
*/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> elements = new ArrayList<Integer>();
        if (root == null) {
            return elements;
        }
        
        Stack<TreeNode> treeNodes = new Stack();
        treeNodes.push(root);
        
        while (!treeNodes.empty()) {
            TreeNode node = treeNodes.pop();
            elements.add(node.val);
            
            // We need to pull it out from the stack so top should be left and then right
            if (node.right != null) treeNodes.push(node.right);
            if (node.left != null) treeNodes.push(node.left);
        }
        
        return elements;
    }
    
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> elements = new ArrayList<Integer>();
        if (root == null) {
            return elements;
        }
        
        elements.add(root.val);
        elements.addAll(preorderTraversal(root.left));
        elements.addAll(preorderTraversal(root.right));
                        
        return elements;
    }
}
