/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        // level order traversal
        TreeNode node;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            node = queue.poll();
            if (node == null) {
                res.append("#,");
                continue;
            }
            res.append("" + node.val + ",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int idx = 1;
        TreeNode parent;
        while (!queue.isEmpty()) {
            parent = queue.poll();
            // left child
            if (!arr[idx].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(arr[idx]));
                queue.offer(parent.left);
            }
            idx++;
            // if (idx >= arr.length) break;
            // right child
            if (!arr[idx].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(arr[idx]));
                queue.offer(parent.right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));