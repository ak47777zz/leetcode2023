//给你一棵二叉树的根节点
// root ，请你判断这棵树是否是一棵 完全二叉树 。 
//
// 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含
// 1 到
// 2ʰ 个节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，节点值为 {1} 和 {2,3} 的两层），且最后一层中的所有节点（{4,5,6}）尽可能靠左。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的节点不满足条件「节点尽可能靠左」。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 100] 内 
// 1 <= Node.val <= 1000 
// 
//
// Related Topics树 | 广度优先搜索 | 二叉树 
//
// 👍 313, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode7.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.editor.cn.将有序数组转换为二叉搜索树108.TreeNode;

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
        if (root == null) {
            return true;
        }
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