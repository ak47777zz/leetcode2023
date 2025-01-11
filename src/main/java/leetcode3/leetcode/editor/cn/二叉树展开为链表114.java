  //给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
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
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 链表 | 二叉树 
//
// 👍 1764, 👎 0 
//
//
//
//

  
  package leetcode3.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

  /**
   * 114:二叉树展开为链表
   */
  public class 二叉树展开为链表114 {
      public static void main(String[] args) {
           Solution solution = new 二叉树展开为链表114().new Solution();
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
    public void flatten(TreeNode root) {
        // 1.先前序遍历保存顺序
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);

        // 2.构造链表顺序
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.left = null;
            if (i == list.size() - 1) {
                node.right = null;
            } else {
                node.right = list.get(i + 1);
            }
        }
    }

    private void preOrder(TreeNode root , List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }