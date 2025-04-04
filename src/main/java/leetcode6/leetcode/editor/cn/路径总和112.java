package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 112:路径总和
 */
public class 路径总和112 {
    public static void main(String[] args) {
         Solution solution = new 路径总和112().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum = targetSum - root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}