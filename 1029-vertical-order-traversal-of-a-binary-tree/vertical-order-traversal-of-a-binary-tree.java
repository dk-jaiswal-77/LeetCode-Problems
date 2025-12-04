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
    private static TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mappings;
    
    private void traverseTree(TreeNode node, int vertical, int level) {
        // check if current vertical exists or not
        TreeMap<Integer, PriorityQueue<Integer>> mVertical = mappings.getOrDefault(vertical, null);
        if (mVertical == null) {
            mVertical = new TreeMap<>();
            mappings.put(vertical, mVertical);
        }
        // current vertical exists
        // check if current level exists or not in current vertical
        PriorityQueue<Integer> mLevel = mVertical.getOrDefault(level, null);
        if (mLevel == null) {
            mLevel = new PriorityQueue<>();
            mVertical.put(level, mLevel);
        }
        mLevel.offer(node.val);

        // traverse to child left and right nodes
        if (node.left != null) traverseTree(node.left, vertical - 1, level + 1);
        if (node.right != null) traverseTree(node.right, vertical + 1, level + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        mappings = new TreeMap<>();
        traverseTree(root, 0, 0);
        // form return result
        List<List<Integer>> res = new ArrayList<>();
        
        Set<Integer> verticals = mappings.keySet();
        Set<Integer> levels;
        
        Map<Integer, PriorityQueue<Integer>> v;
        for (Integer vertical: verticals) {
            v = mappings.get(vertical);
            ArrayList<Integer> list = new ArrayList<>();
            levels = v.keySet();
            for (Integer level: levels) {
                PriorityQueue<Integer> pq = v.get(level);
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
}