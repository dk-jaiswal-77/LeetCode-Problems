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
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) {
            // curr node is a leaf node
            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            }
            // curr node is not a leaf node
            insertIntoBST(root.right, val);
            return root;
        }
        if (root.left == null) {
            root.left = new TreeNode(val);
            return root;
        }
        insertIntoBST(root.left, val);
        return root;
    }
}