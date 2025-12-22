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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if (leftHeight == rightHeight) {
            // complete binary tree
            // apply formula
            return ((int)Math.pow(2, leftHeight)) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int findLeftHeight(TreeNode node) {
        if (node == null) return 0;
        return findLeftHeight(node.left) + 1;
    }

    private int findRightHeight(TreeNode node) {
        if (node == null) return 0;
        return findRightHeight(node.right) + 1;
    }
}