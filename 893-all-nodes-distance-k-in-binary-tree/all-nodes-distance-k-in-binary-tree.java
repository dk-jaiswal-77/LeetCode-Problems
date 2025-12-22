/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // create mapping of each node with its parent node
        // using level order traversal
        HashMap<TreeNode, TreeNode> mappings = new HashMap<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int len;
        TreeNode node;

        while (!queue.isEmpty()) {
            len = queue.size();
            // internal loop for traversing each level
            for (int i = 0; i < len; i++) {
                node = queue.poll();
                if (node.left != null) {
                    mappings.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    mappings.put(node.right, node);
                    queue.offer(node.right);
                }
            }
        }

        // mappings to track visited nodes
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(target);
        int dist = 0;
        TreeNode parent;
        while (dist < k) {
            len = queue.size();
            for (int i = 0; i < len; i++) {
                node = queue.poll();
                if (node.left != null && !visited.getOrDefault(node.left, false)) {
                    queue.offer(node.left);
                }
                if (node.right != null && !visited.getOrDefault(node.right, false)) {
                    queue.offer(node.right);
                }
                parent = mappings.getOrDefault(node, null);
                if (parent != null && !visited.getOrDefault(parent, false)) {
                    queue.offer(parent);
                }
                visited.put(node, true);
            }
            dist++;
        }

        // forming arraylist out of queue to return ans
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll().val);
        }
        return res;
    }
}