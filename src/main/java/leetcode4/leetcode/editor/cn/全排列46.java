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
// 👍 3029, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode4.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 46:全排列
 */
public class 全排列46 {
    public static void main(String[] args) {
        Solution solution = new 全排列46().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;

        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            backTracking(nums, new ArrayList<>());
            return res;
        }

        private void backTracking(int[] nums, List<Integer> path) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
            }
            for (int i = 0; i < nums.length; i++) {
                if (path.contains(nums[i])) {
                    continue;
                }
                path.add(nums[i]);
                backTracking(nums, path);
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}