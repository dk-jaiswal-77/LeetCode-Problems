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

class Pair {
    public int num;
    public TreeNode node;
    public Pair(int _num, TreeNode _node) {
        num = _num;
        node = _node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(0, root));

        int left = 1;
        int right;
        int maxWidth = 0;
        int len;
        Pair pair;
        int width;
        while (!queue.isEmpty()) {
            // inner loop for queing each tree level
            len = queue.size();
            for (int i = 0; i < len; i++) {
                pair = queue.poll();
                // enque its left & right children if they exists
                if (pair.node.left != null) {
                    queue.offer(new Pair((pair.num - 1) * 2 + 1, pair.node.left));
                }
                if (pair.node.right != null) {
                    queue.offer(new Pair((pair.num - 1) * 2 + 2, pair.node.right));
                }

                if (i == 0) {
                    // first node
                    left = pair.num;
                }
                if (i == len - 1) {
                    // last node
                    right = pair.num;
                    width = right - left + 1;
                    if (width > maxWidth) {
                        maxWidth = width;
                    }                   
                }
            }
        }
        return maxWidth;
    }
}