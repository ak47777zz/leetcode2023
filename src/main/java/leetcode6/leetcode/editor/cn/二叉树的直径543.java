package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 543:二叉树的直径
 */
public class 二叉树的直径543 {
    public static void main(String[] args) {
         Solution solution = new 二叉树的直径543().new Solution();
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

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        max(root);
        return res;
    }

    private int max(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = max(root.left);
        int right = max(root.right);

        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}