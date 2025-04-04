package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 129:求根节点到叶节点数字之和
 */
public class 求根节点到叶节点数字之和129 {
    public static void main(String[] args) {
         Solution solution = new 求根节点到叶节点数字之和129().new Solution();
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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int value) {
        if (root == null) {
            return 0;
        }

        int temp = value * 10 + root.val;

        // 叶子节点
        if (root.left == null && root.right == null) {
            return temp;
        }

        return sumNumbers(root.left, temp) + sumNumbers(root.right, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}