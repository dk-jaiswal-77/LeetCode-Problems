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
    private static void traversal(List<Integer> res, TreeNode node, int level) {
        if (node == null) return;
        if (res.size() == level) res.add(node.val);
        traversal(res, node.right, level + 1);
        traversal(res, node.left, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(res, root, 0);
        return res;
    }
}