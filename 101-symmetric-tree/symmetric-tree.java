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
    private static boolean traversal(TreeNode a, TreeNode b) {
        if (a == b) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        // root, left, right ----> first node
        // root, right, left ----> second node
        if (traversal(a.left, b.right)) return traversal(a.right, b.left);
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return traversal(root.left, root.right);
    }
}