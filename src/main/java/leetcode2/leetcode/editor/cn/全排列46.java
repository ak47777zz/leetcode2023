//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2973, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode2.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 46:全排列
 */
public class 全排列46 {
    public static void main(String[] args) {
        Solution solution = new 全排列46().new Solution();
        solution.permute(new int[] {1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 回溯的典型题
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            boolean[] used = new boolean[nums.length];
            List<Integer> path = new ArrayList<>();
            backTracking(nums, used, path);
            return res;
        }

        /**
         * 回溯方法
         *
         * @param nums 元素全集
         * @param used 每个元素被使用的情况
         * @param path 当前已经收集到的元素
         */
        private void backTracking(int[] nums, boolean[] used, List<Integer> path) {
            // 叶子节点处, 收集到完整的一组,保存结果并返回
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 在非叶子结点处，产生不同的分支, 选择一个还未使用的数
            for (int i = 0; i < nums.length; i++) {
                // 已使用跳过
                if (used[i]) {
                    continue;
                }
                // 未使用收集
                path.add(nums[i]);
                used[i] = true;
                // 递进
                backTracking(nums, used, path);
                // 回归 需要还原状态
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                path.remove(path.size()-1);
                used[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}