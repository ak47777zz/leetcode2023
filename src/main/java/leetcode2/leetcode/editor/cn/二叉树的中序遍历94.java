//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 2120, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 94:二叉树的中序遍历
 */
public class 二叉树的中序遍历94 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的中序遍历94().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorder(root, result);
            return result;
        }

        private void inorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}