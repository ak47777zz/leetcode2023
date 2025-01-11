//给你一棵二叉树的根节点，返回该树的 直径 。
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 1635, 👎 0 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 543:二叉树的直径
 */
public class 二叉树的直径543 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的直径543().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        root.left = left;
        root.right = new TreeNode(3);
        solution.diameterOfBinaryTree(root);

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

        // max{每个节点的最大直径 = 它左子树的深度 + 它右子树深度}
        int res = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            int i = maxDeep(root);
            return res;
        }

        /**
         * 这个树的最大深度
         *
         * @param root
         * @return
         */
        private int maxDeep(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftMax = maxDeep(root.left);
            int rightMax = maxDeep(root.right);

            res = Math.max(res, leftMax + rightMax);

            return Math.max(leftMax, rightMax) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}