//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 2759, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import leetcode2.leetcode.editor.cn.二叉树的中序遍历94.TreeNode;

/**
 * 236:二叉树的最近公共祖先
 */
public class 二叉树的最近公共祖先236 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的最近公共祖先236().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        // 通过后序遍历，由底向上遍历，把最近公共祖先传上来

        // 函数定义：判断当前节点及其子树是否包含p或q，如果有返回当前节点
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            // 当前节点就是p或q，直接返回
            if (root == p || root == q) {
                return root;
            }

            // 判断左子树是否包含p或q
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            // 判断右子树是否包含p或q
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // 左右子树都不包含p或q
            if (left == null && right == null) {
                return null;
            }
            // 右子树包含p或q
            if (left == null) {
                return right;
            }
            // 左子树包含p或q
            if (right == null) {
                return left;
            }

            // 左子树包含p或q并且右子树包含p或q， 则此节点就是p和q的最近公共祖先
            return root;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}