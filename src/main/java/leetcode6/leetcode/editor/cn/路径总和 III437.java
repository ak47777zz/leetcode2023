package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 437:路径总和 III
 */
public class 路径总和 III437 {
    public static void main(String[] args) {
        Solution solution = new 路径总和 III437().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        private int res = 0;

        public int pathSum(TreeNode root, int targetSum) {
            preOrder(root, targetSum);
            return res;
        }

        private void preOrder(TreeNode root, long targetSum) {
            if (root == null) {
                return;
            }
            dfs(root, targetSum);
            preOrder(root.left, targetSum);
            preOrder(root.right, targetSum);
        }

        private void dfs(TreeNode root, long targetSum) {
            if (root == null) {
                return;
            }
            targetSum = targetSum - root.val;
            if (targetSum == 0) {
                res++;
            }
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}