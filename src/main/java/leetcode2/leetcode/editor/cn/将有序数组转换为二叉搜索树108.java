//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
// 
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
//
// Related Topics树 | 二叉搜索树 | 数组 | 分治 | 二叉树 
//
// 👍 1541, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

/**
 * 108:将有序数组转换为二叉搜索树
 */
public class 将有序数组转换为二叉搜索树108 {
    public static void main(String[] args) {
        Solution solution = new 将有序数组转换为二叉搜索树108().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        // 构造根节点
        public TreeNode build(int[] nums, int left, int right) {
            // 终止条件, right = left时只有一个元素,也是可以继续执行的
            if (right < left) {
                return null;
            }
            // 取数组的中间元素作为根节点, 如果数组长度为偶数,取中间左边为中间元素
            int mid = (left + right) / 2;

            // 构建根节点
            TreeNode root = new TreeNode(nums[mid]);

            root.left = build(nums, left, mid - 1);
            root.right = build(nums, mid + 1, right);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}