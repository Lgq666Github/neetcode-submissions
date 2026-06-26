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
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>(); // 创建一个队列用于层序遍历
        if (root != null) {
            q.add(root); // 如果root不为空，加入队列
        }
        int level = 0;
        while (!q.isEmpty()) { // 只要队列不为空，说明还有未遍历的节点
            int size = q.size(); // 当前层的节点数量
            for (int i = 0; i < size; i++) { // 遍历当前层的所有节点
                TreeNode node = q.poll(); // 取出当前层节点
                if (node.left != null) { // 如果左节点存在，加入队列
                    q.add(node.left);
                }
                if (node.right != null) { // 如果右节点存在，加入队列
                    q.add(node.right);
                }
            }
            level++; // 当前层序遍历完成，深度加1
        }
        return level;
    }
}
