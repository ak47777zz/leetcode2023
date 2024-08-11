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
// 👍 1579, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode2.leetcode.editor.cn;
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

    // 二叉树最长路径 = max{左子树最长路径,右子树最长路径, 左子树深度 + 右子树深度}
    int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDeep(root);
        return maxPath;
    }

    // 返回这个子树的最大深度
    public int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 左子树最大深度
        int leftDeep = maxDeep(root.left);
        // 右子树最大深度
        int rightDeep = maxDeep(root.right);

        // 全局变量维护最长路径
        maxPath = Math.max(maxPath, leftDeep + rightDeep);

        return Math.max(leftDeep, rightDeep) + 1;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }