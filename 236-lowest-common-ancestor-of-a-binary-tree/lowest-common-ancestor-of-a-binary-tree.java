/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left, right;
        left = lowestCommonAncestor(root.left, p, q);
        right = lowestCommonAncestor(root.right, p, q);

        if ((root == p || root == q) && ((left == p || left == q) || (right == p || right == q))) return root;
        if ((left == p || left == q) && (right == p || right == q)) return root;
        if (root == p || root == q) return root;
        return left != null ? left : right;
    }
}