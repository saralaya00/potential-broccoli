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
94. Binary ree Inorder TraversalT
(Left, Root, Right)
 _0
 / \_
0   0

TreeNode root
root.left.value
root.value
root.right.value
*/

class Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> elements = new ArrayList<Integer>();
        if (root == null) {
            return elements;
        }
        
        Stack<TreeNode> treeNodes = new Stack();
        TreeNode node = root;
        while (node != null || !treeNodes.empty()) {
            // Move to the leftmost element.
            while (node != null) {
                treeNodes.push(node);
                node = node.left;
            }
            
            node = treeNodes.pop();
            elements.add(node.val);
            node = node.right;
        }
        return elements;
    }
    
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> elements = new ArrayList<Integer>();
        if (root == null) {
            return elements;
        }
        
        elements.addAll(inorderTraversal(root.left));
        elements.add(root.val);
        elements.addAll(inorderTraversal(root.right));
        return elements;
    }
