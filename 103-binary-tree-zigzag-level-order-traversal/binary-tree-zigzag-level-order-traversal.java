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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Boolean isLeftToRight = true;
        TreeNode node = null;
        while(!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(q.size(), null));
            for (int i = 0; i < list.size(); i++) {
                node =q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                if (isLeftToRight) {
                    list.set(i, node.val);
                } else {
                    list.set(list.size() - i - 1, node.val);
                }
            }
            isLeftToRight = !isLeftToRight;
            res.add(list);
        }
        return res;
    }
}