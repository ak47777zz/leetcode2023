package leetcode6.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 958:二叉树的完全性检验
 */
public class 二叉树的完全性检验958 {
    public static void main(String[] args) {
         Solution solution = new 二叉树的完全性检验958().new Solution();
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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean hasNull = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (hasNull && node != null) {
                    return false;
                }
                if (node == null) {
                    hasNull = true;
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}