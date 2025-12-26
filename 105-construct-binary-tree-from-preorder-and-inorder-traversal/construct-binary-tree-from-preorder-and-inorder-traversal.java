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
        HashMap<Integer, Integer> inorderMappings = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMappings.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMappings);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pL, int pR, int iL, int iR, HashMap<Integer, Integer> inorderMappings) {
        if (iL > iR) return null;
        if (iL == iR) {
            return new TreeNode(inorder[iL]);
        }
        TreeNode root = new TreeNode(preorder[pL]);
        int rootIdx = inorderMappings.get(root.val);
        int lCount = rootIdx - iL;
        root.left = build(preorder, inorder, pL + 1, pL + lCount, iL, rootIdx-1, inorderMappings);
        root.right = build(preorder, inorder, pL + lCount + 1, pR, rootIdx + 1, iR, inorderMappings);
        return root;
    }
}