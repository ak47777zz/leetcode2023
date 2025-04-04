package leetcode6.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 105:从前序与中序遍历序列构造二叉树
 */
public class 从前序与中序遍历序列构造二叉树105 {
    public static void main(String[] args) {
        Solution solution = new 从前序与中序遍历序列构造二叉树105().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);

            // 找到 root 在中序遍历中的位置
            int index;
            for (index = inStart; index <= inEnd; index++) {
                if (inorder[index] == rootVal) {
                    break;
                }
            }

            // 左侧元素数量
            int leftNum = index - inStart;
            root.left = buildTree(preorder, preStart + 1, preStart + leftNum, inorder, inStart, index - 1);
            root.right = buildTree(preorder, preStart + leftNum + 1, preEnd, inorder, index + 1 , inEnd);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}