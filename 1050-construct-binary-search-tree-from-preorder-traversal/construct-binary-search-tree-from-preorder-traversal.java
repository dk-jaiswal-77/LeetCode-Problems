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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, 0, preorder.length - 1);
    }

    private TreeNode bst(int[] preorder, int left, int right) {
        if (left > right) return null;
        if (left == right) new TreeNode(preorder[left]);
        TreeNode root = new TreeNode(preorder[left]);
        // find starting indx of right subtree
        int idx = left + 1;
        while (idx <= right) {
            if (preorder[idx] > preorder[left]) break;
            idx++;
        }
        // now, idx is starting of right subtree
        root.left = bst(preorder, left + 1, idx - 1);
        root.right = bst(preorder, idx, right);
        return root;
    }
}