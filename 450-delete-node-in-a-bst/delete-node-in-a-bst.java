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
    private void findAndDel(TreeNode curr, TreeNode parent, boolean isLeft, int key) {
        if (curr == null) return;
        if (curr.val == key) {
            if (isLeft) parent.left = delete(curr);
            else parent.right = delete(curr);
            return;
        }
        if (curr.val < key) findAndDel(curr.right, curr, false, key);
        else findAndDel(curr.left, curr, true, key);
        // if (findAndDel(curr.left, curr, true, key)) return true;
        // return findAndDel(curr.right, curr, false, key);
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            return delete(root);
        }
        // boolean found = findAndDel(root.left, root, true, key);
        // if (!found) findAndDel(root.right, root, false, key);
        if (root.val < key) findAndDel(root.right, root, false, key);
        else findAndDel(root.left, root, true, key);
        return root;
    }

    private TreeNode delete(TreeNode root) {
        if (root.left == null && root.right == null) return null;
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        // travel to the rightmost node of the left subtree && attach root.right to it
        TreeNode curr = root.left;
        while (curr.right != null) curr = curr.right;
        curr.right = root.right;
        return root.left;
    }
}