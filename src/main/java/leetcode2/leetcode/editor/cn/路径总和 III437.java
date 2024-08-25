  //给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 1893, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode2.leetcode.editor.cn;

  import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

  /**
   * 437:路径总和 III
   */
  public class 路径总和 III437 {
      public static void main(String[] args) {
           Solution solution = new 路径总和 III437().new Solution();
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

    // 朴素做法,遍历所有节点，判断每个节点往下延伸是否存在和为目标值的路线
    int res = 0;
    int target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        dfs1(root);
        return res;
    }

    // 前序遍历二叉树所有节点
    private void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    // 判断每个节点往下延伸是否存在和为目标值的路径
    // 方法定义：root 路径走到当前节点 currentValue 路径走到当前节点路径和是多少
    private void dfs2(TreeNode root, long currentValue) {
        if (currentValue == target) {
            res++;
        }
        if (root.left != null) {
            dfs2(root.left, currentValue + root.left.val);
        }
        if (root.right != null) {
            dfs2(root.right, currentValue + root.right.val);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }