package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 124:二叉树中的最大路径和
 */
public class 二叉树中的最大路径和124 {
    public static void main(String[] args) {
         Solution solution = new 二叉树中的最大路径和124().new Solution();
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

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    // 获得以当前节点为端点的最大路径
    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);

        int ret = Math.max(root.val, Math.max(leftMax, rightMax) + root.val);

        res = Math.max(res, Math.max(ret, root.val + leftMax + rightMax));

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}