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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pL, int pR, int iL, int iR) {
        if (iL > iR) return null;
        if (iL == iR) {
            return new TreeNode(inorder[iL]);
        }
        TreeNode root = new TreeNode(preorder[pL]);
        int rootIdx = indexOf(root.val, inorder);
        int lCount = rootIdx - iL;
        root.left = build(preorder, inorder, pL + 1, pL + lCount, iL, rootIdx-1);
        root.right = build(preorder, inorder, pL + lCount + 1, pR, rootIdx + 1, iR);
        return root;
    }

    private int indexOf(int ele, int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele) return i;
        }
        return -1;
    }
}