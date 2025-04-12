package leetcode6.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 113:路径总和 II
 */
public class 路径总和 II113 {
    public static void main(String[] args) {
        Solution solution = new 路径总和 II113().new Solution();
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
        // 作者：liweiwei 方法 3
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            backTracking(root, targetSum, new ArrayList<>(), res);
            return res;
        }

        public void backTracking(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
            if (root == null) {
                return;
            }

            path.add(root.val);
            targetSum = targetSum - root.val;

            if (root.left == null && root.right == null && targetSum == 0) {
                res.add(new ArrayList<>(path));
                return;
            }

            if (root.left != null) {
                backTracking(root.left, targetSum, path, res);
                path.remove(path.size() - 1);
            }

            if (root.right != null) {
                backTracking(root.right, targetSum, path, res);
                path.remove(path.size() - 1);
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}