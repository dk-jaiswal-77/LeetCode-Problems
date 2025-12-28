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
    private TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight, HashMap<Integer, Integer> inMappings) {
        if (inLeft > inRight) return null;
        if (inLeft == inRight) return new TreeNode(inorder[inLeft]);
        TreeNode root = new TreeNode(postorder[postRight]);
        int inRootIdx = inMappings.get(root.val);
        int rightNodesCount = inRight - inRootIdx;
        int postRightStart = postRight - rightNodesCount;
        root.left = build(inorder, postorder, inLeft, inRootIdx - 1, postLeft, postRightStart - 1, inMappings);
        root.right = build(inorder, postorder, inRootIdx + 1, inRight, postRightStart, postRight - 1, inMappings);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMappings = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMappings.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, inMappings);
    }
}