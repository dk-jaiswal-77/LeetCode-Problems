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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        TreeNode rightmost;
        while(curr != null) {
            // case1: curr.left == null
            // just move to its right child node
            if (curr.left == null) curr = curr.right;
            else {
                // case2: curr.left exists
                // travel to the rightmost node in the left subtree
                // & create a thread from it to the right node of curr node
                // & curr.right = curr.left && curr.left == null
                rightmost = curr.left;
                while(rightmost.right != null) rightmost = rightmost.right;
                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            }
        }
    }
}