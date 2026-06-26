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
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1]; // 用数组存储最大直径（避免值传递问题）
        dfs(root, res); // 递归计算直径
        return res[0]; // 返回计算出的最大直径
    }

    private int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0; // 空节点返回深度 0
        }
        int left = dfs(root.left, res);  // 递归计算左子树深度
        int right = dfs(root.right, res); // 递归计算右子树深度
        
        res[0] = Math.max(res[0], left + right); // 更新最大直径（左右子树深度之和）

        return 1 + Math.max(left, right); // 返回当前节点的最大深度
    }
}

