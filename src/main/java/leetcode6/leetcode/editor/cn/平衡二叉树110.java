package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 110:平衡二叉树
 */
public class 平衡二叉树110 {
    public static void main(String[] args) {
        Solution solution = new 平衡二叉树110().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            int value = getHigh(root);
            return value != -1;
        }

        private int getHigh(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = getHigh(root.left);
            if (left == -1) {
                return -1;
            }

            int right = getHigh(root.right);
            if (right == -1) {
                return -1;
            }

            int diff = Math.abs(left - right);
            if (diff > 1) {
                return -1;
            }

            return Math.max(left, right) + 1;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}