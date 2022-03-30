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
145. Binary Tree Postorder Traversal
(Left, Right, Root)
  0_
   \
0-->0

TreeNode root
root.left.value
root.right.value
root.value
*/

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> elements = new ArrayList<Integer>();
        if (root == null) {
            return elements;
        }
        
        Stack<TreeNode> treeNodes = new Stack();
        treeNodes.push(root);
        while (!treeNodes.empty()) {
            TreeNode node = treeNodes.pop();
            
            if (node.left != null) treeNodes.push(node.left);
            if (node.right != null) treeNodes.push(node.right);
            elements.add(node.val);
        }
        Collections.reverse(elements);
        return elements;
    }
    
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> elements = new ArrayList<Integer>();
        if (root == null) {
            return elements;
        }
        
        elements.addAll(postorderTraversal(root.left));
        elements.addAll(postorderTraversal(root.right));
        elements.add(root.val);
        return elements;
    }
