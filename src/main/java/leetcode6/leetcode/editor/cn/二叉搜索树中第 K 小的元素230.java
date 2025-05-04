package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 230:二叉搜索树中第 K 小的元素
 */
public class 二叉搜索树中第 K 小的元素230 {
    public static void main(String[] args) {
         Solution solution = new 二叉搜索树中第 K 小的元素230().new Solution();
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

    private int count ;
    private int res;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        inOrder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}