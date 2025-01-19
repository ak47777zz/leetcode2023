//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 2414, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 78:子集
 */
public class 子集78 {
    public static void main(String[] args) {
        Solution solution = new 子集78().new Solution();
        solution.subsets(new int[] {1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 回溯
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backTracking(nums, 0, new ArrayList<>(), res);
            return res;
        }

        private void backTracking(int[] nums, int startIndex,List<Integer> path, List<List<Integer>> res) {
            res.add(new ArrayList<>(path));
            // 退出条件控制
            if (startIndex >= nums.length) {
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                backTracking(nums, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}