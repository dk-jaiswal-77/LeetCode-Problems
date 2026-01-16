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
class BSTIterator {
    private ArrayDeque<TreeNode> stackAsc = new ArrayDeque<>();
    private ArrayDeque<TreeNode> stackDesc = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        this.pushAllAsc(root);
        this.pushAllDesc(root);
    }

    public boolean hasNext() {
        return !stackAsc.isEmpty();
    }

    public boolean hasPrevious() {
        return !stackDesc.isEmpty();
    }

    public TreeNode next() {
        TreeNode node = null;
        if (this.hasNext()) {
            node = stackAsc.pollLast();
            this.pushAllAsc(node.right);
        }
        return node;
    }

    public TreeNode previous() {
        TreeNode node = null;
        if (this.hasPrevious()) {
            node = stackDesc.pollLast();
            this.pushAllDesc(node.left);
        }
        return node;
    }

    public void pushAllAsc(TreeNode node) {
        TreeNode curr = node;
        while (curr != null) {
            stackAsc.offer(curr);
            curr = curr.left;
        }
    }

    public void pushAllDesc(TreeNode node) {
        TreeNode curr = node;
        while (curr != null) {
            stackDesc.offer(curr);
            curr = curr.right;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator it = new BSTIterator(root);
        
        TreeNode left = it.next();
        TreeNode right = it.previous();

        int sum;
        while (left.val < right.val) {
            sum = left.val + right.val;
            if (sum == k) return true;
            if (sum < k) left = it.next();
            else right = it.previous();
        }
        return false;
    }
}