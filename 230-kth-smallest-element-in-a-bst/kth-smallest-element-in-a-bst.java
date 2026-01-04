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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int count = 0;
        while (curr != null) {
            // case_1: curr node has left child as null
            if (curr.left == null) {
                // curr node
                count++;
                if (count == k) return curr.val;
                // move to its right
                curr = curr.right;
                continue;
            }
            // case_2: curr node has left child
            // case_2_1: left part has already been visited
            if (doesThreadExist(curr.left, curr)) {
                // break existing thread
                breakThread(curr.left, curr);
                // curr node
                count++;
                if (count == k) return curr.val;
                // move to its right
                curr = curr.right;
                continue;
            }
            // case_2_2: left part has not been visited
            createThread(curr.left, curr);
            curr = curr.left;
        }
        return -1;
    }

    private boolean doesThreadExist(TreeNode node, TreeNode parent) {
        TreeNode curr = node;
        while(curr != null) {
            if (curr.right == parent) return true;
            curr = curr.right;
        }
        return false;
    }

    private void createThread(TreeNode node, TreeNode parent) {
        TreeNode curr = node;
        while (curr.right != null) curr = curr.right;
        curr.right = parent;
    }

    private void breakThread(TreeNode node, TreeNode parent) {
        TreeNode curr = node;
        while (curr.right != parent) curr = curr.right;
        curr.right = null; 
    }
}