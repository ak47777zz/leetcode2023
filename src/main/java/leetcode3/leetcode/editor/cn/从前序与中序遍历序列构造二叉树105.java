  //给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 2440, 👎 0 
//
//
//
//

  
  package leetcode3.leetcode.editor.cn;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 1. 前序遍历的第一个元素为根节点
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // 2. 找到根节点在中序遍历中的位置
        int rootIndex = 0 ;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // 根节点左子树的元素个数
        int leftSize = rootIndex - inStart;


        // 2.构建左右节点
        TreeNode left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
        TreeNode right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }