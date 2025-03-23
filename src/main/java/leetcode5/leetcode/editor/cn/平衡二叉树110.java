//给定一个二叉树，判断它是否是 平衡二叉树
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 1583, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode5.leetcode.editor.cn;

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
            return deep(root) != -1;
        }

        private int deep(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDeep = deep(root.left);
            if (leftDeep == -1) {
                return -1;
            }
            int rightDeep = deep(root.right);
            if (rightDeep == -1) {
                return -1;
            }

            if (Math.abs(leftDeep - rightDeep) > 1) {
                return -1;
            }

            return Math.max(leftDeep, rightDeep) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}