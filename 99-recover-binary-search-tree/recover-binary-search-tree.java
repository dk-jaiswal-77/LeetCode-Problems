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
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;

        TreeNode start = null, middle = null, end = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        
        // morris traversal
        while (curr != null) {
            if (curr.left == null) {
                // curr node
                if (curr.val < prev.val) {
                    if (start == null) {
                        // first mismatch
                        start = prev;
                        middle = curr;
                    } else {
                        // second mismatch
                        end = curr;
                    }
                }
                prev = curr;
                // move to right
                curr = curr.right;
            } else {
                // left part exists
                // check if already traversed or not
                if (leftTraversed(curr.left, curr)) {
                    // already traversed, break link
                    breakLink(curr.left, curr);
                    // curr node
                    if (curr.val < prev.val) {
                        if (start == null) {
                            // first mismatch
                            start = prev;
                            middle = curr;
                        } else {
                            // second mismatch
                            end = curr;
                        }
                    }
                    prev = curr;
                    // move to right
                    curr = curr.right;
                } else {
                    // already not traversed
                    // create link
                    createLink(curr.left, curr);
                    // then traverse left
                    curr = curr.left;
                }
            }
        }

        if (end == null) {
            // adjacent nodes are swapped
            swapNodes(start, middle);
        } else {
            // non-adjacent nodes are swapped
            swapNodes(start, end);
        }
    }

    private void swapNodes(TreeNode left, TreeNode right) {
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
    }

    private boolean leftTraversed(TreeNode node, TreeNode target) {
        TreeNode curr = node;
        while (curr != null) {
            if (curr.right == target) return true;
            curr = curr.right;
        }
        return false;
    }

    private void breakLink(TreeNode node, TreeNode target) {
        TreeNode curr = node;
        while (curr.right != target) curr = curr.right;
        curr.right = null;
    }

    private void createLink(TreeNode node, TreeNode target) {
        TreeNode curr = node;
        while (curr.right != null) curr = curr.right;
        curr.right = target;
    }
}