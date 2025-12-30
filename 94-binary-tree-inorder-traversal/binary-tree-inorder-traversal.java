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
    private void createThread(TreeNode root, TreeNode toLeftOf) {
        TreeNode curr = root;
        // traverse to the rightmost node of the subtree
        while (curr.right != null) curr = curr.right;
        curr.right = toLeftOf;
    }

    private boolean doesThreadExists(TreeNode root, TreeNode toLeftOf) {
        // traverse till the rightmost node of subtree
        TreeNode curr = root;
        while (curr != null) {
            if (curr.right == toLeftOf) return true;
            curr = curr.right;
        }
        return false;
    }

    private void cutThread(TreeNode root, TreeNode toLeftOf) {
        TreeNode curr = root;
        while (curr.right != toLeftOf) curr = curr.right;
        curr.right = null;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            // case1: left subtree is null
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
                continue;
            }
            // case2: left subtree exists
            // check if left part traversed or not
            boolean threadExists = doesThreadExists(curr.left, curr);
            if (threadExists) {
                // thread exists --> traversed. so cut the thread and traverse right
                cutThread(curr.left, curr);
                res.add(curr.val);
                curr = curr.right;
                continue;
            }

            // thread does not exist --> yet to be traversed
            // create thread & traverse left
            createThread(curr.left, curr);
            curr = curr.left;
        }
        return res;
    }
}