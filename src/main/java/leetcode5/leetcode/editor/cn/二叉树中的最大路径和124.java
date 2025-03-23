  //二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树 
//
// 👍 2366, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package leetcode5.leetcode.editor.cn;

  import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;
  import leetcode4.leetcode.editor.cn.Node;

  /**
   * 124:二叉树中的最大路径和
   */
  public class 二叉树中的最大路径和124 {
      public static void main(String[] args) {
           Solution solution = new 二叉树中的最大路径和124().new Solution();
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

    int res = Integer.MIN_VALUE;

    // 作者vanilla111
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    // 返回以当前节点为端点的最大路径
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        // 最大值有以下 3 种情况
        // 1. 自己单独就是最大值
        // 2. 自己与左链相加
        // 3. 自己与右链相加
        int ret = Math.max(root.val, Math.max(leftMax, rightMax) + root.val);
        // 记录最大值
        res = Math.max(res, Math.max(ret, root.val + leftMax + rightMax));
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }