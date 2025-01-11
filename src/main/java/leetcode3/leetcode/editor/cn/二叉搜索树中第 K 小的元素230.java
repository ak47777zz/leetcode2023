  //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 938, 👎 0 
//
//
//
//

  
  package leetcode3.leetcode.editor.cn;

  import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

  /**
   * 230:二叉搜索树中第 K 小的元素
   */
  public class 二叉搜索树中第 K 小的元素230 {
      public static void main(String[] args) {
           Solution solution = new 二叉搜索树中第 K 小的元素230().new Solution();
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

    // 二叉搜索树具有一个重要性质：二叉搜索树的中序遍历为递增序列。
    // 当遍历到第k个元素时，直接返回
    int res = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        kthSmallest(root);
        return res;
    }

    private void kthSmallest(TreeNode root) {
        if (root == null) {
            return;
        }
        kthSmallest(root.left);
        count --;
        if (count == 0) {
            res = root.val;
            return;
        }
        kthSmallest(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }