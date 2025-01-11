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
// 👍 3010, 👎 0 
//
//
//
//

package leetcode3.leetcode.editor.cn;

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

        // 标准答案看2刷的代码
        public List<List<Integer>> permute(int[] nums) {
            // 回溯，使用used数组标记
            boolean[] used = new boolean[nums.length];
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            permute(nums, used, path, res);
            return res;

        }

        private void permute(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
            // 收集到了一组结果
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 已经被使用则跳过
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                permute(nums, used, path, res);
                // 回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}